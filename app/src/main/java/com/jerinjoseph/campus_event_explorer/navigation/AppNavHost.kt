package com.jerinjoseph.campus_event_explorer.navigation

import android.content.Context
import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.jerinjoseph.campus_event_explorer.R
import com.jerinjoseph.campus_event_explorer.data.CampusEvent
import com.jerinjoseph.campus_event_explorer.data.getCampusEvents
import com.jerinjoseph.campus_event_explorer.ui.screens.EventDetailScreen
import com.jerinjoseph.campus_event_explorer.ui.screens.EventListScreen

@Composable
fun AppNavHost(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val context = LocalContext.current
    val events = remember { getCampusEvents(context) }

    NavHost(
        navController = navController,
        startDestination = EventList,
        modifier = modifier
    ) {
        composable<EventList> {
            var query by rememberSaveable { mutableStateOf("") }
            val filteredEvents = remember(query, events) {
                events.filter {
                    it.title.contains(query, ignoreCase = true) ||
                            it.category.contains(query, ignoreCase = true)
                }
            }

            EventListScreen(
                events = filteredEvents,
                query = query,
                onQueryChange = { query = it },
                onEventSelected = { id -> navController.navigate(EventDetail(id)) }
            )
        }

        composable<EventDetail> { backStackEntry ->
            val route = backStackEntry.toRoute<EventDetail>()
            val event = events.firstOrNull { it.id == route.eventId }

            EventDetailScreen(
                event = event,
                onBack = { navController.popBackStack(EventList, inclusive = false) },
                onShare = { event?.let { shareEvent(context, it) } }
            )
        }
    }
}

private fun shareEvent(context: Context, event: CampusEvent) {
    val shareText = "${event.title} - ${event.time} - ${event.location}"
    val sendIntent = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_TEXT, shareText)
    }
    context.startActivity(
        Intent.createChooser(sendIntent, context.getString(R.string.share_event))
    )
}
package com.jerinjoseph.campus_event_explorer.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.jerinjoseph.campus_event_explorer.R
import com.jerinjoseph.campus_event_explorer.data.CampusEvent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventDetailScreen(
    event: CampusEvent?,
    onBack: () -> Unit,
    onShare: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.event_details)) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = stringResource(R.string.back)
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        if (event == null) {
            EventUnavailable(
                onReturn = onBack,
                modifier = Modifier.padding(innerPadding)
            )
        } else {
            EventDetailContent(
                event = event,
                onShare = onShare,
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}

@Composable
private fun EventDetailContent(
    event: CampusEvent,
    onShare: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 24.dp, vertical = 20.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(text = event.title, style = MaterialTheme.typography.headlineSmall)
        Text(
            text = event.category,
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.primary
        )

        DetailItem(label = stringResource(R.string.label_time), value = event.time)
        DetailItem(label = stringResource(R.string.label_location), value = event.location)
        DetailItem(label = stringResource(R.string.label_about), value = event.description)

        Spacer(modifier = Modifier.size(8.dp))

        Button(onClick = onShare, modifier = Modifier.fillMaxWidth()) {
            Icon(imageVector = Icons.Filled.Share, contentDescription = null)
            Spacer(modifier = Modifier.width(8.dp))
            Text(stringResource(R.string.share_event))
        }
    }
}

@Composable
private fun DetailItem(label: String, value: String) {
    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
        Text(
            text = label,
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Text(text = value, style = MaterialTheme.typography.bodyLarge)
    }
}

@Composable
private fun EventUnavailable(
    onReturn: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.event_unavailable),
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(modifier = Modifier.size(8.dp))
        Text(
            text = stringResource(R.string.event_unavailable_message),
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(modifier = Modifier.size(16.dp))
        Button(onClick = onReturn) {
            Text(stringResource(R.string.return_to_events))
        }
    }
}
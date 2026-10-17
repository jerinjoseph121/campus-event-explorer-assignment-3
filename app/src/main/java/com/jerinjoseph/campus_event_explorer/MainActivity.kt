package com.jerinjoseph.campus_event_explorer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.jerinjoseph.campus_event_explorer.navigation.AppNavHost
import com.jerinjoseph.campus_event_explorer.ui.theme.CampusEventExplorerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CampusEventExplorerTheme {
                AppNavHost()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CampusEventExplorerPreview() {
    CampusEventExplorerTheme {
        AppNavHost()
    }
}
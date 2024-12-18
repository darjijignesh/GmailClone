package com.jignesh.gmailclone

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.jignesh.gmailclone.components.HomeAppBar
import com.jignesh.gmailclone.ui.theme.GmailCloneTheme
import kotlinx.coroutines.CoroutineScope

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GmailCloneTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    GmailUI()
                }
            }
        }
    }
}

@Composable
fun GmailUI() {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                // Drawer contents
            }
        },
        gesturesEnabled = true
    ) {
        ScreenContent(drawerState,scope)
    }

}
@Composable
fun ScreenContent(drawerState: DrawerState, scope: CoroutineScope){


    Scaffold(
        topBar = {
            HomeAppBar(modifier = Modifier.statusBarsPadding(),drawerState,scope)
        }) { innerPadding ->
        Text(
            text = "Hello World!",
            modifier = Modifier.padding(innerPadding)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GmailCloneTheme {
        GmailUI()
    }
}
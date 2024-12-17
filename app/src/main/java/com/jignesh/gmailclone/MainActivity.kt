package com.jignesh.gmailclone

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.jignesh.gmailclone.components.HomeAppBar
import com.jignesh.gmailclone.ui.theme.GmailCloneTheme

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
    Scaffold(topBar = {
        HomeAppBar(modifier = Modifier.statusBarsPadding())
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
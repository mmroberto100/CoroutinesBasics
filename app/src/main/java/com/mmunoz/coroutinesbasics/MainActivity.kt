package com.mmunoz.coroutinesbasics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mmunoz.coroutinesbasics.ui.theme.CoroutinesBasicsTheme
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        GlobalScope.launch {
            launch {
                launch {
                    delay(1000L)
                    println("Innermost coroutine finished")
                }
                delay(500L)
                println("Middle coroutine finished")
            }
            println("Outer coroutine finished")
        }

        setContent {
            CoroutinesBasicsTheme {

            }
        }
    }
}
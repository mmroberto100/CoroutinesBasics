package com.mmunoz.coroutinesbasics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.lifecycleScope
import com.mmunoz.coroutinesbasics.ui.theme.CoroutinesBasicsTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlin.system.measureTimeMillis

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        fun CoroutineScope.sound(pace: Long, sound: String) = launch {
            while (isActive) {
                delay(pace)
                println("$sound after ${pace / 1000} seconds")
            }
        }

        lifecycleScope.launch {
            sound(1000, "Coo")
            sound(2000, "Caw")
            sound(3000, "Chirp")

            val timeMillis = measureTimeMillis {
                delay(10000)
                coroutineContext.cancelChildren()
            }
            println("Time of execution: $timeMillis")
        }

        setContent {
            CoroutinesBasicsTheme {

            }
        }
    }
}
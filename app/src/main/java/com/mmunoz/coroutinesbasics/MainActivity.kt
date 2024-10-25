package com.mmunoz.coroutinesbasics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.lifecycleScope
import com.mmunoz.coroutinesbasics.ui.theme.CoroutinesBasicsTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.system.measureTimeMillis

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        fun CoroutineScope.sound(pace: Long, sound: String) = launch {
            repeat(4) { time ->
                delay(pace)
                println("$sound at time ${time + 1} after ${pace / 1000} seconds")
            }
        }

        lifecycleScope.launch {

            val bird1 = sound(1000, "Coo")
            val bird2 = sound(2000, "Caw")
            val bird3 = sound(3000, "Chirp")

            val timeMillis = measureTimeMillis {
                bird1.join()
                bird2.join()
                bird3.join()
            }

            println("Time of execution: $timeMillis")
        }

        setContent {
            CoroutinesBasicsTheme {

            }
        }
    }
}
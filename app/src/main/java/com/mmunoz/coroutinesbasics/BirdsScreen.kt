package com.mmunoz.coroutinesbasics

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mmunoz.coroutinesbasics.ui.theme.CoroutinesBasicsTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun CoroutineScope.sound(pace: Long, sound: String) = launch {
    while (true) {
        delay(pace)
        println("$sound after ${pace / 1000} seconds")
    }
}

@Composable
fun BirdsScreen(
    modifier: Modifier = Modifier
) {
    var bird by remember {
        mutableIntStateOf(0)
    }

    LaunchedEffect(key1 = bird) {
        when(bird){
            1 -> sound(bird.toLong() * 1000, "Coo")
            2 -> sound(bird.toLong() * 1000, "Caw")
            3 -> sound(bird.toLong() * 1000, "Chirp")
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
    ){
        Button(
            modifier = Modifier
                .padding(8.dp)
                .align(Alignment.CenterHorizontally),
            onClick = { bird = 1 }
        ) {
            Text(text = "First Bird")
        }

        Button(
            modifier = Modifier
                .padding(8.dp)
                .align(Alignment.CenterHorizontally),
            onClick = { bird = 2 }
        ) {
            Text(text = "Second Bird")
        }

        Button(
            modifier = Modifier
                .padding(8.dp)
                .align(Alignment.CenterHorizontally),
            onClick = { bird = 3 }
        ) {
            Text(text = "Third Bird")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(modifier = Modifier
                .padding(8.dp)
                .align(Alignment.CenterHorizontally),
            text = when(bird){
                1 -> { "First Bird sound" }
                2 -> { "Second Bird sound" }
                3 -> { "Third Bird sound" }
                else -> { "No Bird sounds" }
        })
    }
}

@Preview
@Composable
private fun BirdScreenPreview() {
    CoroutinesBasicsTheme {
        BirdsScreen()
    }
}
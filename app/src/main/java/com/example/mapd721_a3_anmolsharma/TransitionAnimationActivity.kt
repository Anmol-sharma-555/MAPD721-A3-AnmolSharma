package com.example.mapd721_a3_anmolsharma

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mapd721_a3_anmolsharma.ui.theme.MAPD721A3AnmolSharmaTheme

class TransitionAnimationActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MAPD721A3AnmolSharmaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        TopAppBar(
                            navigationIcon = {
                                IconButton(onClick = { onBackPressed() }) {
                                    Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                                }
                            },
                            title = { Text("Transition Animation") }
                        )
                        RocketControlScreen()
                    }
                }
            }
        }
    }
}


@Composable
fun RocketControlScreen() {
    var rocketDirection by remember { mutableStateOf(0f) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        // Buttons for launch and descent
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = { rocketDirection = -2f }) {
                Text("Launch")
            }
            Button(onClick = { rocketDirection = 2f }) {
                Text("Descend")
            }
        }

        // Rocket image at the bottom of the screen
        Box(
            modifier = Modifier
                .weight(1f)
                .align(alignment = Alignment.CenterHorizontally)
                .offset(y = animateFloatAsState(targetValue = rocketDirection * 100f).value.dp)
                .size(50.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.rocket),
                contentDescription = "Rocket",
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun TransitionAnimationPreview() {
    MAPD721A3AnmolSharmaTheme {
        RocketControlScreen()
    }
}
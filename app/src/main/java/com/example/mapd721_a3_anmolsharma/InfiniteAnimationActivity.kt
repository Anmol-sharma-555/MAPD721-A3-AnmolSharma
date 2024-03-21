package com.example.mapd721_a3_anmolsharma

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.mapd721_a3_anmolsharma.ui.theme.MAPD721A3AnmolSharmaTheme
import kotlinx.coroutines.delay

class InfiniteAnimationActivity : ComponentActivity() {
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
                            title = { Text("Infinite Animation") }
                        )
                        PulsatingAnimation()
                    }
                }
            }
        }
    }
}


@Composable
fun PulsatingAnimation() {
    // Initialize the scale state
    var scale by remember { mutableStateOf(1f) }
    // Use LaunchedEffect to create a loop that updates the scale
    LaunchedEffect(Unit) {
        while (true) {
            // Gradually increase scale to 110%
            for (i in 1..10) {
                scale = lerp(1f, 1.5f, i / 10f)
                delay(50) // Wait for 50 milliseconds
            }
            // Gradually decrease scale to 100%
            for (i in 1..10) {
                scale = lerp(1.5f, 1f, i / 10f)
                delay(50) // Wait for 50 milliseconds
            }
        }
    }

    // Load the image resource
    val painter: Painter = painterResource(id = R.drawable.rocket)

    // Display the image with the animated scale
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painter,
            contentDescription = null,
            modifier = Modifier.scale(scale),
            contentScale = ContentScale.Crop
        )
    }
}


// Define the lerp function
fun lerp(start: Float, stop: Float, fraction: Float): Float {
    return start + (stop - start) * fraction
}

@Preview(showBackground = true)
@Composable
fun PulsatingAnimationPreview() {
    MAPD721A3AnmolSharmaTheme {
        PulsatingAnimation()
    }
}

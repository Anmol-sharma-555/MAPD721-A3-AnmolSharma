package com.example.mapd721_a3_anmolsharma

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mapd721_a3_anmolsharma.ui.theme.MAPD721A3AnmolSharmaTheme

class ExitAnimationActivity : ComponentActivity() {
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
                            title = { Text("Exit Animation") }
                        )
                        EnterExitAnimation()
                    }
                }
            }
        }
    }
}

@Composable
fun EnterExitAnimation() {
    // Remember the animation state
    var isEntering by remember { mutableStateOf(true) }

    // Animate the alpha value based on the isEntering state
    val animatedAlpha by animateFloatAsState(
        targetValue = if (isEntering) 1f else 0f,
        animationSpec = tween(durationMillis = 1000)
    )

    // Animate the position based on the isEntering state
    val animatedX by animateDpAsState(
        targetValue = if (isEntering) 0.dp else -200.dp, // Adjust the value as needed
        animationSpec = tween(durationMillis = 1000)
    )
    val animatedY by animateDpAsState(
        targetValue = if (isEntering) 0.dp else -200.dp, // Adjust the value as needed
        animationSpec = tween(durationMillis = 1000)
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .clickable { isEntering = !isEntering }, // Toggle animation on click
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.rocket), // Replace with your image resource
            contentDescription = "Your Image Description",
            modifier = Modifier
                .offset(x = animatedX, y = animatedY) // Apply the animated position
                .alpha(animatedAlpha) // Apply the animated alpha
        )

        Button(
            onClick = { isEntering = !isEntering }, // Toggle animation on click
            modifier = Modifier.align(Alignment.BottomCenter).padding(16.dp)
        ) {
            Text(text = if (isEntering) "Click to exit" else "Click to enter", fontSize = 18.sp)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun EnterExitAnimationPreview() {
    MAPD721A3AnmolSharmaTheme {
        EnterExitAnimation()
    }
}
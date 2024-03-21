package com.example.mapd721_a3_anmolsharma

import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mapd721_a3_anmolsharma.ui.theme.MAPD721A3AnmolSharmaTheme

@Composable
fun CenteredButtons(onButtonClick: (String) -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { onButtonClick("TransitionAnimationActivity") }) {
            Text("Go to Transition Animation")
        }
        Button(onClick = { onButtonClick("ScaleAnimationActivity") }) {
            Text("Go to Scale Animation")
        }
        Button(onClick = { onButtonClick("InfiniteAnimationActivity") }) {
            Text("Go to Infinite Animation")
        }
        Button(onClick = { onButtonClick("ExitAnimationActivity") }) {
            Text("Go to Exit Animation")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CenteredButtonsPreview() {
    MAPD721A3AnmolSharmaTheme {
        CenteredButtons {}
    }
}

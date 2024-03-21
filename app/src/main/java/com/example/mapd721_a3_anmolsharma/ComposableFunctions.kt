package com.example.mapd721_a3_anmolsharma

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.mapd721_a3_anmolsharma.ui.theme.MAPD721A3AnmolSharmaTheme


@Composable
fun CenteredButtons(onButtonClick: (String) -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { onButtonClick("TransitionAnimationActivity") },
            modifier = Modifier
                .fillMaxWidth(0.8f),
            colors = ButtonDefaults.buttonColors(Color.Gray)
        ) {
            Text("Transition Animation")
        }
        Button(
            onClick = { onButtonClick("ScaleAnimationActivity") },
            modifier = Modifier
                .fillMaxWidth(0.8f),
            colors = ButtonDefaults.buttonColors(Color.Blue)
        ) {
            Text("Scale Animation")
        }
        Button(
            onClick = { onButtonClick("InfiniteAnimationActivity") },
            modifier = Modifier
                .fillMaxWidth(0.8f),
            colors = ButtonDefaults.buttonColors(Color.Red)
        ) {
            Text("Infinite Animation")
        }
        Button(
            onClick = { onButtonClick("ExitAnimationActivity") },
            modifier = Modifier
                .fillMaxWidth(0.8f),
            colors = ButtonDefaults.buttonColors(Color.Black)
        ) {
            Text("Exit Animation")
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

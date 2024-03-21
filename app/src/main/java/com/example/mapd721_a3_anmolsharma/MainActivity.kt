package com.example.mapd721_a3_anmolsharma

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mapd721_a3_anmolsharma.ui.theme.MAPD721A3AnmolSharmaTheme
import com.example.mapd721_a3_anmolsharma.CenteredButtons


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MAPD721A3AnmolSharmaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CenteredButtons { activityName ->
                        val intent = Intent(this, Class.forName("com.example.mapd721_a3_anmolsharma.$activityName"))
                        startActivity(intent)
                    }
//                    Greeting("Android")
                }
            }
        }
    }
}
//@Composable
//fun CenteredButtons(onButtonClick: (String) -> Unit) {
//    Column(
//        modifier = Modifier.fillMaxSize(),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Button(onClick = { onButtonClick("Activity1") }) {
//            Text("Go to Activity 1")
//        }
//        Button(onClick = { onButtonClick("Activity2") }) {
//            Text("Go to Activity 2")
//        }
//        Button(onClick = { onButtonClick("Activity3") }) {
//            Text("Go to Activity 3")
//        }
//        Button(onClick = { onButtonClick("Activity4") }) {
//            Text("Go to Activity 4")
//        }
//    }
//}
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MAPD721A3AnmolSharmaTheme {
        Greeting("Android")
    }
}
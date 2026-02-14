package com.example.paineldecontrole

import android.os.Bundle
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Color
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material.*
import androidx.compose.material3.Slider
import com.example.paineldecontrole.ui.theme.PAINELDECONTROLETheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PAINELDECONTROLETheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .safeDrawingPadding(),
        color = Color(0xFF0B0F1A)
    ) {
        Box(contentAlignment = Alignment.Center) {
            Surface(
                modifier = Modifier
                    .width(360.dp)
                    .padding(24.dp)
                    .height(360.dp),
                shape = RoundedCornerShape(24.dp),
                shadowElevation = 12.dp,
                color = Color(0xFF1C2230)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {

                    var combustivel by remember { mutableStateOf(0.6f) }

                    Text(text = "Combustível")

                    LinearProgressIndicator(
                        progress = combustivel,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(12.dp),
                        color = when {
                            combustivel > 0.5f -> Color(0xFF4CAF50)
                            combustivel > 0.2f -> Color(0xFFFFC107)
                            combustivel > 0.25 -> Color(0xFFFF9800)
                            else -> Color(0xFFF44336)
                        }
                    )

                    var potencia by remember { mutableStateOf(80f) }
                    Text(text = "Potência: ${potencia.toInt()}%" )
                    Slider(
                        value = potencia,
                        onValueChange = {potencia = it},
                        valueRange = 0f..100f,

                    )
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PAINELDECONTROLETheme {
        Greeting("Android")
    }
}
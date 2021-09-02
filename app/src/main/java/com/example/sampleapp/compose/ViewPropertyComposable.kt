package com.example.sampleapp.compose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun GreetingText(name: String) {
    Text(
        "Hello $name!",
        modifier = Modifier
            .clickable(onClick = {
            })
            .padding(all = 24.dp)
            .height(240.dp)
            .width(200.dp),
        style = MaterialTheme.typography.h5,
        fontWeight = FontWeight.SemiBold
    )

}

@Composable
fun GreetingButton() {
    Button(onClick = { }) {
        GreetingText("button")
        // GreetingText("Second button")
    }

}

@Preview(
    showBackground = true,
)
@Composable
fun DefaultPreviewGreetingButton() {

    GreetingText("World")
}

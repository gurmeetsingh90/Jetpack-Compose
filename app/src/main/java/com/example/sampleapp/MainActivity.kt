package com.example.sampleapp

import android.content.res.Configuration
import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.example.sampleapp.compose.GreetingButton
import com.example.sampleapp.compose.MessageCard
import com.example.sampleapp.model.Message
import com.example.sampleapp.ui.theme.SampleAppTheme
import com.microsoft.appcenter.AppCenter;
import com.microsoft.appcenter.analytics.Analytics;
import com.microsoft.appcenter.crashes.Crashes;

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // List View
            SampleAppTheme {
                conversation(message = SampleData.conversationSample)
            }
            // Item Card View
            SampleAppTheme {
                MessageCard(Message("Android", "Jetpack Compose"))
            }
       // Text View with some property
            SampleAppTheme {
                GreetingButton()
            }
        }
        AppCenter.start(
            application, "889accac-ff0e-49a1-8451-936021b4108b",
            Analytics::class.java, Crashes::class.java
        )

    }
}





package com.example.sampleapp

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import com.example.sampleapp.compose.MessageCard
import com.example.sampleapp.model.Message
import com.example.sampleapp.ui.theme.SampleAppTheme

@Composable
fun conversation(message: List<Message>) {

    LazyColumn {
        items(message) { message ->
            MessageCard(msg = message)
        }
    }
}

@Preview
@Composable
fun previewConversation() {

    SampleAppTheme {
        conversation(message = SampleData.conversationSample)
    }
}


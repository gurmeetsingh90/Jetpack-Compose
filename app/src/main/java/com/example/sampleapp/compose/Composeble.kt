package com.example.sampleapp

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sampleapp.model.Message

import androidx.compose.material.Text
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
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

@Composable
fun MessageCard(msg: Message) {

    Row(Modifier.padding(all = 5.dp)) {

        Image(
            painterResource(id = R.drawable.capture),
            "This is Default Image",
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)
        )
        var isExpandable by remember {
            mutableStateOf(false)
        }

        // surfaceColor will be updated gradually from one color to the other
        val surfaceColor: Color by animateColorAsState(
            if (isExpandable) MaterialTheme.colors.primary else MaterialTheme.colors.surface,
        )


        Spacer(modifier = Modifier.height(5.dp))
        Column(modifier = Modifier.clickable { isExpandable = !isExpandable }) {
            Text(
                text = msg.author,
                color = MaterialTheme.colors.secondaryVariant
            )
            Spacer(modifier = Modifier.height(5.dp))


            Surface(
                shape = MaterialTheme.shapes.small,
                elevation = 4.dp,
                // surfaceColor color will be changing gradually from primary to surface
                color = surfaceColor,
                // animateContentSize will change the Surface size gradually
                modifier = Modifier
                    .animateContentSize()
                    .padding(1.dp)
            ) {
                Text(
                    text = msg.body,
                    modifier = Modifier.padding(4.dp),
                    // If the message is expanded, we display all its content
                    // otherwise we only display the first line
                    maxLines = if (isExpandable) Int.MAX_VALUE else 1,
                    style = MaterialTheme.typography.body2
                )
            }
        }
    }

}
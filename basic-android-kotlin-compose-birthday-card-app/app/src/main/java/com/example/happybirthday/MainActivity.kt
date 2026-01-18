/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.happybirthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happybirthday.ui.theme.HappyBirthdayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Apply the app's theme
            HappyBirthdayTheme {
                // Display a Surface composable
                Surface(
                    modifier = Modifier.fillMaxSize(), // Fill the available space
                    color = MaterialTheme.colorScheme.background // Use the theme's background color
                ) {
                    // Display a GreetingImage composable
                    GreetingImage(
                        stringResource(R.string.happy_birthday_text), // Load the string resource for the birthday message
                        stringResource(R.string.signature_text) // Load the string resource for the signature
                    )
                }
            }
        }
    }
}

@Composable
fun GreetingText(message: String, from: String, modifier: Modifier = Modifier) {
    // Display a Column composable
    // It will contain 2 Text composables
    Column(
        verticalArrangement = Arrangement.Center, // Center the content vertically
        modifier = modifier // Since column is the first element, pass it the modifier argument
    ) {
        // Display a Text composable
        Text(
            text = message, // The text to display
            fontSize = 100.sp, // Set the font size
            lineHeight = 116.sp, // Set the height of each line. Must be large enough so that lines don't overlap
            textAlign = TextAlign.Center, // Alignment of the text inside the Text composable
            modifier = Modifier.padding(top = 16.dp) // Add padding around the Text composable
        )
        // Display another Text composable
        Text(
            text = from,
            fontSize = 36.sp,
            modifier = Modifier
                .padding(top = 16.dp) // Add padding around the Text composable
                .padding(end = 16.dp) // Add padding around the Text composable
                .align(alignment = Alignment.End) // Alignment of the Text composable inside the parent Column composable
        )
    }
}

@Composable
fun GreetingImage(message: String, from: String, modifier: Modifier = Modifier) {
    // Display a box that contains an Image composable, and a GreetingText composable
    // Since the Box is the first element, pass it the modifier argument
    Box(modifier) {
        // Display an Image composable
        Image(
            painter = painterResource(id = R.drawable.androidparty), // Load the image from resources
            contentDescription = null, // A description of the image for accessibility, none needed in this case since the image doesn't contain any useful information
            contentScale = ContentScale.Crop, // Scale the image to fill the bounds of the Image composable
            alpha = 0.5F
        )
        // Display a GreetingText composable
        GreetingText(
            message = message,
            from = from,
            modifier = Modifier
                .fillMaxSize() // Fill the available space of the Box
                .padding(8.dp) // Add padding around the GreetingText
        )
    }
}


@Preview(showBackground = false)
@Composable
private fun BirthdayCardPreview() {
    HappyBirthdayTheme {
        GreetingImage(
            stringResource(R.string.happy_birthday_text),
            stringResource(R.string.signature_text)
        )
    }
}

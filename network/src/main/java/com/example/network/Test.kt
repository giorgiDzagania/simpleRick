package com.example.network

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun Test(modifier: Modifier = Modifier) {
    Text(
        text = "Hello from other module!"
    )
}
package com.pru.cleanArc.presentation.ui.components

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun ErrorView(msg : String) {
    Text(text = msg,style = MaterialTheme.typography.h6.copy(color = Color.Red))
}
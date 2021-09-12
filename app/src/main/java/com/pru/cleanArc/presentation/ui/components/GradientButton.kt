package com.pru.cleanArc.presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pru.cleanArc.presentation.theme.ColorPrimary
import com.pru.cleanArc.presentation.theme.SecondaryColor

@Composable
fun GradientButton(
    text: String,
    onClick: () -> Unit = { },
) {
    val gradient =
        Brush.horizontalGradient(listOf(ColorPrimary, SecondaryColor))
    val modifier = Modifier
        .fillMaxWidth()
        .height(70.dp)
        .padding(horizontal = 16.dp, vertical = 8.dp)
    Button(
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
        contentPadding = PaddingValues(),
        onClick = onClick,
        shape = RoundedCornerShape(size = 20.dp)
    ) {
        Box(
            modifier = Modifier
                .background(gradient)
                .then(modifier),
            contentAlignment = Alignment.Center,
        ) {
            Text(text = text, style = MaterialTheme.typography.h3.copy(fontWeight = FontWeight.SemiBold,fontSize = 18.sp))
        }
    }
}
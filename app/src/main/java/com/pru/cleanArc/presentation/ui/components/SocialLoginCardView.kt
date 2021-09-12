package com.pru.cleanArc.presentation.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pru.cleanArc.presentation.theme.BorderBackground
import com.pru.cleanArc.presentation.theme.LiteBackground

@ExperimentalMaterialApi
@Composable
fun SocialLoginCardView(modifier: Modifier, title: String, onClick: () -> Unit) {
    Card(
        modifier = modifier
            .height(80.dp), backgroundColor = LiteBackground,
        border = BorderStroke(width = 2.dp, color = BorderBackground),
        shape = MaterialTheme.shapes.large,
        elevation = 4.dp,
        onClick = onClick
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = title,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        }
    }
}
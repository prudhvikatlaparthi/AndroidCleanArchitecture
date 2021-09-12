package com.pru.cleanArc.presentation.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.pru.cleanArc.R

// Set of Material typography styles to start with

val oswaldFontFamily =  FontFamily(
Font(R.font.oswald_extra_light, FontWeight.ExtraLight),
Font(R.font.oswald_light, FontWeight.Light),
Font(R.font.oswald_regular, FontWeight.Normal),
Font(R.font.oswald_medium, FontWeight.Medium),
Font(R.font.oswald_semi_bold, FontWeight.SemiBold),
Font(R.font.oswald_bold, FontWeight.Bold),
)
val Typography = Typography(
    h1 = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 30.sp,
        fontFamily = oswaldFontFamily
    ),
    h2 = TextStyle(
        fontWeight = FontWeight.SemiBold,
        fontSize = 24.sp,
        fontFamily = oswaldFontFamily
    ),
    h3 = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 22.sp,
        fontFamily = oswaldFontFamily
    ),
    h4 = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        fontFamily = oswaldFontFamily
    ),
    h5 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 15.sp,
        fontFamily = oswaldFontFamily
    ),
    h6 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        fontFamily = oswaldFontFamily
    ),
    body1 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        fontFamily = oswaldFontFamily
    ),
    body2 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        fontFamily = oswaldFontFamily
    )
)
package com.applid.gym.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.applid.gym.R


private val OpenSansRegular = FontFamily(
    Font(R.font.open_sans)
)
private val OpenSansBold = FontFamily(
    Font(R.font.open_sans_bold)
)

// Set of Material typography styles to start with
val Typography = Typography(
    h1 = TextStyle(
        fontFamily = OpenSansBold,
        fontSize = 21.sp,
    ),
    //For list items and textFields
    h3 = TextStyle(
        fontFamily = OpenSansRegular,
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal,
    ),
    body1 = TextStyle(
        fontFamily = OpenSansRegular,
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal,
    ),
    //For dialog content
    body2 = TextStyle(
      fontFamily = OpenSansRegular,
      fontSize = 16.sp,
        fontWeight = FontWeight.Normal,
    ),
    //For menu title
    subtitle1 = TextStyle(
        fontFamily = OpenSansRegular,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
    ),
    button = TextStyle(
        fontFamily = OpenSansRegular,
        fontSize = 14.sp,
        fontWeight = FontWeight.Medium,
    ),


)
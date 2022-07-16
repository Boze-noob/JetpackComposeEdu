package com.applid.gym.ui.common

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.applid.gym.ui.theme.Typography

@Composable
fun ButtonWithRoundCornerShape(btnTxt: String, onClickCallback: () -> Unit) {
    Button(
        colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primaryVariant),
                onClick = {
                          onClickCallback.invoke()
        },
        shape = RoundedCornerShape(20.dp)) {
        Text(
            style = Typography.button,
            text = btnTxt)
    }
}
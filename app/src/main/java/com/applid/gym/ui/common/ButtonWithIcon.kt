package com.applid.gym.ui.common

import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons

import androidx.compose.material.icons.rounded.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.applid.gym.ui.theme.Typography
import androidx.compose.material.Icon
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.ui.text.font.FontWeight

@Composable
fun ButtonWithIcon(btnTxt: String, onClickCallback: () -> Unit, modifier: Modifier) {
    Button(
        colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primaryVariant),
        onClick = {
            onClickCallback.invoke()
        },
        shape = RoundedCornerShape(20.dp),
    ) {
        Row(
            modifier = modifier
        ) {
            Text(
                style = Typography.button,
                text = btnTxt,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.width(10.dp))
            Icon(Icons.Default.ArrowForward, contentDescription = "Localized description")
        }
    }
}
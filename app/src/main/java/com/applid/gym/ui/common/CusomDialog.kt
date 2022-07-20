package com.applid.gym.ui.common

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.applid.gym.R

@Composable
fun CustomDialogUI(
    modifier: Modifier = Modifier,
    openDialogCustom: MutableState<Boolean>,
    child: @Composable() (() -> Unit?)?,
    title: String?,
    content : String?,
    btnTxt: String?,
    btnColor: Color?,
    ){
    Card(
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier.padding(10.dp,5.dp,10.dp,10.dp),
        elevation = 8.dp
    ) {
        Column(
            modifier
                .background(Color.White)) {

            if(child == null) {
                Image(
                    painter = painterResource(id = R.drawable.trophy_icon),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    colorFilter  = ColorFilter.tint(
                        color = Color.Cyan
                    ),
                    modifier = Modifier
                        .padding(top = 35.dp)
                        .height(70.dp)
                        .fillMaxWidth(),

                    )
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = title ?: "Title",
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(top = 5.dp)
                            .fillMaxWidth(),
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis,
                        fontSize = 24.sp
                    )
                    Text(
                        text = content ?: "Content",
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .padding(top = 10.dp, start = 25.dp, end = 25.dp)
                            .fillMaxWidth(),
                    )
                }


                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp)
                        .background( btnColor ?: Color.DarkGray),
                    horizontalArrangement = Arrangement.SpaceAround) {
                    TextButton(onClick = {
                        openDialogCustom.value = false
                    }) {
                        Text(
                            btnTxt ?: "Close",
                            fontWeight = FontWeight.ExtraBold,
                            color = Color.Black,
                            modifier = Modifier.padding(top = 5.dp, bottom = 5.dp)
                        )
                    }
                }
            } else {
                child()
            }
        }
    }
}

@SuppressLint("UnrememberedMutableState")
@Preview(name="Custom Dialog")
@Composable
fun MyDialogUIPreview(){
    CustomDialogUI(
        openDialogCustom = mutableStateOf(false),
        child = null,
        title = null,
        btnTxt = null,
        content = null,
        btnColor = null
    )
    //CustomDialogUI(openDialogCustom = mutableStateOf(false), content = ({ Box(){ Text(text = "asfasf")} }))
}
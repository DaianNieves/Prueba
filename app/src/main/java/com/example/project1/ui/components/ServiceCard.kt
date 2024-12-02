package com.example.project1.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.project1.R

@Composable
fun ServiceCard(
    id:Int,
    name: String,
    username:String,
    imageURL: String?,
    onButtonClick:()->Unit) {

    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(3.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.Black,
            contentColor = Color.White
        )
    ) {
        Row() {
            AsyncImage(
                modifier = Modifier
                    .width(80.dp)
                    .height(88.dp)
                    .padding(18.dp),
                model = imageURL,
                error = painterResource(R.drawable.android_logo),
                contentDescription = "Service logo ",
                contentScale = ContentScale.FillBounds
            )
            Column() {
                Text(
                    text = name,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(2.dp, 8.dp, 0.dp, 0.dp)
                )
                Text(
                    text = name,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(4.dp, 0.dp)
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ){
                IconButton(
                    modifier = Modifier
                        .padding(20.dp,0.dp,0.dp,0.dp),
                    onClick = {onButtonClick()}
                ) {

                    Icon(
                        imageVector = Icons.Filled.MoreVert,
                        contentDescription = "Service Details"
                    )
                }
            }
        }
    }
}
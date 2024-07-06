package com.example.check24_interview.presentation.product.overview

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.check24_interview.common.convertIntToTime
import com.example.check24_interview.data.Product
import java.text.SimpleDateFormat
import java.util.Date


@Composable
fun ProductOverviewCard(
    product:Product,
    modifier: Modifier = Modifier
){
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(5.dp),
        border = BorderStroke(2.dp,Color.Gray),
        colors =  CardColors (Color.White,Color.Black,Color.Blue, Color.Red)
    ) {
        Row(
            modifier = Modifier
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            if (product.available){
                Image(
                    painter = rememberAsyncImagePainter(product.imageURL),
                    contentDescription = null,
                    modifier = Modifier
                        .weight(.3f)
                        .size(128.dp)
                )
            }

            Column(
                modifier = Modifier
                    .weight(.7f)
                    .padding(start = 5.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = product.name)
                    Text(text = convertIntToTime(product.releaseDate))
                }
                Text(
                    text = product.description,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Preis:${product.price.value} ${product.price.currency}"
                    )
                    StarRatingBar(
                        rating = product.rating.toFloat()
                    )
                }
            }

            if (!product.available){
                Image(
                    painter = rememberAsyncImagePainter(product.imageURL),
                    contentDescription = null,
                    modifier = Modifier
                        .weight(.3f)
                        .size(128.dp)
                )
            }
        }
    }
}







@Preview
@Composable
fun ProductOverviewCardDemo(
    modifier: Modifier = Modifier
){
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(5.dp),
        border = BorderStroke(2.dp,Color.Gray),
    ) {
        Row(
            modifier = Modifier
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Image_(modifier = Modifier
                .weight(.3f)
                .size(128.dp)
            )

            Column_(
                modifier = Modifier
                    .weight(.7f)
                    .padding(start = 5.dp)
            )


        }
    }
}

@Composable
fun Image_(modifier: Modifier = Modifier){
    Image(
        painter = rememberAsyncImagePainter("https://letsenhance.io/static/8f5e523ee6b2479e26ecc91b9c25261e/1015f/MainAfter.jpg"),
        contentDescription = null,
        modifier = modifier
    )
}

@Composable
fun Column_(
    modifier:Modifier = Modifier
){
    Column(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Name")
            Text(text = "31.12.2024")
        }
        Text(text = "Description")
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Preis:39.99 Eur"
            )
            StarRatingBar(
                rating = 3f
            )
        }
    }
}




@Composable
fun StarRatingBar(
    maxStars: Int = 5,
    rating: Float,
    onRatingChanged: (Float) -> Unit = {}
) {
    val density = LocalDensity.current.density
    val starSize = (12f * density).dp
    val starSpacing = (0.5f * density).dp

    Row(
        modifier = Modifier.selectableGroup(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        for (i in 1..maxStars) {
            val isSelected = i <= rating
            val icon = if (isSelected) Icons.Filled.Star else Icons.Default.Star
            val iconTintColor = if (isSelected) Color(0xFFFFC700) else Color(0x20A33B3B)
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = iconTintColor,
                modifier = Modifier
                    .selectable(
                        selected = isSelected,
                        onClick = {
                            onRatingChanged(i.toFloat())
                        }
                    )
                    //.width(starSize)
                    //.height(starSize)
            )

            if (i < maxStars) {
                Spacer(modifier = Modifier.width(starSpacing))
            }
        }
    }
}
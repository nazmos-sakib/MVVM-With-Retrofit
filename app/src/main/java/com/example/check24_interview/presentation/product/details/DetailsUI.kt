package com.example.check24_interview.presentation.product.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.check24_interview.common.convertIntToTime
import com.example.check24_interview.data.Product
import com.example.check24_interview.presentation.product.overview.StarRatingBar


@Composable
fun ProductDetailsUI(
    modifier: Modifier = Modifier.fillMaxSize(),
    product: Product,
    onAddToFavorite:(Product)->Unit={}
) {
    Box(
        modifier = Modifier
            .padding(top = 40.dp)
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(5.dp)
        ) {
            Row(
                modifier = Modifier
                    .padding(10.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = rememberAsyncImagePainter(product.imageURL),
                    contentDescription = null,
                    modifier = Modifier
                        .weight(.3f)
                        .size(128.dp)
                )


                Column(
                    modifier = Modifier
                        .weight(.7f)
                        .padding(start = 5.dp),
                    verticalArrangement = Arrangement.SpaceAround
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = product.name)
                        Text(text = convertIntToTime(product.releaseDate))
                    }
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
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
                    .background(Color.Blue)
                    .clip(RoundedCornerShape(10.dp))
                    .padding(5.dp)
                    .clickable { onAddToFavorite(product) },
                contentAlignment = Alignment.Center
            ){
                Text(
                    text = "Add to Favorite",
                    color = Color.White
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
            ) {
                Text(text = product.longDescription)
            }
        }
    }
}
@Preview
@Composable
fun DetailsUIDemo(
    modifier: Modifier = Modifier.fillMaxSize()
) {
    Box(modifier = Modifier.padding(top = 40.dp)) {
        Column(
            modifier = Modifier
                .background(Color.White)
                .padding(5.dp)
        ) {
            Row(
                modifier = Modifier
                    .padding(10.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = rememberAsyncImagePainter("https://letsenhance.io/static/8f5e523ee6b2479e26ecc91b9c25261e/1015f/MainAfter.jpg"),
                    contentDescription = null,
                    modifier = Modifier
                        .weight(.3f)
                        .size(128.dp)
                )


                Column(
                    modifier = Modifier
                        .weight(.7f)
                        .padding(start = 5.dp),
                    verticalArrangement = Arrangement.SpaceAround
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = "Name")
                        Text(text = "31.12.2024")
                    }
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

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
                    .background(Color.Blue)
                    .clip(RoundedCornerShape(10.dp))
                    .padding(5.dp)
                    .clickable {  },
                contentAlignment = Alignment.Center
            ){
                Text(
                    text = "Add to Favorite",
                    color = Color.White
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
            ) {
                Text(text = "Description")
            }
        }
    }
}
package com.example.check24_interview.presentation.product.overview

import android.os.Build.VERSION.SDK_INT
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.request.ImageRequest
import coil.size.Size
import com.example.check24_interview.R
import com.example.check24_interview.data.Product

//@Preview
@Composable
fun Overview(
    modifier: Modifier = Modifier.fillMaxSize().padding(top = 30.dp).background(Color.White),
    viewModel: OverviewViewModel,
    onItemClick:(Product)->Unit={}
){

    val res by remember {
        viewModel.state
    }

    val context = LocalContext.current
    val imageLoader = ImageLoader.Builder(context)
        .components {
            if (SDK_INT >= 28) {
                add(ImageDecoderDecoder.Factory())
            } else {
                add(GifDecoder.Factory())
            }
        }
        .build()


    if (res.isLoading){
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = rememberAsyncImagePainter(
                    ImageRequest.Builder(context).data(data = R.drawable.splash_anim).apply(block = {
                        size(Size.ORIGINAL)
                    }).build(), imageLoader = imageLoader
                ),
                contentDescription = null,
            )
        }
    } else {

        Column(
            modifier = Modifier.padding(top=40.dp).background(Color.White),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Gray)
                    .padding(10.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Filter1")
                Text(text = "Filter2")
                Text(text = "Filter3")
            }
            Box(modifier = Modifier.padding(20.dp)) {
                Column {
                    Text(text = "Title..")
                    Text(text = "Subtitle..")

                    Spacer(modifier = Modifier.height(5.dp))

                    LazyColumn(
                        contentPadding =  PaddingValues(top=10.dp)
                    ) {
                        items(res.data) { product->
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(
                                        vertical = 4.dp,
                                    ).clickable { onItemClick(product) }
                            ) {
                                ProductOverviewCard(product)
                            }
                        }
                    }
                }
            }
        }
    }


}


@Preview
@Composable
fun OverviewDemo(
    modifier: Modifier = Modifier.fillMaxSize().padding(top = 30.dp)
){
    Column(
        modifier = Modifier.background(Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Gray)
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Filter1")
            Text(text = "Filter2")
            Text(text = "Filter3")
        }
        Box(modifier = Modifier.padding(20.dp)) {
            Column {
                Text(text = "Title..")
                Text(text = "Subtitle..")

                Spacer(modifier = Modifier.height(5.dp))

                LazyColumn {
                    item(10) {
                        ProductOverviewCardDemo()
                    }
                }
            }
        }
    }

}
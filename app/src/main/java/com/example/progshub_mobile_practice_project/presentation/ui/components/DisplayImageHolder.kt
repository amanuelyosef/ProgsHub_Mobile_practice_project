package com.example.progshub_mobile_practice_project.presentation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.progshub_mobile_practice_project.R
import kotlinx.coroutines.delay


data class DisplayImageItemData(
    val title:String,
    val image:Int
)

val DisplayImageListData = listOf(
    DisplayImageItemData("Electronics", R.drawable.display_electronics_image),
    DisplayImageItemData("Fashion", R.drawable.display_fashion_image),
    DisplayImageItemData("Furniture", R.drawable.display_funiture_image),
)

@Composable
fun DisplayImageHolder(
    modifier: Modifier = Modifier
) {
    val pagerState = rememberPagerState(pageCount = { DisplayImageListData.size})

    LaunchedEffect(Unit) {
        while (true) {
            delay(3000L) // Wait for 1 second
            pagerState.animateScrollToPage(
                page = if (pagerState.currentPage== DisplayImageListData.size-1) {
                    0
                }else{
                    pagerState.currentPage + 1
                }

            )
        }
    }

    HorizontalPager(
        state = pagerState,
    ) {index->
        Box(
            modifier = modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(horizontal = 12.dp)
                .clip(RoundedCornerShape(10.dp))
        ) {
            Image(
                painter = painterResource(id = DisplayImageListData[index].image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )

            Image(
                painter = painterResource(R.drawable.display_image_polygon),
                contentDescription = null,
                alpha = 0.9f,
                alignment = Alignment.TopStart,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .fillMaxHeight(0.9f)
                    .fillMaxWidth(0.5f)
            )

            Column(
                modifier = Modifier
                    .fillMaxHeight(0.3f)
                    .align(Alignment.CenterStart)
                    .padding(horizontal = 5.dp)
                ,
            ) {
                Text(
                    text = DisplayImageListData[index].title,
                    color = Color.White,
                    fontSize = MaterialTheme.typography.headlineMedium.fontSize,
                    fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier
                        .fillMaxWidth(0.45f),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Preview
@Composable
private fun DisplyPriview(modifier: Modifier = Modifier) {
    DisplayImageHolder()
}

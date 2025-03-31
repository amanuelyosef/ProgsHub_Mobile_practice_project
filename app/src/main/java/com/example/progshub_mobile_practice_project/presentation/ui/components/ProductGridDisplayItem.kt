package com.example.progshub_mobile_practice_project.presentation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.progshub_mobile_practice_project.R
import java.util.UUID

@Immutable
data class ProductDisplayListItemData(
    val id: String = UUID.randomUUID().toString(),
    val img:Int = R.drawable.image_sample,
    val title:String = "Brand new Product 2025 made in USA high speed and durability ",
    val price:String = "1,000",
    val descriptionWords: String = "Addis Ababa • Brand New",
)

val ProductDisplayListData = mutableListOf(
    ProductDisplayListItemData(),
    ProductDisplayListItemData(),
    ProductDisplayListItemData(),
    ProductDisplayListItemData(),
    ProductDisplayListItemData(),
    ProductDisplayListItemData(),
    ProductDisplayListItemData(),
    ProductDisplayListItemData(),
)

@Composable
fun ProductGridDisplayItem(
    modifier: Modifier = Modifier,
    item:ProductDisplayListItemData
) {
    var liked by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .padding(8.dp)
    ) {
        Box {
            Image(
                painter = painterResource(item.img),
                contentDescription = null,
                modifier = Modifier.clip(RoundedCornerShape(5.dp))
                    .padding(bottom = 5.dp)
            )

            IconButton(
                onClick = {
                liked = !liked
                },
                modifier = Modifier
                    .clip(CircleShape)
                    .align(Alignment.BottomEnd)
            ) {
                Icon(
                    imageVector = if(liked) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                    contentDescription = ""
                )
            }
        }

        Text(
            text = item.title,
            fontWeight = FontWeight.Medium,
            fontSize = MaterialTheme.typography.bodySmall.fontSize,
            lineHeight = MaterialTheme.typography.labelLarge.fontSize,
            overflow = TextOverflow.Ellipsis,
            maxLines = 2,
        )
        Text(
            text = "ETB ${item.price}",
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier
                .padding(bottom = 1.dp)
        )

        Text(
            text = item.descriptionWords,
            color = Color.DarkGray,
            fontSize = MaterialTheme.typography.bodySmall.fontSize
        )
    }
}


@Preview(showBackground = true)
@Composable
fun ProductDisplayItemPreview(modifier: Modifier = Modifier) {
    ProductGridDisplayItem(item = ProductDisplayListData[0])
}
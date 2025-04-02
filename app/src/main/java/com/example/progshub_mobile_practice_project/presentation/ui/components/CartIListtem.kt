package com.example.progshub_mobile_practice_project.presentation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineBreak
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.progshub_mobile_practice_project.R
import java.util.UUID

data class CartListItemData(
    val id : String = UUID.randomUUID().toString(),
    val title:String = "Brand new Product 2025 made in USA high speed and durability",
    val img:Int = R.drawable.image_sample,
    val descriptionWords : List<String> = listOf("Brand New", "Free Shipping"),
    val price : String = "1,000",
    val location : String = "Addis Ababa"
    )
val cartListData = mutableListOf(
    CartListItemData(),
    CartListItemData(),
    CartListItemData(),
    CartListItemData(),
    CartListItemData(),
)


@Composable
fun CartListItem(
    item : CartListItemData,
    onRemoveClicked : ()->Unit
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(134.dp)
            .padding( horizontal = 5.dp)
            .padding(top = 8.dp)
        ,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(item.img),
            contentDescription = null,
            modifier = Modifier
                .weight(3.3f)
                .fillMaxHeight()
        )

        Column(
            modifier = Modifier.weight(7f)
                .padding(horizontal = 5.dp)
        ) {

            Text(
                text = item.title,
                fontWeight = FontWeight.Medium,
                fontSize = MaterialTheme.typography.bodySmall.fontSize,
                overflow = TextOverflow.Ellipsis,
                maxLines = 2,
                modifier = Modifier
                    .padding(bottom = 5.dp)
                ,
                style = TextStyle(
                    lineBreak = LineBreak(strategy = LineBreak.Strategy.Balanced, strictness = LineBreak.Strictness.Default,wordBreak = LineBreak.WordBreak.Phrase)
                )
            )

            Row{
                item.descriptionWords.forEach {
                    Text(
                        text = it,
                        modifier = Modifier
                            .padding(vertical = 5.dp)
                            .padding(end = 5.dp)
                            .clip(RoundedCornerShape(3.dp))
                            .background(Color.LightGray.copy(0.8f))
                            .padding(
                                horizontal = 5.dp,
                                vertical = 1.dp
                            ),
                        fontSize = MaterialTheme.typography.bodySmall.fontSize,
                    )
                }
            }

            Text(
                text = "ETB " + item.price,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier
                    .padding(top = 1.dp, bottom = 5.dp)
            )

            Text(
                text = "Location: ${item.location}",
                fontSize = MaterialTheme.typography.labelMedium.fontSize,
                modifier = Modifier
                    .padding(bottom = 4.dp)
            )
        }

        IconButton(
            onClick = {
                onRemoveClicked()
            },
            modifier = Modifier.weight(1f)
        ) {
            Icon(
                imageVector = Icons.Default.Close,
                contentDescription = null
            )
        }
    }

}
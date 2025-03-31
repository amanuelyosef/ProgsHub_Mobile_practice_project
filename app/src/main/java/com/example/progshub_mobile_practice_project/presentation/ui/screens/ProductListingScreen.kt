package com.example.progshub_mobile_practice_project.presentation.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridItemSpan
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.progshub_mobile_practice_project.presentation.ui.components.BottomNavigationBar
import com.example.progshub_mobile_practice_project.presentation.ui.components.DisplayImageHolder
import com.example.progshub_mobile_practice_project.presentation.ui.components.ProductDisplayListData
import com.example.progshub_mobile_practice_project.presentation.ui.components.ProductDisplayListItemData
import com.example.progshub_mobile_practice_project.presentation.ui.components.ProductGridDisplayItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductListingScreen(
    navController : NavController
) {
    val topAppBarState = rememberTopAppBarState()
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(state = topAppBarState )
    val lazyListState = rememberLazyStaggeredGridState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "ABC Online Shop",
                        fontSize = MaterialTheme.typography.headlineLarge.fontSize,
                        fontWeight = FontWeight.ExtraBold,
                    )
                },
                scrollBehavior = scrollBehavior,
                colors = TopAppBarDefaults.topAppBarColors(
                    scrolledContainerColor = Color.White
                )
            )
        },
        bottomBar = {
            BottomNavigationBar(navController =navController, selected = 0)
        }

    ) { scaffoldPadding ->
        LazyVerticalStaggeredGrid(
            modifier = Modifier.padding(scaffoldPadding),
            columns = StaggeredGridCells.Fixed(2),
            state = lazyListState,
            ) {
            item(
                span = StaggeredGridItemSpan.FullLine,
                key = "Display Image Holder"
            ) {
                DisplayImageHolder()
            }
            items(ProductDisplayListData, key = {it.id}){item->
                ProductGridDisplayItem(
                    modifier = Modifier,
                    item = item
                )
            }
        }
    }

}
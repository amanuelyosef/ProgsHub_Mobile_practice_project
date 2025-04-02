package com.example.progshub_mobile_practice_project.presentation.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridItemSpan
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import com.example.progshub_mobile_practice_project.presentation.ui.components.BottomNavigationBar
import com.example.progshub_mobile_practice_project.presentation.ui.components.CartListItem
import com.example.progshub_mobile_practice_project.presentation.ui.components.cartListData

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartScreen(
    navController: NavController
) {
    val topAppBarState = rememberTopAppBarState()
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(state = topAppBarState )
    val lazyListState = rememberLazyStaggeredGridState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Cart",
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
            BottomNavigationBar(navController =navController, selected = 1)
        }

    ) { scaffoldPadding ->
        LazyVerticalStaggeredGrid(
            modifier = Modifier.padding(scaffoldPadding),
            columns = StaggeredGridCells.Fixed(2),
            state = lazyListState,
        ) {
            items(
                items = cartListData,
                span = {StaggeredGridItemSpan.FullLine},
                key = {it.id}
            ){item ->
                CartListItem(item) {
                    cartListData.remove(cartListData.find { it.id == item.id })
                }
            }
        }
    }

}
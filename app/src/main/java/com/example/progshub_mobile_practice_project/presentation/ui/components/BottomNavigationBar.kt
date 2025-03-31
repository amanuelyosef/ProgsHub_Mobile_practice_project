package com.example.progshub_mobile_practice_project.presentation.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.progshub_mobile_practice_project.presentation.ui.navigation.ScreenRoute

@Immutable
data class BottomNavigationBarDataItem(
    val title: String,
    val route: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val contentDescription:String,
)

val BottomNavigationBarListData = listOf(
    BottomNavigationBarDataItem(
        title = "Home",
        route = ScreenRoute.HomeScreen.route,
        selectedIcon = Icons.Filled.Home,
        unselectedIcon = Icons.Outlined.Home,
        contentDescription = "home button"
    ),
    BottomNavigationBarDataItem(
        title = "Cart",
        route = ScreenRoute.CartScreen.route,
        selectedIcon = Icons.Filled.ShoppingCart,
        unselectedIcon = Icons.Outlined.ShoppingCart,
        contentDescription = "home button"
    ),
    BottomNavigationBarDataItem(
        title = "Favorites",
        route = ScreenRoute.FavoritesScreen.route,
        selectedIcon = Icons.Filled.Favorite,
        unselectedIcon = Icons.Outlined.FavoriteBorder,
        contentDescription = "home button"
    )
)

@Composable
fun BottomNavigationBar(
    navController: NavController,
    selected : Int = 0
) {

    BottomAppBar{
        BottomNavigationBarListData.forEachIndexed { index, item ->
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .clickable {
                        //println("This is backstack list  ${navController.currentBackStack.value}")
                        navController.navigate(item.route) {
                            popUpTo(item.route) { inclusive = true }
                        }
                    }
                    .padding(vertical = 5.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Icon(
                    imageVector = if (selected == index) item.selectedIcon else item.unselectedIcon,
                    contentDescription = item.contentDescription,
                    tint = if(selected==index) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier
                        .size(32.dp)
                        .padding(bottom = 4.dp)
                )

                Text(
                    text = item.title,
                    fontSize = MaterialTheme.typography.labelMedium.fontSize
                )
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun Bottom(modifier: Modifier = Modifier) {
    BottomNavigationBar(navController = rememberNavController())
}

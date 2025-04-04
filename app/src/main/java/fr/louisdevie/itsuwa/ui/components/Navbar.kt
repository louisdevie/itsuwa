package fr.louisdevie.itsuwa.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Kitchen
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material.icons.outlined.SoupKitchen
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavOptions
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import fr.louisdevie.itsuwa.R
import fr.louisdevie.itsuwa.ui.screens.FridgeRoute
import fr.louisdevie.itsuwa.ui.screens.GroceryListRoute
import fr.louisdevie.itsuwa.ui.screens.RecipesRoute
import fr.louisdevie.itsuwa.ui.theme.ItsuwaTheme

data class NavbarItem<T>(
    val name: String,
    val icon: ImageVector,
    val route: T
)

@Composable
fun Navbar(navController: NavController) {
    val items = listOf(
        NavbarItem(
            stringResource(id = R.string.navbar_fridge),
            Icons.Outlined.Kitchen,
            FridgeRoute
        ),
        NavbarItem(
            stringResource(id = R.string.navbar_grocery_list),
            Icons.Outlined.ShoppingCart,
            GroceryListRoute
        ),
        NavbarItem(
            stringResource(id = R.string.navbar_recipes),
            Icons.Outlined.SoupKitchen,
            RecipesRoute
        ),
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar {
        items.forEach { item ->
            NavigationBarItem(
                icon = { Icon(item.icon, contentDescription = item.name) },
                label = { Text(item.name) },
                selected = currentDestination?.hasRoute(item.route::class) == true,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.findStartDestination().id) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun NavbarPreviewLight() {
    ItsuwaTheme(darkTheme = false) {
        Navbar(navController = rememberNavController())
    }
}

@Preview(showBackground = true)
@Composable
fun NavbarPreviewDark() {
    ItsuwaTheme(darkTheme = true) {
        Navbar(navController = rememberNavController())
    }
}


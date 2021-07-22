package io.gebes.composer.views.showcases

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.navigation.NavHostController

@Composable
fun BottomAppBarShowcase(navController: NavHostController) {
    val selectedItem = remember { mutableStateOf("Home") }

    Scaffold(

        topBar = {
            TopAppBar(
                title = { Text("BottomAppBar") },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.popBackStack()
                    }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Back",
                        )
                    }
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                content = {
                    BottomNavigation() {
                        SimpleNavigationItem(
                            icon = {
                                Icon(Icons.Filled.Home, "")
                            },
                            label = "Home",
                            selected = selectedItem
                        )
                        SimpleNavigationItem(
                            icon = {
                                Icon(Icons.Filled.Search, "")
                            },
                            label = "Search",
                            selected = selectedItem
                        )
                        SimpleNavigationItem(
                            icon = {
                                Icon(Icons.Filled.Favorite, "")
                            },
                            label = "Saved",
                            selected = selectedItem
                        )
                        SimpleNavigationItem(
                            icon = {
                                Icon(Icons.Filled.AccountBox, "")
                            },
                            label = "Profile",
                            selected = selectedItem
                        )
                    }
                }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "${selectedItem.value} is selected",
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp
            )
        }
    }
}

@Composable
private fun RowScope.SimpleNavigationItem(
    icon: @Composable () -> Unit,
    label: String,
    selected: MutableState<String>
) {
    BottomNavigationItem(
        icon = icon,
        label = { Text(text = label) },
        selected = selected.value == label,
        onClick = {
            selected.value = label
        },
        alwaysShowLabel = false
    )
}
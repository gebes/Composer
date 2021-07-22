package io.gebes.composer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import io.gebes.composer.ui.theme.ComposerTheme
import io.gebes.composer.views.HomeView
import io.gebes.composer.views.showcases.BottomAppBarShowcase
import io.gebes.composer.views.showcases.InfiniteListShowCase
import io.gebes.composer.views.showcases.MaterialButtonsShowcase
import io.gebes.composer.views.showcases.TopAppBarShowcase

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val navController = rememberNavController()
            NavHost(navController, startDestination = "home") {
                composable(route = "home") {
                    ComposerTheme {
                        App(navController)
                    }
                }
                composable(route = "showcases/TopAppBar") {
                    ComposerTheme {
                        TopAppBarShowcase(navController)
                    }
                }
                composable(route = "showcases/BottomAppBar") {
                    ComposerTheme {
                        BottomAppBarShowcase(navController)
                    }
                }
                composable(route = "showcases/MaterialButtons") {
                    ComposerTheme {
                        MaterialButtonsShowcase(navController)
                    }
                }
                composable(route = "showcases/InfiniteList") {
                    ComposerTheme {
                        InfiniteListShowCase(navController)
                    }
                }
            }


        }
    }
}

@Composable
fun App(navController: NavHostController) {

    // A surface container using the 'background' color from the theme
    Surface(color = MaterialTheme.colors.background) {
        HomeView(name = android.os.Build.MODEL, navController)
    }
}
package io.gebes.composer.views

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import io.gebes.composer.utils.CenterColumn

@Composable
fun HomeView(name: String, navController: NavHostController) {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Composer") }) }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
                    .height(160.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,

                ) {
                Text("Hello from your", fontWeight = FontWeight.SemiBold, fontSize = 16.sp)
                Text(name, fontWeight = FontWeight.Bold, fontSize = 24.sp)
            }
            ShowcaseButton(
                "TopAppBar",
                "Example for a straightforward AppBar in a Scaffold",
                color = Color.Magenta,
                navController = navController,
                icon = Icons.Filled.Build
            )
            ShowcaseButton(
                "BottomAppBar",
                "Easy to use BottomNavigationBar",
                color = Color.Magenta,
                navController = navController,
                icon = Icons.Filled.Build
            )
            ShowcaseButton(
                "MaterialButtons",
                "Regular Android Inkwell Buttons",
                color = Color.Blue,
                navController = navController,
                icon = Icons.Filled.PlayArrow
            )
            ShowcaseButton(
                "InfiniteList",
                "LazyColumns which has ${Integer.MAX_VALUE} items O.o",
                color = Color.Red,
                navController = navController,
                icon = Icons.Filled.List
            )

        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ShowcaseButton(
    name: String,
    description: String,
    color: Color,
    navController: NavHostController,
    icon: ImageVector
) {

    val context = LocalContext.current
    Card(
        onClick = {
            val destination = navController.findDestination("showcases/$name")
            if (destination == null) {
                Toast.makeText(context, "Not implemented", Toast.LENGTH_SHORT).show()
            } else {
                destination.route?.let { navController.navigate(it) }
            }
        },
        elevation = 8.dp,
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
            .height(96.dp)
            .fillMaxWidth()
    ) {
        Row(horizontalArrangement = Arrangement.SpaceBetween) {
            Box(
                modifier = Modifier
                    .width(96.dp)
                    .height(96.dp)
                    .background(color)
            ) {
                CenterColumn {
                    Icon(
                        icon, "",

                        modifier = Modifier
                            .width(64.dp)
                            .height(64.dp),
                        tint = Color.White

                    )
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp),
                verticalArrangement = Arrangement.Center,
            ) {
                Text(name, fontWeight = FontWeight.SemiBold, fontSize = 24.sp)
                Text(description)
            }
        }
    }
}


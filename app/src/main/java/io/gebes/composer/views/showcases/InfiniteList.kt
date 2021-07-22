package io.gebes.composer.views.showcases

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import io.gebes.composer.utils.BackTopAppBar

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun InfiniteListShowCase(navController: NavHostController) {
    var context = LocalContext.current


    Scaffold(
        topBar = {
            BackTopAppBar(title = {
                Text("InfiniteList")
            }, navController = navController)
        }
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            state = rememberLazyListState()
        ) {
            items(Integer.MAX_VALUE) { index ->
                ListItem(text = {
                    Text("$index")
                }, secondaryText = {
                    Text("That is only ${Integer.MAX_VALUE - index} to go!")
                })
                Divider()
            }
        }
    }
}

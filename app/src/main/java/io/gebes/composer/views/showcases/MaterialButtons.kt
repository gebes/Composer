package io.gebes.composer.views.showcases

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.google.android.material.button.MaterialButton
import io.gebes.composer.utils.BackTopAppBar
import io.gebes.composer.utils.CenterColumn

@Composable
fun MaterialButtonsShowcase(navController: NavHostController) {
    val context = LocalContext.current
    Scaffold(
        topBar = {
            BackTopAppBar(title = {
                Text("MaterialButtons")
            }, navController = navController)
        }
    ) {

        CenterColumn(
            modifier = Modifier
                .padding(16.dp)
        ) {

            ShowCaseButton()
            ShowCaseButton(
                modifier = Modifier
                    .width(192.dp)
                    .padding(top = 8.dp)
            )
            ShowCaseButton(
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red),
                modifier = Modifier
                    .width(192.dp)
                    .padding(top = 8.dp)
            )

        }

    }
}

@Composable
private fun ShowCaseButton(modifier: Modifier = Modifier, colors: ButtonColors = ButtonDefaults.buttonColors()) {
    val context = LocalContext.current
    Button(
        modifier = modifier,
        colors = colors,
        onClick = {
            Toast.makeText(context, "You pressed a button", Toast.LENGTH_SHORT).show()
        },
    ) {
        Text("A button")
    }
}
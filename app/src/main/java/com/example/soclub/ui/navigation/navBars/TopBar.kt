package com.example.soclub.ui.navigation.navBars

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.soclub.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(navController: NavController, route: String? = null) {

    val currentScreen = getCurrentScreen(navController)
    val isMainScreen = shortcuts.any { it.route.name == currentScreen }

    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(R.string.workshop_app),
                textAlign = TextAlign.Center
            )
        },

        navigationIcon = {
            if (!isMainScreen) {
                IconButton(onClick = {
                    if (route != null) {
                        navController.navigate(route)
                    } else {
                        navController.popBackStack()
                    }
                }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }
        },



        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = Color.LightGray
        )


    )
}

@Preview
@Composable
fun TopBarPreview() {
    TopBar(rememberNavController())
}
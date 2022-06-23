package com.merttoptas.jetpack_compose_component_box.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.merttoptas.jetpack_compose_component_box.components.CustomScaffold
import com.merttoptas.jetpack_compose_component_box.screen.buttons.ButtonsScreen
import com.merttoptas.jetpack_compose_component_box.screen.dashboard.DashBoardScreen
import com.merttoptas.jetpack_compose_component_box.screen.otp.OtpScreen
import com.merttoptas.jetpack_compose_component_box.screen.loading.LoadingScreen

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun NavGraph(startDestination: String = NavScreen.DashBoard.route) {
    val navController = rememberAnimatedNavController()

    CustomScaffold(
        backgroundColor = MaterialTheme.colors.background,
    ) { innerPadding ->
        AnimatedNavHost(
            navController = navController,
            startDestination = startDestination,
            Modifier.padding(innerPadding)
        ) {

            composable(NavScreen.DashBoard.route) {
                DashBoardScreen(navigateToButtons = {
                    navController.navigate(NavScreen.Buttons.route)
                }, navigateToOtpScreen = {
                    navController.navigate(NavScreen.Otp.route)
                }, navigateToLoadings = {
                    navController.navigate(NavScreen.Loading.route)
                })
            }

            composable(NavScreen.Buttons.route) {
                ButtonsScreen(navigateToBack = {
                    navController.popBackStack()
                })
            }
            composable(NavScreen.Loading.route) {
                LoadingScreen(navigateToBack = {
                    navController.popBackStack()
                })
            }
            composable(NavScreen.Otp.route) {
                OtpScreen(navigateToBack = {
                    navController.popBackStack()
                })
            }
        }
    }
}

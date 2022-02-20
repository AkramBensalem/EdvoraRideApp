package dz.akram.bensalem.edvorarideapp.ui.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import dz.akram.bensalem.edvorarideapp.Greeting
import dz.akram.bensalem.edvorarideapp.data.Screen
import dz.akram.bensalem.edvorarideapp.data.User
import dz.akram.bensalem.edvorarideapp.ui.components.homescreen.CustomAppBar
import dz.akram.bensalem.edvorarideapp.ui.screens.home.HomeScreenUI
import dz.akram.bensalem.edvorarideapp.utils.animations.scaleInEnterTransition
import dz.akram.bensalem.edvorarideapp.utils.animations.scaleInPopEnterTransition
import dz.akram.bensalem.edvorarideapp.utils.animations.scaleOutExitTransition
import dz.akram.bensalem.edvorarideapp.utils.animations.scaleOutPopExitTransition


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MainNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberAnimatedNavController(),
    startDestination: String = Screen.HOME,
//    mainScreenViewModel: MainScreenViewModel = hiltViewModel(),
) {


    AnimatedNavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier.background(color = MaterialTheme.colors.surface)
    ) {
        // HomeScreen
        composable(
            route = Screen.HOME,
            enterTransition = { ->
                scaleInEnterTransition()
            },
            exitTransition = { ->
                scaleOutExitTransition()
            },
            popEnterTransition = { ->
                scaleInPopEnterTransition()
            },
            popExitTransition = { ->
                scaleOutPopExitTransition()
            }
        ) {


         //   val viewModel: OnBoardingViewModel = hiltViewModel()
         //   val onBoardingScreenState by viewModel.uiState.collectAsState()
         //     val onBoardingScreenData = onBoardingScreenState as OnBoardingState.OnBoardingScreen




               HomeScreenUI()


        }


    }
}










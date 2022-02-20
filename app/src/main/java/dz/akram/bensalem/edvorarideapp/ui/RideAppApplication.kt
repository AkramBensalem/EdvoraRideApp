package dz.akram.bensalem.edvorarideapp.ui

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.insets.navigationBarsPadding
import com.google.accompanist.insets.statusBarsPadding
import dz.akram.bensalem.edvorarideapp.ui.navigation.MainNavHost
import dz.akram.bensalem.edvorarideapp.ui.theme.EdvoraRideAppTheme

import cafe.adriel.lyricist.Lyricist
import cafe.adriel.lyricist.ProvideStrings
import cafe.adriel.lyricist.rememberStrings
import dz.akram.bensalem.edvorarideapp.utils.internationalization.LocalStrings
import dz.akram.bensalem.edvorarideapp.utils.internationalization.strings


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun FormApplication(
    modifier: Modifier = Modifier
) {

    // Initialize lyricist
    val lyricist = rememberStrings(translations = strings)


    // Apply lyricist
    ProvideStrings(
        lyricist = lyricist,
        provider = LocalStrings
    ) {
        EdvoraRideAppTheme{
            ProvideWindowInsets {
                Surface(
                    modifier = modifier,
                    color = MaterialTheme.colors.surface
                ) {
                    MainNavHost(
                        modifier = Modifier
                            .fillMaxSize(),
                    )
                }
            }
        }
    }

}
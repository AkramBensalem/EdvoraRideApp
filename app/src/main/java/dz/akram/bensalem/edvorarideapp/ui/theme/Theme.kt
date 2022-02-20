package dz.akram.bensalem.edvorarideapp.ui.theme


import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController


private val DarkColorPalette = darkColors(
    primary = Black ,
    onPrimary = White,

    background = BlackDark,
    surface = BlackLight,

    onSurface = White,
    onBackground = Gray,

    secondary = BlueDark,
    onSecondary = BlueLight,

)


private val LightColorPalette = lightColors(
    primary =White,
    onPrimary = Black,

    background = BlackLight,
    surface = BlackDark,

    onSurface = Gray,
    onBackground = White,

    secondary = BlueLight,
    onSecondary = BlueDark,
)




@Composable
fun EdvoraRideAppTheme(
    systemUiController: SystemUiController = rememberSystemUiController(),
    content: @Composable () -> Unit
) {
    val colors = DarkColorPalette

    MaterialTheme(
        colors = animate(colors),
        typography = Typography,
        shapes = Shapes,
    ) {

        SideEffect {
            systemUiController.setSystemBarsColor(
                color = Color.Transparent,
                darkIcons = false
            )

        }

        CompositionLocalProvider(
            LocalRippleTheme provides EdvoraRideAppRippleTheme,
            content = content
        )
    }
}


@Composable
private fun animate(colors: Colors): Colors {
    val animSpec = remember {
        spring<Color>(stiffness = 500f)
    }

    @Composable
    fun animateColor(color: Color): Color =
        animateColorAsState(targetValue = color, animationSpec = animSpec).value


    return Colors(
        primary = animateColor(colors.primary),
        primaryVariant = animateColor(colors.primaryVariant),
        secondary = animateColor(colors.secondary),
        secondaryVariant = animateColor(colors.secondaryVariant),
        background = animateColor(colors.background),
        surface = animateColor(colors.surface),
        error = animateColor(colors.error),
        onPrimary = animateColor(colors.onPrimary),
        onSecondary = animateColor(colors.onSecondary),
        onBackground = animateColor(colors.onBackground),
        onSurface = animateColor(colors.onSurface),
        onError = animateColor(colors.onError),
        isLight = colors.isLight,
    )
}


private object EdvoraRideAppRippleTheme : RippleTheme {

    @Composable
    fun animateColor(color: Color): Color =
        animateColorAsState(targetValue = color, animationSpec = remember {
            spring(stiffness = 500f)
        }).value


    @Composable
    override fun defaultColor(): Color = animateColor(MaterialTheme.colors.primary)

    @Composable
    override fun rippleAlpha(): RippleAlpha = RippleTheme.defaultRippleAlpha(
        BlackLight,
        lightTheme = !isSystemInDarkTheme()
    )

}




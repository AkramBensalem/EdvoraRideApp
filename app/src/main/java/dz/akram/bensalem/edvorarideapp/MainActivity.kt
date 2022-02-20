package dz.akram.bensalem.edvorarideapp

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import dagger.hilt.android.AndroidEntryPoint
import dz.akram.bensalem.edvorarideapp.data.User
import dz.akram.bensalem.edvorarideapp.ui.FormApplication
import dz.akram.bensalem.edvorarideapp.ui.components.homescreen.CustomAppBar
import dz.akram.bensalem.edvorarideapp.ui.theme.EdvoraRideAppTheme


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        /**
         * Setup the [SplashScreen] instance associated with the [MainActivity]
         * Note: The Icon animation works just in [Android 12+].
         *
         * The smooth animation works on all Android versions
         */

        installSplashScreen()

        /**
         * Remove all kind of OS decoration like the color of [StatusBar] and [NavigationBar]
         * So we can custom our special decoration
         */

        WindowCompat.setDecorFitsSystemWindows(window, false)


        setContent {
            EdvoraRideAppTheme {
                FormApplication(
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

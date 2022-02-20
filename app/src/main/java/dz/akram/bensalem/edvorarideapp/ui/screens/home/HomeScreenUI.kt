package dz.akram.bensalem.edvorarideapp.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.accompanist.insets.navigationBarsPadding
import dz.akram.bensalem.edvorarideapp.data.User
import dz.akram.bensalem.edvorarideapp.ui.components.homescreen.CustomAppBar
import dz.akram.bensalem.edvorarideapp.ui.components.homescreen.MainRidesList

@Composable
fun HomeScreenUI(
    modifier: Modifier = Modifier
) {
    val user = User(
        stationCode = 40,
        name = "Akram Bensalem",
        profileKey = "https://picsum.photos/536/355"
    )


    Scaffold(
        modifier = modifier
            .background(MaterialTheme.colors.surface)
            .navigationBarsPadding(),
        topBar = {
            CustomAppBar(profile = user)
        }
    ) {

        MainRidesList(
            stationCode = user.stationCode
        )

    }
}
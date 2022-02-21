package dz.akram.bensalem.edvorarideapp.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.accompanist.insets.navigationBarsPadding
import dz.akram.bensalem.edvorarideapp.data.Ride
import dz.akram.bensalem.edvorarideapp.data.User
import dz.akram.bensalem.edvorarideapp.ui.components.homescreen.CustomAppBar
import dz.akram.bensalem.edvorarideapp.ui.components.homescreen.MainRidesList
import dz.akram.bensalem.edvorarideapp.ui.components.homescreen.OptionsBar
import dz.akram.bensalem.edvorarideapp.ui.components.homescreen.OptionsBarState
import dz.akram.bensalem.edvorarideapp.utils.time.TimeConverter

@Composable
fun HomeScreenUI(
    modifier: Modifier = Modifier,
    data : HomeScreenState.Data,
    upcomingNmbr : Int,
    pastNmbr: Int,
    statesList : List<String>,
    citiesList : List<String>,
    onOptionBarClicked : (OptionsBarState) -> Unit,
    onFilterClicked : (String, String) -> Unit

) {
    data.user?.let { user ->
        Scaffold(
            modifier = modifier
                .background(MaterialTheme.colors.surface)
                .fillMaxSize()
                .navigationBarsPadding(),
            topBar = {
                CustomAppBar(profile = user)
            }
        ) {
             MainRidesList(
                    stationCode = user.stationCode,
                 upcomingNmbr = upcomingNmbr,
                 pastNmbr = pastNmbr,
                    list = data.ridesList,
                    optionState = data.screenState,
                    onOptionBarClicked = onOptionBarClicked,
                    statesList = statesList,
                    citiesList = citiesList,
                    onFilterClicked = onFilterClicked
                )
        }
    }

}
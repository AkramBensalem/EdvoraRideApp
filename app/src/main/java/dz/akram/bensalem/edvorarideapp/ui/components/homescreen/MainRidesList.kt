package dz.akram.bensalem.edvorarideapp.ui.components.homescreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dz.akram.bensalem.edvorarideapp.data.Ride
import dz.akram.bensalem.edvorarideapp.data.User
import dz.akram.bensalem.edvorarideapp.ui.theme.Dimens
import dz.akram.bensalem.edvorarideapp.utils.time.TimeConverter

@Composable
fun MainRidesList(
    modifier: Modifier = Modifier,
    stationCode : Int,
    upcomingNmbr : Int,
    pastNmbr: Int,
    list : List<Ride>,
    statesList : List<String>,
    citiesList : List<String>,
    optionState : OptionsBarState,
    onOptionBarClicked : (OptionsBarState) -> Unit,
    onFilterClicked : (String, String) -> Unit
){


    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.surface),
        contentPadding = PaddingValues(horizontal = Dimens.UpperMediumPadding.size)
    ){

        item {
            OptionsBar(
                modifier = Modifier.fillMaxWidth(),
                state = optionState,
                statesList = statesList,
                citiesList = citiesList,
                upcomingListSize =upcomingNmbr,
                pastSize = pastNmbr,
                onOptionClick = {
                    onOptionBarClicked(it)
                },
                onFilterClicked = onFilterClicked,
            )
        }
       items(list){item ->

        RideItem(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    vertical = Dimens.SmallPadding.size
                ),
            item = item,
            currentStationCode = stationCode
        )


       }

    }

}
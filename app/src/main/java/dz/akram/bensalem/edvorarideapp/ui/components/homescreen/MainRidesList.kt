package dz.akram.bensalem.edvorarideapp.ui.components.homescreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dz.akram.bensalem.edvorarideapp.data.Ride
import dz.akram.bensalem.edvorarideapp.ui.theme.Dimens

@Composable
fun MainRidesList(
    modifier: Modifier = Modifier,
){

   val list = listOf<Ride>(
       Ride(
           id = 12,
           origin_station_code = 13,
           station_path = listOf(22),
           destination_station_code = 34,
           date = 234567,
           map_url = "url",
           state = "State1",
           city = "City1"
       ),
       Ride(
           id = 12,
           origin_station_code = 13,
           station_path = listOf(22),
           destination_station_code = 34,
           date = 234567,
           map_url = "url",
           state = "State2",
           city = "City1"
       ),
       Ride(
           id = 12,
           origin_station_code = 13,
           station_path = listOf(22),
           destination_station_code = 34,
           date = 234567,
           map_url = "url",
           state = "State3",
           city = "City1"
       )
   )


    LazyColumn(
        modifier = modifier
            .background(MaterialTheme.colors.surface),
        contentPadding = PaddingValues(
            horizontal = Dimens.UpperMediumPadding.size,
            vertical = 8.dp
        )
    ){

       items(list){item ->

        RideItem(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    vertical = Dimens.SmallPadding.size
                ),
            item = item
        )


       }

    }

}
package dz.akram.bensalem.edvorarideapp.ui.components.homescreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import dz.akram.bensalem.edvorarideapp.data.Ride
import dz.akram.bensalem.edvorarideapp.R
import dz.akram.bensalem.edvorarideapp.ui.theme.Dimens


@Composable
fun RideItem(
    modifier: Modifier = Modifier,
    item : Ride,
    currentStationCode : Int,
){

    Card(
        modifier = modifier,
        elevation = 4.dp,
        backgroundColor = MaterialTheme.colors.background
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = Dimens.UpperMediumPadding.size,
                    vertical = Dimens.MediumPadding.size
                )
        ) {
            Image(
                painter = painterResource(id = R.drawable.map),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .aspectRatio(1.8f)
                    .clip(MaterialTheme.shapes.medium)
            )

            PlaceRow(
                modifier = Modifier
                    .fillMaxWidth(),
                item = item
            )


            RideItemDescription(
                modifier = Modifier.fillMaxWidth(),
                item = item,
                currentStationCode = currentStationCode
            )
        }

    }

}




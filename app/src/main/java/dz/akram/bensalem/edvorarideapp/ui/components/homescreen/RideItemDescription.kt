package dz.akram.bensalem.edvorarideapp.ui.components.homescreen

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import dz.akram.bensalem.edvorarideapp.data.Ride
import dz.akram.bensalem.edvorarideapp.ui.theme.Dimens
import dz.akram.bensalem.edvorarideapp.utils.distance.calculateDistance
import dz.akram.bensalem.edvorarideapp.utils.time.TimeConverter

@Composable
fun RideItemDescription(
    modifier: Modifier = Modifier,
    item: Ride,
    currentStationCode : Int
) {
    Column(
        modifier = modifier
    ) {
        TextDescription(
            title = "Ride Id",
            value = String.format("%03d", item.id) // Three (03) digits
        )
        TextDescription(
            title = "Origin Station",
            value = "${item.origin_station_code}"
        )
        TextDescription(
            title = "Station Path",
            value = "${item.station_path}"
        )
        TextDescription(
            title = "Date",
            value = TimeConverter.convertLongToTime(item.date)
        )
        TextDescription(

            title = "Distance",
            value = "${
                calculateDistance(
                currentStation = currentStationCode,
                path = item.station_path
            )
            }"
        )
    }
}


@Composable
fun TextDescription(
    modifier: Modifier = Modifier,
    title: String,
    value: String
) {

    Row(
        modifier = modifier
            .padding(
                horizontal = Dimens.SmallPadding.size,
                vertical = Dimens.MiniSmallPadding.size
            ),
        horizontalArrangement = Arrangement.SpaceAround,
    ) {

        Text(
            text = buildAnnotatedString {
                withStyle(style = SpanStyle(color = MaterialTheme.colors.onPrimary)) {
                    append("$title : ")
                }
                append(value)
            },
            fontWeight = FontWeight(500),
            fontSize = 18.sp,
            lineHeight = 22.sp,
            color = MaterialTheme.colors.onBackground
        )

    }

}


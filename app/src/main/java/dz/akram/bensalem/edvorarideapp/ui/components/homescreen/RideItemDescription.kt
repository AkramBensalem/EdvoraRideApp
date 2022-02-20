package dz.akram.bensalem.edvorarideapp.ui.components.homescreen

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import dz.akram.bensalem.edvorarideapp.data.Ride
import dz.akram.bensalem.edvorarideapp.ui.theme.Dimens

@Composable
fun RideItemDescription(
    modifier: Modifier = Modifier,
    item: Ride
) {
    Column(
        modifier = modifier
    ) {
        TextDescription(
            title = "Ride Id",
            value = "002"
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
                horizontal = Dimens.SmallPadding.size
            ),
        horizontalArrangement = Arrangement.SpaceAround,
    ) {
        Text(
            text = "$title :",
            fontWeight = FontWeight(500),
            fontSize = 18.sp,
            lineHeight = 22.sp,
            color = MaterialTheme.colors.onPrimary
        )
        Spacer(modifier = Modifier.width(Dimens.SmallPadding.size))
        Text(
            text = "$value",
            fontWeight = FontWeight(500),
            fontSize = 18.sp,
            lineHeight = 22.sp,
            color = MaterialTheme.colors.onBackground
        )
    }

}


package dz.akram.bensalem.edvorarideapp.ui.components.homescreen

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import dz.akram.bensalem.edvorarideapp.data.Ride
import dz.akram.bensalem.edvorarideapp.ui.theme.Dimens

@Composable
fun PlaceRow(
    modifier: Modifier = Modifier,
    item : Ride
) {
    Row(
        modifier = modifier
    ) {
        CustomChip(title = item.city)
        Spacer(modifier = Modifier.weight(1f))
        CustomChip(title = item.state)
    }
}


/**
 * This represents one Custom Chip for Both [Cities] & [States]
 */

@Composable
fun CustomChip(
    modifier: Modifier = Modifier,
    title: String,
) {
    Card(
        modifier = modifier
            .padding(
                horizontal = Dimens.SmallPadding.size,
                vertical = Dimens.MediumPadding.size
            ),
        shape = CircleShape,
        backgroundColor = MaterialTheme.colors.primary.copy(0.56f)
    ) {
        Text(
            text = title,
            modifier = Modifier.padding(
                horizontal = Dimens.MediumPadding.size,
                vertical = Dimens.ElevationPadding.size
            ),
            fontWeight = FontWeight(500),
            fontSize = 14.sp,
            lineHeight = 14.sp,
        )
    }
}
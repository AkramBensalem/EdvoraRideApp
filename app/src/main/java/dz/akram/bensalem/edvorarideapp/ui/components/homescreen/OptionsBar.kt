package dz.akram.bensalem.edvorarideapp.ui.components.homescreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Sort
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dz.akram.bensalem.edvorarideapp.ui.theme.Dimens
import dz.akram.bensalem.edvorarideapp.utils.internationalization.LocalStrings

enum class OptionsBarState{
    NEAREST, UPCOMING, PAST
}


@Composable
fun OptionsBar(
    modifier: Modifier = Modifier,
    state : OptionsBarState = OptionsBarState.NEAREST,
    upcomingListSize: Int,
    pastSize: Int,
    statesList : List<String>,
    citiesList : List<String>,
    onOptionClick : (OptionsBarState) -> Unit,
    onFilterClicked : (
        String,  // selected state
        String   // selected city
            ) -> Unit,
) {

    var isFilterMenuExpanded by remember {
        mutableStateOf(false)
    }

    Row(
        modifier = modifier
            .background(MaterialTheme.colors.surface),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Text(
            text = "Rides:",
            fontSize = 14.sp,
            fontWeight = FontWeight(300),
            lineHeight = 15.sp,
            letterSpacing = 0.sp
        )

        Option(
            id = OptionsBarState.NEAREST,
            selected = state == OptionsBarState.NEAREST,
            onClick = onOptionClick
        )

        Option(
            id = OptionsBarState.UPCOMING,
            selected = state == OptionsBarState.UPCOMING,
            additionalInfo = upcomingListSize.toString(),
            onClick = onOptionClick
        )

        Option(
            id = OptionsBarState.PAST,
            selected = state == OptionsBarState.PAST,
            additionalInfo = pastSize.toString(),
            onClick = onOptionClick
        )
Box() {

    Button(
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Transparent,
        ),
        elevation = null,
        shape = CircleShape,
        onClick = {
            isFilterMenuExpanded = true
        }
    ) {
        Icon(
            imageVector = Icons.Rounded.Sort,
            contentDescription = "filter",
            modifier = Modifier.size(24.dp)
        )

        Text(
            text = "Sort",
            fontSize = 14.sp,
            fontWeight = FontWeight(400),
            lineHeight = 15.sp,
            letterSpacing = 0.sp,
            color = MaterialTheme.colors.onPrimary,
            modifier =Modifier.padding(start = Dimens.MiniSmallPadding.size)
        )
    }


    FilterPopUpMenu(
        expanded = isFilterMenuExpanded,
        onDismissRequest = {
            isFilterMenuExpanded = false
        },
        onCityClicked = { city ->
            onFilterClicked(
                "",
                city
            )
        },
        onStateClicked = { state ->
            onFilterClicked(
                state,
                ""
            )
        },
        listStates = statesList,
        listCities = citiesList
    )



}



    }

}



@Composable
private fun Option(
    id : OptionsBarState,
    selected : Boolean,
    additionalInfo : String? = null,
    onClick : (OptionsBarState) -> Unit
){

    val strings = LocalStrings.current
    val title = if (additionalInfo!= null) strings.option(id) + "(${additionalInfo})"
    else strings.option(id)

    ClickableText(
        text = AnnotatedString(title),
        style = TextStyle(
            fontSize = 14.sp,
            fontWeight = FontWeight(if (selected) 700 else 300),
            lineHeight = 15.sp,
            letterSpacing = 0.sp,
            color = MaterialTheme.colors.onPrimary
        ),
        onClick = {onClick(id)}
    )
}
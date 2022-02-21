package dz.akram.bensalem.edvorarideapp.ui.components.homescreen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dz.akram.bensalem.edvorarideapp.ui.theme.Dimens

@Composable
fun FilterPopUpMenu(
    expanded: Boolean,
    listStates: List<String>,
    listCities: List<String>,
    onDismissRequest: () -> Unit = {},
    onCityClicked: (String) -> Unit = {},
    onStateClicked: (String) -> Unit = {},
) {

    var stateSelectedIndex by remember {
        mutableStateOf(0)
    }

    var citySelectedIndex by remember {
        mutableStateOf(0)
    }



    DropdownMenu(
        expanded = expanded,
        onDismissRequest = { onDismissRequest() },
        modifier = Modifier
            .fillMaxWidth(0.5f)
            .background(MaterialTheme.colors.background)
    ) {

        Text(
            text = "Filters",
            fontSize = 20.sp,
            fontWeight = FontWeight(300),
            lineHeight = 24.sp,
            color = MaterialTheme.colors.onSurface,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
                .padding(
                horizontal = Dimens.SmallPadding.size,
                vertical = Dimens.MiniSmallPadding.size
            )
        )

        Divider(
            color = MaterialTheme.colors.onSurface,
            thickness = 1.dp,
            modifier = Modifier.padding(
                vertical = Dimens.MiniSmallPadding.size,
                horizontal = Dimens.MediumPadding.size,
                )
        )


        DropdownMenuItem(onClick = {
            onStateClicked(listStates[stateSelectedIndex])
        })
        {
            FilterOption(
                modifier = Modifier,
                list = listStates,
                selectedIndex= stateSelectedIndex,
                onSelectedItem = {
                    stateSelectedIndex = it
                    onStateClicked(listStates[it])
                }
            )

        }


        Spacer(modifier = Modifier.height(Dimens.MiniSmallPadding.size))

            DropdownMenuItem(onClick = {
                onCityClicked(listCities[citySelectedIndex])
            }) {
                FilterOption(
                    modifier = Modifier,
                    list = listCities,
                    selectedIndex= citySelectedIndex,
                    onSelectedItem = {
                        citySelectedIndex = it
                        onCityClicked(listCities[it])
                    }
                )
            }

        Spacer(modifier = Modifier.height(Dimens.SmallPadding.size))

    }
}



@Composable
fun FilterOption(
    modifier : Modifier =Modifier,
    list : List<String>,
    selectedIndex: Int,
    onSelectedItem : (Int) -> Unit,
) {
    var expanded by remember {
        mutableStateOf(false)
    }
    Box() {
        Card(
            shape = MaterialTheme.shapes.medium,
            elevation = Dimens.ElevationPadding.size,
            backgroundColor = MaterialTheme.colors.surface,
            border = BorderStroke(width = 1.dp, color = Color(0xFF232323)),
            modifier = modifier
                .clip(MaterialTheme.shapes.medium)
                .clickable {
                    expanded = true
                }
        ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(Dimens.MiniSmallPadding.size),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(
                        text = list[selectedIndex],
                        fontSize = 17.sp,
                        fontWeight = FontWeight(400),
                        textAlign = TextAlign.Center,
                        lineHeight = 20.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        color = MaterialTheme.colors.onPrimary,
                        modifier = Modifier.padding(
                            all = Dimens.SmallPadding.size
                        ))
                    Spacer(Modifier.width(Dimens.MiniSmallPadding.size))
                    Icon(
                        imageVector = Icons.Rounded.ArrowDropDown,
                        contentDescription = "Expand the menu",
                        tint = MaterialTheme.colors.onSurface
                    )
                }
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false },
                    modifier = Modifier.align(Alignment.TopEnd),
                    offset = DpOffset(240.dp,128.dp)
                ) {
                    list.forEachIndexed { index, s ->
                        DropdownMenuItem(onClick = {
                            onSelectedItem(index)
                            expanded = false
                        }) {
                            Text(
                                text = s,
                                fontSize = 16.sp,
                                fontWeight = FontWeight(400),
                                lineHeight = 17.sp,
                                color = MaterialTheme.colors.onPrimary
                            )
                        }
                    }
                }
            }


    }
}

package dz.akram.bensalem.edvorarideapp.utils.internationalization

import dz.akram.bensalem.edvorarideapp.ui.components.homescreen.OptionsBarState


/**
 * [English] is the default language for the app
 * English translations
 */

val EnStrings = Strings(
    appName = "Edvora",
    profileIcon = "Your Profile Icon",

    option = { state ->
        when(state){
            OptionsBarState.NEAREST -> "Nearest"
            OptionsBarState.UPCOMING -> "Upcoming"
            OptionsBarState.PAST -> "Past"
        }
             },
)

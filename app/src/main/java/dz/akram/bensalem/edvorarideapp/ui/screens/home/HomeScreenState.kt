package dz.akram.bensalem.edvorarideapp.ui.screens.home

import dz.akram.bensalem.edvorarideapp.data.Ride
import dz.akram.bensalem.edvorarideapp.data.User
import dz.akram.bensalem.edvorarideapp.ui.components.homescreen.OptionsBarState

sealed class HomeScreenState {
    data class Data(
        val ridesList: List<Ride> = listOf(),
        val user: User? = null,
        val screenState: OptionsBarState = OptionsBarState.NEAREST,
        val state: String = "",
        val city: String = ""
    ): HomeScreenState()

    companion object {
        val Empty = Data()
    }
}
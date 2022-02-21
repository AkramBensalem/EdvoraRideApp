package dz.akram.bensalem.edvorarideapp.repository

import dz.akram.bensalem.edvorarideapp.data.Ride
import dz.akram.bensalem.edvorarideapp.data.User
import dz.akram.bensalem.edvorarideapp.di.IoDispatcher
import dz.akram.bensalem.edvorarideapp.ui.components.homescreen.OptionsBarState
import dz.akram.bensalem.edvorarideapp.utils.distance.calculateDistance
import dz.akram.bensalem.edvorarideapp.utils.time.TimeConverter
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RideRepository @Inject constructor(
    private val networkApi: List<Ride>,
    private val userApi: User,
    @IoDispatcher val dispatcher: CoroutineDispatcher
) {

    fun getUser() = userApi
    private fun getRideList(
        optionState : OptionsBarState =OptionsBarState.NEAREST,
    ) = networkApi.filter {
        when(optionState){
            OptionsBarState.NEAREST -> true
            OptionsBarState.UPCOMING -> it.date > TimeConverter.currentTimeToLong()
            OptionsBarState.PAST -> it.date < TimeConverter.currentTimeToLong()
        }
    }.sortedBy {
        calculateDistance(
            currentStation = getUser().stationCode,
            path = it.station_path
        )
    }


    fun getRideListFilterByStateOrCity(
        optionState : OptionsBarState =OptionsBarState.NEAREST,
        state: String = "",
        city : String = "",
    ) : List<Ride> =
        if ((state.isEmpty() || state.lowercase() == "all states") && (city.isEmpty() || city.lowercase() == "all cities") )  getRideList(optionState) // get All List
        else if (state.isEmpty() || state.lowercase() == "all states")  getRideList(optionState).filter { // city empty and state is not
            it.state == state
        }
        else if (city.isEmpty() || city.lowercase() == "all cities")  getRideList(optionState).filter { // state empty and city is not
            it.city == city
        }
        else getRideList(optionState).filter { // state is not empty and city is not empty
            it.state == state && it.city == city
        }



    fun getStatesList(
        optionState : OptionsBarState =OptionsBarState.NEAREST,
        ) : List<String> {
        val newList = mutableListOf<String>("All States")
        getRideList(optionState).forEach {
            if (it.state !in newList) newList.add(it.state)
        }
        return newList
    }


    fun getCitiesList(
        optionState : OptionsBarState =OptionsBarState.NEAREST,
        state : String = ""
    ) : List<String> {
        val newList = mutableListOf<String>("All Cities")
        getRideList(optionState).forEach {
            if((state.isNotEmpty() && state.lowercase() != "all states") && (it.state == state) && (it.city !in newList)) newList.add(it.city)
            else if ((state.isEmpty() || state.lowercase() == "all states") && (it.city !in newList)) newList.add(it.city)
        }
        return newList
    }


}
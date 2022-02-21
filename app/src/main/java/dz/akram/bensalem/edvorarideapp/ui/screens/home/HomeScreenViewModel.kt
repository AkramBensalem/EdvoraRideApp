package dz.akram.bensalem.edvorarideapp.ui.screens.home


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dz.akram.bensalem.edvorarideapp.data.Ride
import dz.akram.bensalem.edvorarideapp.data.User
import dz.akram.bensalem.edvorarideapp.repository.RideRepository
import dz.akram.bensalem.edvorarideapp.ui.components.homescreen.OptionsBarState
import dz.akram.bensalem.edvorarideapp.utils.time.TimeConverter
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val repository: RideRepository,
) : ViewModel() {


    private val ridesList = MutableStateFlow< List<Ride>>(listOf())
    private val user =  MutableStateFlow<User?>(null)
    private val screenState = MutableStateFlow(OptionsBarState.NEAREST)
    private val state = MutableStateFlow<String>("")
    private val city = MutableStateFlow<String>("")


    val uiState: StateFlow<HomeScreenState> = combine(
        ridesList,
        user,
        screenState,
        state,
        city
    ) { ridesList, user,screenState, state , city->
        HomeScreenState.Data(
            ridesList =ridesList,
            user = user,
            screenState=screenState,
            state = state,
            city =  city

        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(0),
        initialValue = HomeScreenState.Empty
    )

    init {
        getUser()
        getRidesByFilteringAndSorted()
    }



    private fun getUser(){
        user.value = repository.getUser()
    }

    private fun getRidesByFilteringAndSorted(){
        viewModelScope.launch {
            ridesList.value = repository.getRideListFilterByStateOrCity(
                optionState = screenState.value,
                state = state.value,
                city = city.value
            )
        }
    }


    fun getUpComingAndPastNmbr() : Pair<Int, Int>{
        val list = repository.getRideListFilterByStateOrCity(
            state = state.value,
            city = city.value
        )

        var upcoming = 0
        var past = 0

        list.forEach {
            if (it.date >= TimeConverter.currentTimeToLong()) upcoming +=1
            else if (it.date < TimeConverter.currentTimeToLong()) past += 1
        }
        return upcoming to past
    }


    fun onOptionBarClicked(
        option : OptionsBarState
    ){
        screenState.value = option
        getRidesByFilteringAndSorted() // filter and sorter of the new list
    }

    fun changeCity(
        city : String
    ){
        this.city.value = city
        getRidesByFilteringAndSorted() // filter and sorter of the new list

    }

    fun changeState(
        state : String
    ){
        this.state.value = state
        getRidesByFilteringAndSorted() // filter and sorter of the new list
    }


    fun getStatesList() = repository.getStatesList(
        optionState = screenState.value
        )

    fun getCitiesList() = repository.getCitiesList(
        optionState = screenState.value,
        state = state.value
    )


}
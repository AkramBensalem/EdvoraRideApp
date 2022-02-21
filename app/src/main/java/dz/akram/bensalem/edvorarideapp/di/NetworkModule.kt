package dz.akram.bensalem.edvorarideapp.di


import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dz.akram.bensalem.edvorarideapp.data.Ride
import dz.akram.bensalem.edvorarideapp.data.User
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    /**
     * Provide Fake data to inject and test
     */

    @Provides
@Singleton
fun provideUserApi() = User(
    stationCode = 40,
    name = "Akram Bensalem",
    profileKey = "https://picsum.photos/536/355"
)

    @Provides
    @Singleton
    fun provideRideList() = listOf<Ride>(
        Ride(
            id = 1,
            origin_station_code = 23,
            station_path = listOf(23, 42, 45, 48, 56, 60, 77, 81, 93),
            destination_station_code = 98,
            date = 1644924365,
            map_url = "url",
            state = "Maharashtra",
            city = "Panvel"
        ),
        Ride(
            id = 2,
            origin_station_code = 13,
            station_path = listOf(20, 39, 40, 42, 54, 63, 72, 88, 98),
            destination_station_code = 98,
            date = 1644924365,
            map_url = "url",
            state = "Maharashtra",
            city = "Panvel"
        ),

        Ride(
            id = 3,
            origin_station_code = 13,
            station_path = listOf(13, 25, 41, 48, 59, 64, 75, 81, 91),
            destination_station_code = 91,
            date = 1644924365,
            map_url = "url",
            state = "Maharashtra",
            city = "Panvel"
        ),
        Ride(
            id = 4,
            origin_station_code = 13,
            station_path = listOf(13, 25, 41, 48, 59, 64, 75, 81, 91),
            destination_station_code = 91,
            date = 10640004924365,
            map_url = "url",
            state = "Algeria",
            city = "Medea"
        )
    )



}
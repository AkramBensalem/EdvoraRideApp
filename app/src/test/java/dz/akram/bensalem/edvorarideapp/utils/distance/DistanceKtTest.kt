package dz.akram.bensalem.edvorarideapp.utils.distance

import org.junit.Assert
import org.junit.Test


internal class DistanceKtTest{


    @Test
    fun `Calculate Distance`(){
        //Given
        val currentStation = 40
        val path001 = listOf<Int>(23, 42, 45, 48, 56, 60, 77, 81, 93)
        val path002 = listOf<Int>(20, 39, 40, 42, 54, 63, 72, 88, 98)


        // When
        val distance001 = calculateDistance(
            currentStation = currentStation,
            path = path001
        )

        val distance002 = calculateDistance(
            currentStation = currentStation,
            path = path002
        )


        //Then
        Assert.assertEquals(
            2,  // excepted 2
            distance001
        )


        Assert.assertEquals(
            0, // excepted 0
            distance002
        )
    }


    @Test
    fun `Calculate Distance When CurrentStation is Greater than Destination Station Value`(){
        //Given
        val currentStation = 101
        val path = listOf<Int>(23, 42, 45, 48, 56, 60, 77, 81, 93)


        // When
        val distance = calculateDistance(
            currentStation = currentStation,
            path = path
        )

        //Then
        Assert.assertEquals(
            0,  // excepted 0
            distance
        )
    }

}
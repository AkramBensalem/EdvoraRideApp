package dz.akram.bensalem.edvorarideapp.utils.time

import dz.akram.bensalem.edvorarideapp.utils.time.TimeConverter.convertLongToDateWithoutDay
import dz.akram.bensalem.edvorarideapp.utils.time.TimeConverter.convertLongToDay
import dz.akram.bensalem.edvorarideapp.utils.time.TimeConverter.getDay
import org.junit.Test
import org.junit.Assert.assertEquals
import java.util.*


internal class TimeConverterKtTest {

    @Test
    fun `Convert Date To Just Day`() {
        // Given
        val date = Date(1644924365)

        // When
        val day = convertLongToDay(date)

        // Given
        assertEquals(
            "20",
            day
        )

    }

    @Test
    fun `Get Day as a format of Ordinal Number`() {
        // Given
        val firstDay = "1"
        val secondDay = "2"
        val thirdDay = "3"

        // When
        val firstDayResult = getDay(firstDay)
        val secondDayResult = getDay(secondDay)
        val thirdDayResult = getDay(thirdDay)


        // Then
        assertEquals(
           "1st",
            firstDayResult
        )
        assertEquals(
            "2nd",
            secondDayResult
        )
        assertEquals(
            "3rd",
            thirdDayResult
        )

        // test all the other available day
        for (i in 4..31){

            val otherDayResult = getDay(i.toString())

            assertEquals(
                "${i}th",
                otherDayResult
            )
        }

    }

    @Test
    fun `Day format can't convert to Ordinal Number`() {
        // Given
        val negativeDay = "-1"
        val dayZero ="0"
        val dayPass31 = "32"
        // When
        val result1 = getDay(negativeDay)
        val result2 = getDay(dayZero)
        val result3 = getDay(dayPass31)

        // Then
        assertEquals(
            null,
            result1
        )
        assertEquals(
            null,
            result2
        )
        assertEquals(
            null,
            result3
        )
    }



    @Test
    fun `Convert Long To Date Without Day`() {

        // Given
        val date = Date(1644924365) // Jan 1970 01:55

        // When
        val day = convertLongToDateWithoutDay(date)

        // Given
        assertEquals(
            "Jan 1970 01:55",
            day
        )

    }


}
package dz.akram.bensalem.edvorarideapp.utils.time

import java.text.SimpleDateFormat
import java.util.*

object TimeConverter {
    // Get just the day
    fun convertLongToDay(
        date: Date,
        locale : Locale = Locale.ENGLISH
    ) : String = SimpleDateFormat("dd", locale).format(date)


    /**
     * Get the day as a format ["Ordinal Number"]
     * for example: day 15 will be -> "15th"
     *              day 1 will be -> "1st"
     *              day 2 will be -> "1nd"
     */
    fun getDay(day: String): String? =
        try {
            when (day.toInt()) {
                1 -> "${day}st"
                2 -> "${day}nd"
                3 -> "${day}rd"
                in 4 .. 31 -> "${day}th"
                else -> null // return null when the date format is not correct
            }
        } catch (e : Exception){ // When the date format is not correct
            null
        }


    // Get all other date without the day
    fun convertLongToDateWithoutDay(
        date: Date,
        locale : Locale = Locale.ENGLISH
    )
            : String = SimpleDateFormat("MMM yyyy HH:mm", locale).format(date)


    fun convertLongToTime(time: Long): String {
        val date = Date(time)

        // Append the results in one string
        return "${convertLongToDay(date)} ${convertLongToDateWithoutDay(date)}"

    }

    fun currentTimeToLong(): Long {
        return System.currentTimeMillis()
    }
}




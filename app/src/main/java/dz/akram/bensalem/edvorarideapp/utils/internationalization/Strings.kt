package dz.akram.bensalem.edvorarideapp.utils.internationalization

import androidx.compose.runtime.staticCompositionLocalOf


/**
 * Supported languages
 * For now we have just [English]
 */
object Locales {
    const val EN = "en"
}

val strings = mapOf(
    Locales.EN to EnStrings,
)

val LocalStrings = staticCompositionLocalOf { EnStrings }


data class Strings(
    val appName: String,
    val profileIcon: String
)



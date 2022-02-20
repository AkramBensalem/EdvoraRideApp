package dz.akram.bensalem.edvorarideapp.utils.internationalization

import cafe.adriel.lyricist.processor.Strings

/**
 * [English] is the default language for the app
 * English translations
 */

@Strings(languageTag = Locales.EN, default = true)
val EnStrings = Strings(
    appName = "Edvora",
    profileIcon  = "Your Profile Icon"
)

package dz.akram.bensalem.edvorarideapp.data


enum class Options{
    UPCOMING()
}

data class OptionCategories(
    val id : Int,
    val title : String,
    val repetitionNumber : Int,
)

package dz.akram.bensalem.edvorarideapp.utils.distance

fun calculateDistance(
    currentStation : Int,
    path : List<Int>,
) : Int {
    if (path.isNullOrEmpty()) return 0 // there is no path
    var minDistance = Int.MAX_VALUE

    path.forEach { station ->
        when (val distance = station - currentStation) {
             0 -> return 0 // Min Distance is Zero (Current Distance is at Station)
             in 1..Int.MAX_VALUE -> if (distance < minDistance) {
                 minDistance = distance
             }
        }
    }
    return if(minDistance != Int.MAX_VALUE)
        minDistance
    else 0  // the case of the current station is greater than all values of the path
}
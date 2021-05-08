package example.tutorial.satellite


class WeatherForecastTV(val satellite: Satellite, val closet: Closet) {

    fun getSuitableCloth():String {
        val temperature = satellite.getTemperature()

        val cloth = when {
            temperature > 25.0 -> "半袖"
            temperature < 10.0 -> "厚着"
            else -> "羽織もの"
        }

        closet.pickUpCloth(cloth)

        return cloth
    }
}
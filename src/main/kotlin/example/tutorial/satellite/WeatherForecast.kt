package example.tutorial.satellite

class WeatherForecast(val satellite: Satellite) {
    fun shouldBringUmbrella(): Boolean {
        val weather = satellite.getWeather()
        return when (weather) {
            "雨" -> true
            else -> false
        }
    }
}
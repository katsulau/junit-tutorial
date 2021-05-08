package example.tutorial.satellite

class SatelliteStub(val anyWeather: String): Satellite() {
    override fun getWeather(): String {
        return anyWeather
    }
}
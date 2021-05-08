package example.tutorial.satellite

class MockWeatherRecorder: WeatherRecorder() {

    var weather = ""
    var isCalled = false

    /**
     *
     */
    override fun record(weather: String) {
        this.weather = weather
        isCalled = true
    }
}
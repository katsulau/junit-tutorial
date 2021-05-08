package example.tutorial.satellite

import java.lang.Exception
import java.lang.IllegalStateException


class WeatherForecast(val satellite: Satellite, val recorder: WeatherRecorder) {

    /**
     *
     * 入力が外部に依存しているパターン
     * ここでは、つまりweatherに依存する = satelliteに依存するという意味。
     *
     * このときtestには、スタブを用いる
     */
    fun shouldBringUmbrella(): Boolean {
        val weather = satellite.getWeather()
        return when (weather) {
            "雨" -> true
            else -> false
        }
    }


    /**
     * recordCurrentWeatherメソッドは返り値がないため、アサーションによって戻り値を確認することができない。
     * また、出力が外部に依存(recorder)に依存しているが、このような場合はモックを用いてテストを行う。
     */
    fun recordCurrentWeather() {
        val weather = satellite.getWeather()
        recorder.record(weather)
    }
}
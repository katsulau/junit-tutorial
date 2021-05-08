package example.tutorial.satellite

import kotlin.random.Random

open class Satellite {

    open fun getWeather(): String {
        val weatherList = listOf("晴れ", "曇り", "雨")
        val index = Random.nextInt(weatherList.size)
        return weatherList[index]
    }

    open fun getTemperature(): Double {
        return Random.nextDouble(-10.0, 40.0)
    }
}
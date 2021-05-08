import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import example.tutorial.satellite.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test


class WeatherForecastTest {

    lateinit var weatherForecast: WeatherForecast
    lateinit var weatherRecorder: WeatherRecorder

    @Before
    fun setUp() {
        val satellite = Satellite()
        weatherRecorder = mock(name = "MockRecorder")
        weatherForecast = WeatherForecast(satellite, weatherRecorder)
    }

    /**
     *
     * ここでは、あくまでMockを継承を用いて作成している
     * 天気を返す
     */
    @Test
    fun getWeatherTest() {
        val satelliteStub = SatelliteStub("雨")

        val weatherRecorder = MockWeatherRecorder()

        // satelliteStubは、雨を返すので、trueになる
        val actual = WeatherForecast(satelliteStub, weatherRecorder).shouldBringUmbrella()

        val expected = true

        assertThat(actual).isEqualTo(expected)
    }


    /**
     * ここでは、あくまでMockを継承を用いて作成している
     * recordに天気が渡されて、呼び出される。
     */
    @Test
    fun recordCurrentWeatherTest() {

        val satellite = Satellite()
        val mockWeatherRecorder = MockWeatherRecorder()

        val weatherForecast = WeatherForecast(satellite, mockWeatherRecorder)

        // メソッド呼び出し
        weatherForecast.recordCurrentWeather()

        // recordCurrentWeatherメソッドが呼び出された後には、クラス変数が変更されているはずなので、確認
        assertThat(mockWeatherRecorder.isCalled).isEqualTo(true)
        assertThat(mockWeatherRecorder.weather).isIn("晴れ", "曇り", "雨")
    }


    @Test
    fun recordCurrentWeatherでrecordメソッドが呼び出されている() {
        weatherForecast.recordCurrentWeather()

        // weatherRecorderのrecordメソッドが１回呼ばれたことを意味する。any()としているのは、recordメソッドが呼ばれたとき、
        // recordメソッドの引数は何でもいいよ、という意味。any()をここで使う理由だが、anyのところは、実装を見てみると、satellite.getWeather()に
        // 依存していることが分かる。そのため、このテストで確認したい内容ではない。satellite.getWeather()が何を返すか、というのは、
        // satellite.getWeather()のテストを別で書くため、ここではany()で良いということになる。
        verify(weatherRecorder, times(1)).record(any())
    }
}
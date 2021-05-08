import example.tutorial.satellite.SatelliteStub
import example.tutorial.satellite.WeatherForecast
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class SatelliteTest {


    /**
     *
     * 天気を返す
     */
    @Test
    fun getWeatherTest() {
        val satelliteStub = SatelliteStub("雨")

        // satelliteStubは、雨を返すので、trueになる
        val actual = WeatherForecast(satelliteStub).shouldBringUmbrella()

        val expected = true

        assertThat(actual).isEqualTo(expected)
    }
}
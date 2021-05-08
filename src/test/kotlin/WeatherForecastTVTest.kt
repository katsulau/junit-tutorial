import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import example.tutorial.satellite.Closet
import example.tutorial.satellite.Satellite
import example.tutorial.satellite.WeatherForecastTV
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test

class WeatherForecastTVTest {

    lateinit var satellite: Satellite
    lateinit var closet: Closet

    @Before
    fun setUp() {
        satellite = mock(name = "MockSatellite")
        closet = mock(name = "MockCloset")
    }

    /**
     * 正常系
     * 気温35度、半袖の場合
     */
    @Test
    fun getSuitableClothPositiveHansode() {

        val weatherForecastTV = WeatherForecastTV(satellite, closet)

        whenever(satellite.getTemperature()).thenReturn(35.0)

        val actual = weatherForecastTV.getSuitableCloth()

        val expected = "半袖"

        assertThat(actual).isEqualTo(expected)
        verify(closet, times(1)).pickUpCloth("半袖")

    }


    /**
     * 正常系
     *
     * 境界値 25.1度, 半袖
     */
    @Test
    fun getSuitableClothPositiveHansodeBorder() {
        val weatherForecastTV = WeatherForecastTV(satellite, closet)

        whenever(satellite.getTemperature()).thenReturn(25.1)
        val actual = weatherForecastTV.getSuitableCloth()
        val expected = "半袖"
        assertThat(actual).isEqualTo(expected)
        verify(closet, times(1)).pickUpCloth("半袖")

    }

    /**
     * 正常系
     *
     * 境界値 25.0度, 羽織りもの
     */
    @Test
    fun getSuitableClothPositiveHaoirimonoMaxBorder() {
        val weatherForecastTV = WeatherForecastTV(satellite, closet)

        whenever(satellite.getTemperature()).thenReturn(25.0)
        val actual = weatherForecastTV.getSuitableCloth()
        val expected = "羽織もの"
        assertThat(actual).isEqualTo(expected)
        verify(closet, times(1)).pickUpCloth("羽織もの")

    }

    /**
     * 正常系
     *
     * 同値 10.0度, 羽織りもの
     */
    @Test
    fun getSuitableClothPositiveHaoirimonoMinBorder() {
        val weatherForecastTV = WeatherForecastTV(satellite, closet)

        whenever(satellite.getTemperature()).thenReturn(10.0)
        val actual = weatherForecastTV.getSuitableCloth()
        val expected = "羽織もの"
        assertThat(actual).isEqualTo(expected)
        verify(closet, times(1)).pickUpCloth("羽織もの")

    }

    /**
     * 正常系
     *
     * 境界値 9.9度, 厚着
     */
    @Test
    fun getSuitableClothPositiveAtsugiMaxBorder() {
        val weatherForecastTV = WeatherForecastTV(satellite, closet)

        whenever(satellite.getTemperature()).thenReturn(9.9)
        val actual = weatherForecastTV.getSuitableCloth()
        val expected = "厚着"
        assertThat(actual).isEqualTo(expected)
        verify(closet, times(1)).pickUpCloth("厚着")
    }

    /**
     * 正常系
     *
     * -5度, 厚着
     */
    @Test
    fun getSuitableClothPositiveAtsugi() {
        val weatherForecastTV = WeatherForecastTV(satellite, closet)

        whenever(satellite.getTemperature()).thenReturn(-5.0)
        val actual = weatherForecastTV.getSuitableCloth()
        val expected = "厚着"
        assertThat(actual).isEqualTo(expected)

        verify(closet, times(1)).pickUpCloth("厚着")
    }
}
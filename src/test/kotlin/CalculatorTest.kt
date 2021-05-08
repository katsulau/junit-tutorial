import example.tutorial.Calculator
import org.junit.Test
import org.assertj.core.api.Assertions.*

class CalculatorTest {


    /**
     * 掛け算の結果を取得できる
     */
    @Test
    fun multiply() {
        val calculator = Calculator()
        val actual = calculator.multiply(2, 3)
        val expected = 6
        assertThat(actual).isEqualTo(expected)
    }


    /**
     * 割り算の結果を取得できる
     */
    @Test
    fun divide() {
        val calculator = Calculator()
        val actual = calculator.divide(10, 5)
        val expected = 2
        assertThat(actual).isEqualTo(expected)
    }
}
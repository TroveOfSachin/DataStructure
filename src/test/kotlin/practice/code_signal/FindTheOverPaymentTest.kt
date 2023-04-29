package practice.code_signal

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class FindTheOverPaymentTest {

    val sol = FindTheOverPayment()


    private fun solution(prices: MutableList<Double>, notes: MutableList<String>, x: Double, expected: Boolean) {
        assertEquals(expected, sol.solution(prices, notes, x))
    }


    @Test
    fun solution_001() {
        val prices = mutableListOf(110, 95, 70).map { it.toDouble() }
        val nodeTest = arrayListOf(
            "10.0% higher than in-store",
            "5.0% lower than in-store",
            "Same as in-store"
        )
        val x = 5.0
        val expected = true

        solution(prices.toMutableList(), nodeTest, x, expected)

    }

    @Test
    fun solution_002() {
        val prices = arrayListOf(48, 165).map { it.toDouble() }
        val nodeTest = arrayListOf(
            "20.00% lower than in-store",
            "10.00% higher than in-store"
        )
        val x = 2.0
        val expected = false
        solution(prices.toMutableList(), nodeTest, x, expected)

    }

    @Test
    fun solution_003() {
        val prices = arrayListOf(24.42, 24.42, 24.2424, 85.23).map { it.toDouble() }
        val nodeTest = arrayListOf(
            "13.157% higher than in-store",
            "13.157% lower than in-store",
            "Same as in-store",
            "19.24% higher than in-store"
        )
        val x = 24.24
        val expected = true
        solution(prices.toMutableList(), nodeTest, x, expected)
    }


    @Test
    fun solution_004() {
        val prices = arrayListOf(220).map { it.toDouble() }
        val nodeTest = arrayListOf(
            "120.0000% higher than in-store"
        )
        val x = 120.0
        val expected = true
        solution(prices.toMutableList(), nodeTest, x, expected)
    }
}
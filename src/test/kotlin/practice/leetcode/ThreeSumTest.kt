package practice.leetcode

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.test.assertContentEquals

class ThreeSumTest {

    val t = ThreeSum()

    private fun threeSumTest(input: IntArray, expected: List<List<Int>>) {
        assertContentEquals(expected, t.threeSum(input))
    }


    @Test
    fun threeSumTest1() {
        val input = intArrayOf(-1, 0, 1, 2, -1, -4)
        val expected = listOf(listOf(-1, -1, 2), listOf(-1, 0, 1))
        threeSumTest(input, expected)
    }
}
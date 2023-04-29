package practice.leetcode

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class ContainerWithMostWaterTest {

    val c = ContainerWithMostWater()

    fun maxArea(input: IntArray, expected: Int) {

        assertEquals(expected, c.maxArea(input))
    }

    @Test
    fun maxAreaTest1() {
        val input = intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)
        val expected = 49
        maxArea(input, expected)
    }

    @Test
    fun maxAreaTest2() {
        val input = intArrayOf(1, 1)
        val expected = 1
        maxArea(input, expected)
    }


    @Test
    fun maxAreaTest3() {
        val input = intArrayOf(1, 1, 3)
        val expected = 2
        maxArea(input, expected)
    }

    @Test
    fun maxAreaTest4() {
        val input = intArrayOf(1, 2)
        val expected = 1
        maxArea(input, expected)
    }

    @Test
    fun maxAreaTest5() {
        val input = intArrayOf(1,5,6,3,9,3,55,8,2,3,0,2,3,232)
        val expected = 385
        maxArea(input, expected)
    }
}
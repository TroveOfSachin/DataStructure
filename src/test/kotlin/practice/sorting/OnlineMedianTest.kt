package practice.sorting

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import kotlin.test.assertContentEquals

class OnlineMedianTest {

    val onlineMedian = OnlineMedian()
    @Test
    fun findMedianTest0() {
        val input = arrayListOf(3, 8, 5, 2)
        val expected = arrayListOf(3, 5, 5, 4)

        assertContentEquals(expected, onlineMedian.findMedian(input))
    }

    @Test
    fun findMedianTest1() {
        val input = arrayListOf(1000000000, 999999997)
        val expected = arrayListOf(1000000000, 999999998)

        assertContentEquals(expected, onlineMedian.findMedian(input))
    }

    @Test
    fun findMedianTest2() {
        val input = arrayListOf(4, 3, 2, 1)
        val expected = arrayListOf(4, 3, 3, 2)

        assertContentEquals(expected, onlineMedian.findMedian(input))
    }

    @Test
    fun findMedianTest3() {
        val input = arrayListOf(1, 2, 3, 4, 5)
        val expected = arrayListOf(1, 1, 2, 2, 3)

        assertContentEquals(expected, onlineMedian.findMedian(input))
    }
}
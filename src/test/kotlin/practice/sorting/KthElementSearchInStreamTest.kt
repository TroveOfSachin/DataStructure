package practice.sorting

import org.junit.jupiter.api.Test

import kotlin.collections.ArrayList
import kotlin.test.assertContentEquals

class KthElementSearchInStreamTest {


    val kthElementSearchInStream = KthElementSearchInStream()

    private fun findKthLargestTest(
        initial: ArrayList<Int>,
        appended: ArrayList<Int>,
        kthIndex: Int,
        expected: ArrayList<Int>
    ) {
        val actual = kthElementSearchInStream.findKthLargest(initial, appended, kthIndex)
        assertContentEquals(expected, actual)
    }

    @Test
    fun findKthLargestTest1() {

        val initialStream = arrayListOf(4, 6)
        val appendedStream = arrayListOf(5, 2, 20)
        val kthIndex = 4
        val expected = arrayListOf(5, 5, 6)
        findKthLargestTest(initialStream, appendedStream, kthIndex, expected)
    }

    @Test
    fun findKthLargestTest2() {

        val initialStream = arrayListOf(1, 1)
        val appendedStream = arrayListOf(2, 3, 4, 5)
        val kthIndex = 2
        val expected = arrayListOf(1, 2, 3, 4)
        findKthLargestTest(initialStream, appendedStream, kthIndex, expected)
    }

    @Test
    fun findKthLargestTest3() {

        val initialStream = arrayListOf(2, 1)
        val appendedStream = arrayListOf(1, 1, 1, 1)
        val kthIndex = 2
        val expected = arrayListOf(1, 1, 1, 1)
        findKthLargestTest(initialStream, appendedStream, kthIndex, expected)
    }

    @Test
    fun findKthLargestTest4() {

        val initialStream = arrayListOf(2, 3, 1)
        val appendedStream = arrayListOf(4, 4, 4)
        val kthIndex = 3
        val expected = arrayListOf(2, 3, 4)
        findKthLargestTest(initialStream, appendedStream, kthIndex, expected)
    }

    @Test
    fun findKthLargestTest5() {

        val initialStream = arrayListOf(4, 5, 6, 7)
        val appendedStream = arrayListOf(5, 6, 4)
        val kthIndex = 3
        val expected = arrayListOf(5, 6, 6)
        findKthLargestTest(initialStream, appendedStream, kthIndex, expected)
    }

    @Test
    fun findKthLargestTest6() {

        val initialStream = arrayListOf(1000000000)
        val appendedStream = arrayListOf(1000000000)
        val kthIndex = 2
        val expected = arrayListOf(1000000000)
        findKthLargestTest(initialStream, appendedStream, kthIndex, expected)
    }

    @Test
    fun findKthLargestTest7() {

        val initialStream = arrayListOf(1000000000)
        val appendedStream = arrayListOf(1000000000)
        val kthIndex = 1
        val expected = arrayListOf(1000000000)
        findKthLargestTest(initialStream, appendedStream, kthIndex, expected)
    }

    @Test
    fun findKthLargestTest8() {

        val initialStream = arrayListOf<Int>()
        initialStream.addAll(0..99999)
        val appendedStream = arrayListOf<Int>()
        appendedStream.addAll(0..99999)
        val kthIndex = 50000
        val expected = arrayListOf(49999, 49998, 49997, 49996, 49995, 49994, 49993, 49992, 49991)
        findKthLargestTest(initialStream, appendedStream, kthIndex, expected)
    }


}
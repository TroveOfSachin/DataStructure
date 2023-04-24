package practice.leetcode

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class AddToArrayFormOfIntegerTest {


    private val add = AddToArrayFormOfInteger()

    private fun addToArrayForm(inputArray: IntArray, k: Int, expected: List<Int>) {

        assertEquals(expected, add.addToArrayForm(inputArray, k))
    }

    @Test
    fun addToArrayForm_000() {
        val inputArray = intArrayOf(1, 2, 0, 0)
        val k = 34
        val expected = listOf(1, 2, 3, 4)
        addToArrayForm(inputArray, k, expected)
    }

    @Test
    fun addToArrayForm_001() {
        val inputArray = intArrayOf(2, 7, 4)
        val k = 181
        val expected = listOf(4, 5, 5)
        addToArrayForm(inputArray, k, expected)
    }

    @Test
    fun addToArrayForm_002() {
        val inputArray = intArrayOf(2)
        val k = 14
        val expected = listOf(1, 6)
        addToArrayForm(inputArray, k, expected)
    }

    @Test
    fun addToArrayForm_003() {
        val inputArray = intArrayOf(2)
        val k = 14
        val expected = listOf(1, 6)
        addToArrayForm(inputArray, k, expected)
    }

    @Test
    fun addToArrayForm_004() {
        val inputArray = intArrayOf(2,1,5)
        val k = 806
        val expected = listOf(1,0,2,1)
        addToArrayForm(inputArray, k, expected)
    }


    @Test
    fun addToArrayForm_005() {
        val inputArray = intArrayOf(9,9,9,9,9,9,9,9,9,9)
        val k = 1
        val expected = listOf(1,0,0,0,0,0,0,0,0,0,0)
        addToArrayForm(inputArray, k, expected)
    }


@Test
    fun addToArrayForm_006() {
        val inputArray = intArrayOf(1,2,6,3,0,7,1,7,1,9,7,5,6,6,4,4,0,0,6,3)
        val k = 516
        val expected = listOf(1,2,6,3,0,7,1,7,1,9,7,5,6,6,4,4,0,5,7,9)
        addToArrayForm(inputArray, k, expected)
    }




}
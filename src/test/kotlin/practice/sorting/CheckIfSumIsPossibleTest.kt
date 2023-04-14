package practice.sorting

import com.sun.org.apache.xalan.internal.xsltc.dom.MultiValuedNodeHeapIterator.HeapNode
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CheckIfSumIsPossibleTest {


    val cisip = CheckIfSumIsPossible()

    private fun checkIfSumPossible(input: ArrayList<Long>, target: Long, expected: Boolean) {
        assertEquals(expected, cisip.checkIfSumPossible(input, target))
    }

    @Test
    fun checkIfSumPossibleTest1() {
        val input: ArrayList<Long> = arrayListOf(-10, 10)
        checkIfSumPossible(input, 0, true)
    }

    @Test
    fun checkIfSumPossibleTest_003() {
        val input: ArrayList<Long> = arrayListOf(1)
        checkIfSumPossible(input, 0, false)
    }


    @Test
    fun checkIfSumPossibleTest_006() {
        val input: ArrayList<Long> = arrayListOf(10,20)
        checkIfSumPossible(input, 0, false)
    }



    @Test
    fun checkIfSumPossibleTest2() {
        val input: ArrayList<Long> = arrayListOf(-5, -10)
        checkIfSumPossible(input, -15, true)
    }

    @Test
    fun checkIfSumPossibleTest_009() {
        val input: ArrayList<Long> = arrayListOf(-11,8)
        checkIfSumPossible(input, 8, true)
    }

    @Test
    fun checkIfSumPossibleTest4() {
        val input: ArrayList<Long> = arrayListOf(-3, -3, -3, -3)
        checkIfSumPossible(input, -12, true)

    }

    @Test
    fun checkIfSumPossibleTest_012() {
        val input: ArrayList<Long> = arrayListOf(-2, -3, 1)
        checkIfSumPossible(input, -4, true)
    }

    @Test
    fun checkIfSumPossibleTest6() {
        val input: ArrayList<Long> = arrayListOf(1, 2, 3, 4, 5)
        checkIfSumPossible(input, 5, true)
    }


    @Test
    fun checkIfSumPossibleTest7() {
        val input: ArrayList<Long> = arrayListOf(
            100000000000,
            100000000000,
            100000000000,
            100000000000,
            100000000000,
            100000000000,
            100000000000,
            100000000000
        )
        checkIfSumPossible(input, 900000000000, false)
    }

    @Test
    fun checkIfSumPossibleTest_017() {
        val input: ArrayList<Long> = arrayListOf(
            -10000000000,
            -10000000000,
            -80000000000,
            -30000000000,
            -180000000000,
            110000000000,
            60000000000
        )
        checkIfSumPossible(input, -90000000000, true)
    }

    @Test
    fun checkIfSumPossibleTest_018() {
        val input: ArrayList<Long> = arrayListOf(1000000000000, 1000000000000, 1000000000000)
        checkIfSumPossible(input, -1000000000000, false)
    }

    @Test
    fun checkIfSumPossibleTest_019() {
        val input: ArrayList<Long> = arrayListOf(-3, 3, -3, -2, -3, -4, -1, 1, -3, -2, -4, 0, 4, 3, -2, 3, -2, -1)
        checkIfSumPossible(input, 31, false)
    }

    @Test
    fun checkIfSumPossibleTest_020() {
        val input: ArrayList<Long> = arrayListOf(-4, 1, 3, -4, 2, 4, 2, 3, -4, -3, 0, -2, 0, -3, 1, -1, 4, -2)
        checkIfSumPossible(input, 5, true)
    }

//     022 - 0
//    {
//        "arr": [4, -3, 4, -3, 4, 0, 0, 3, 3, 3, -3, -1, -1, 0, -4, 0, -4, -3],
//        "k": 28
//    }

//    023 - 1
//    {
//        "arr": [-4, -1, 3, -2, 3, 0, 1, 2, 3, 1, -3, -1, 2, 3, 1, 0, 0, -2],
//        "k": 9
//    }


//    024 - 1
//    {
//        "arr": [3, 2, 0, -3, -1, 0, 2, -1, -4, -1, -2, -3, -4, -3, 1, -1, -3, 4],
//        "k": 3
//    }


//    025 --0
//    {
//        "arr": [-4, -3, -1, 3, -3, -2, -1, -3, 4, -2, -3, -4, -4, -2, -1, 4, 3, -1],
//        "k": 15
//    }

//    026 - 0
//    {
//        "arr": [-4, -1, -1, 3, -2, 3, -1, -2, 3, 1, -4, 1, 3, 1, 3, 3, 4, 1],
//        "k": -28
//    }

//    027 - 1
//    {
//        "arr": [2, -1, 4, 2, 3, -4, 4, 4, 3, 2, -1, -4, 1, 2, 4, 1, -4, 1],
//        "k": 2
//    }

//    028 - 0
//    {
//        "arr": [-2, 0, -4, -2, -1, -2, -1, -1, 4, -1, 2, 2, 4, 0, -4, 0, 2, 3],
//        "k": -33
//    }

//    030 - 0
//    {
//        "arr": [-2, -2, 0, -3, -3, -4, 4, 3, 0, -2, -3, 2, -4, -2, 2, -2, -2, 0],
//        "k": -35
//    }


//    031 - 1
//    {
//        "arr": [4, -4, -2, -3, 1, 3, -2, -2, -1, 1, -2, 1, 3, -4, 4, 0, 4, -1],
//        "k": -8
//    }


//    033 - 1
//    {
//        "arr": [-2, -1, 3, -1, -1, -3, 2, 1, -1, 1, -4, -2, 3, 0, 4, 2, -4, -4],
//        "k": 16
//    }

//    034 - 0
//    {
//        "arr": [0, 0, 2, 2, 1, 0, -2, 3, -1, -1, 4, 1, 2, -2, 0, -4, 1, -1],
//        "k": -22
//    }


}
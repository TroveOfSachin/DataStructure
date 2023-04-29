package practice.sorting

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class KthLargestElementSearchTest {

    val kthElementSearch = KthElementSearch()


    @Test
    fun findLargestTest1() {

        var input = arrayListOf(5, 1, 10, 3, 2)
        val kthIndex = 2
        val expected = 5
        findLargestTest(input, kthIndex,expected)
    }

    @Test
    fun findLargestTest2() {

        var input = arrayListOf(4, 1, 2, 2, 3)
        val kthIndex = 4
        val expected = 2
        findLargestTest(input, kthIndex,expected)
    }

    @Test
    fun findLargestTest3() {

        var input = arrayListOf(1)
        val kthIndex = 1
        val expected = 1
        findLargestTest(input, kthIndex,expected)
    }

    @Test
    fun findLargestTest4() {

        var input = arrayListOf(1, 1, 1, 3, 5, 4, 6)
        val kthIndex = 3
        val expected = 4
        findLargestTest(input, kthIndex,expected)
    }

    @Test
    fun findLargestTest5() {

        var input = arrayListOf(100, 0, 100)
        val kthIndex = 2
        val expected = 100
        findLargestTest(input, kthIndex,expected)
    }

    @Test
    fun findLargestTest6() {

        var input = arrayListOf(-1438, 193, 3974, 0, -148, -148, 12, 12)
        val kthIndex = 8
        val expected = -1438
        findLargestTest(input, kthIndex,expected)
    }

    @Test
    fun findLargestTest7() {

        var input = arrayListOf(1, 5, 2, 5, 3, 6)
        val kthIndex = 4
        val expected = 3
        findLargestTest(input, kthIndex,expected)
    }

    @Test
    fun findLargestTest8() {

        var input = arrayListOf(-1000000000, -1000000000, -1000000000, -1000000000, -1000000000)
        val kthIndex = 1
        val expected = -1000000000
        findLargestTest(input, kthIndex,expected)
    }

    @Test
    fun findLargestTest9() {

        var input = arrayListOf(2, 5, 1, -4, 6, 3)
        val kthIndex = 5
        val expected = 1
        findLargestTest(input, kthIndex,expected)
    }

    @Test
    fun findLargestTest10() {

        var input = arrayListOf(-1, 1, 5, 10, 100)
        val kthIndex = 2
        val expected = 10
        findLargestTest(input, kthIndex,expected)
    }

    @Test
    fun findLargestTest11() {

        var input = arrayListOf(-100, 0, 1, 100, 200, 399)
        val kthIndex = 4
        val expected = 1
        findLargestTest(input, kthIndex,expected)
    }
    
    private fun findLargestTest(input:ArrayList<Int>, kth:Int, expected:Int){
        val output = kthElementSearch.findLargestKWithHeap(input, kth)
        assertEquals(expected, output)
    }

    private fun findLargestTestWithQuickSelection(input:ArrayList<Int>, kth:Int, expected:Int){
        val output = kthElementSearch.findLargest(input, kth)
        assertEquals(expected, input[output])
    }
}
package practice.sorting

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class KthSmallestElementSearchTest {

    val kthElementSearch = KthElementSearch()


    @Test
    fun findSmallestTest1() {

        var input = arrayListOf(5, 1, 10, 3, 2)
        val kthIndex = 2
        val expected = 2
        findSmallestTest(input, kthIndex,expected)
    }

    @Test
    fun findSmallestTest2() {

        var input = arrayListOf(4, 1, 2, 2, 3)
        val kthIndex = 4
        val expected = 3
        findSmallestTest(input, kthIndex,expected)
    }

    @Test
    fun findSmallestTest3() {

        var input = arrayListOf(1)
        val kthIndex = 1
        val expected = 1
        findSmallestTest(input, kthIndex,expected)
    }

    @Test
    fun findSmallestTest4() {

        var input = arrayListOf(1, 1, 1, 3, 5, 4, 6)
        val kthIndex = 3
        val expected = 1
        findSmallestTest(input, kthIndex,expected)
    }

    @Test
    fun findSmallestTest5() {

        var input = arrayListOf(100, 0, 100)
        val kthIndex = 2
        val expected = 100
        findSmallestTest(input, kthIndex,expected)
    }

    @Test
    fun findSmallestTest6() {

        var input = arrayListOf(-1438, 193, 3974, 0, -148, -148, 12, 12)
        val kthIndex = 8
        val expected = 3974
        findSmallestTest(input, kthIndex,expected)
    }

    @Test
    fun findSmallestTest7() {

        var input = arrayListOf(1, 5, 2, 5, 3, 6)
        val kthIndex = 4
        val expected = 5
        findSmallestTest(input, kthIndex,expected)
    }

    @Test
    fun findSmallestTest8() {

        var input = arrayListOf(-1000000000, -1000000000, -1000000000, -1000000000, -1000000000)
        val kthIndex = 1
        val expected = -1000000000
        findSmallestTest(input, kthIndex,expected)
    }

    @Test
    fun findSmallestTest9() {

        var input = arrayListOf(2, 5, 1, -4, 6, 3)
        val kthIndex = 5
        val expected = 5
        findSmallestTest(input, kthIndex,expected)
    }

    @Test
    fun findSmallestTest10() {

        var input = arrayListOf(-1, 1, 5, 10, 100)
        val kthIndex = 2
        val expected = 1
        findSmallestTest(input, kthIndex,expected)
    }

    @Test
    fun findSmallestTest11() {

        var input = arrayListOf(-100, 0, 1, 100, 200, 399)
        val kthIndex = 4
        val expected = 100
        findSmallestTest(input, kthIndex,expected)
    }
    
    private fun findSmallestTest(input:ArrayList<Int>, kth:Int, expected:Int){
        val output = kthElementSearch.findSmallestKWithHeap(input, kth)
        assertEquals(expected, output)
    }

    private fun findSmallestWithQuickSelectionTest(input:ArrayList<Int>, kth:Int, expected:Int){
        val output = kthElementSearch.findSmallest(input, kth)
        assertEquals(expected, input[output])
    }
}
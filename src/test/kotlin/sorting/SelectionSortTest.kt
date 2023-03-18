package sorting

import jdk.nashorn.internal.objects.NativeArray.every
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.mockito.kotlin.any
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import kotlin.test.assertContains

class SelectionSortTest {

    @Test
    fun `sort for small reverse sorted array`() {


        val selectionSort = SelectionSort()
        val inputArray = arrayOf(3, 2, 4, 1)
        val output = arrayOf(1, 2, 3, 4)

        selectionSort.sort(inputArray)

        assertArrayEquals(output, inputArray, "OOps, Unexpected output")
    }
}
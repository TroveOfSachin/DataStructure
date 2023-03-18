package sorting

import RandomArrayGenerator
import java.util.concurrent.atomic.AtomicInteger


fun main() {
    val mergeSort = MergeSort()
    var inputArray = RandomArrayGenerator.getArray(20)
    println("UnSorted Array")
    println(inputArray.contentToString())
    println("Sorted Array")
    inputArray = mergeSort.sort(inputArray)
    println(inputArray.contentToString())
    println("Loop Count : ${mergeSort.loopIndex.get()}")
}

class MergeSort {

    val loopIndex: AtomicInteger = AtomicInteger()

    fun sort(inputArray: Array<Int>): Array<Int> {
        val sortedArray = sortHelper(inputArray, 0, inputArray.size - 1)


        return sortedArray
    }

    private fun sortHelper(inputArray: Array<Int>, start: Int, end: Int): Array<Int> {

        // checking leaf
        if (start == end) return inputArray

        // passing work to internal worker node

        // getting mid of the array
        val mid = (start + end) / 2

        // divided our input array into two half based on start and end.
        // handed over the work to worker node to do their sorting for left and right half.
        sortHelper(inputArray, start, mid) // left half of input array
        sortHelper(inputArray, mid + 1, end) // right half of input array

        // now we have sorted arrays of both the half's
        // Merging the two sorted array from the start index of both half arrays.


        var left = start // starting index of left half array
        var right = mid + 1 // starting index of right half array

        // need to merge into auxiliary or temporary array as we cannot easily swap two numbers in two array.
        var auxArray = emptyArray<Int>()//Array(end - start + 1) { 0 }

        while (left <= mid && right <= end) {
            loopIndex.incrementAndGet()
            if (inputArray[left] <= inputArray[right]) {
                auxArray += inputArray[left]
                left++
            } else {
                auxArray += inputArray[right]
                right++
            }
        }

        // Gather remaining elements either in left or right half of the array
        // first checking for left half
        while (left <= mid) {
            loopIndex.incrementAndGet()
            auxArray += inputArray[left]
            left++
        }
        // then checking for right half
        while (right <= end) {
            loopIndex.incrementAndGet()
            auxArray += inputArray[right]
            right++
        }

        // till now all the elements are sorted in auxiliary array. Need to copy it original array.
        auxArray.forEachIndexed { index, i ->
            loopIndex.incrementAndGet()
            inputArray[start + index] = i
        }

        return inputArray

    }


}
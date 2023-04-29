package sorting

import RandomArrayGenerator
import print
import swap
import java.util.concurrent.atomic.AtomicInteger

fun main() {
    val quickSort = QuickSort()
//    val inputArray = arrayOf(4, 2, 8, 7, 1, 3, 5, 6)
    var inputArray = RandomArrayGenerator.getArray(10)

//    val listOfFour = (1..10).map { 4 }
//    val inputArray = listOfFour.toTypedArray()

    inputArray.print("UnSorted Array")
    quickSort.sort(inputArray)

    inputArray.print("Sorted Array")

    println("Loop Counter : ${quickSort.loopIndex.get()}")
}

class QuickSort {

    val loopIndex: AtomicInteger = AtomicInteger()

    fun sort(inputArray: Array<Int>) {
        sortHelper(inputArray, 0, inputArray.lastIndex)
    }

    private fun sortHelper(inputArray: Array<Int>, start: Int, end: Int) {

        // leaf worker
        if (start >= end) {
            return
        }

        // divide the array in smaller and bigger partition.
        val smaller = hoareInPlacePartition(inputArray, start, end) // Optimized approach for partitioning

        // Iterating the same thing for left and right partition
        sortHelper(inputArray, start, smaller) // Left or smaller values partition than pivot
        sortHelper(inputArray, smaller + 1, end) // right or bigger values partition than pivot

    }

    /**
     * Doing parting in normal way. You can use [QuickSort.hoareInPlacePartition] for optimized approach
     *
     * @param inputArray Input Array
     * @param start start position for creating partition
     * @param end end position for the partition
     *
     * @return pivot element index after rearrangement from start to its mid-position in the partition
     *
     */
    fun lomutoPartition(inputArray: Array<Int>, start: Int, end: Int): Int {
        // divide & conquer
        // doing a partition of the given array by considering our first array element as a pivot called it as "start"
        // arranging remaining elements for smaller and bigger partition around pivot by using linear iteration

        var smaller = start
        for (bigger in start + 1..end) {
            loopIndex.incrementAndGet()
            if (inputArray[bigger] <= inputArray[start]) {
                smaller++
                inputArray.swap(smaller, bigger)
            }
        }
        // swapping pivot with last index of the smallest partition
        inputArray.swap(start, smaller)
        return smaller
    }

    /**
     * Doing parting in normal way. You can use [QuickSort.hoareInPlacePartition] for optimized approach
     *
     * @param inputArray Input Array
     * @param start start position for creating partition
     * @param end end position for the partition
     *
     * @return pivot element index after rearrangement from start to its mid-position in the partition
     *
     */
    fun hoareInPlacePartition(inputArray: Array<Int>, start: Int, end: Int): Int {
        // rather getting first element as a pivot element we will choose a random index as a pivot element
        // it will help us to avoid worst case time complexity

        inputArray.swap((start..end).random(), start)

        val pivot = inputArray[start]
        var smaller = start + 1
        var bigger = end

        while (smaller <= bigger) {

            loopIndex.incrementAndGet()

            // NOTE: Do not use <= pivot, it will not terminate recursion
            // as smaller value will be always same if all the elements are same in the inputArray
            if (inputArray[smaller] < pivot) {
                smaller++

            } else if (inputArray[bigger] > pivot) {
                bigger--

            } else {
                inputArray.swap(smaller, bigger)
                smaller++
                bigger--
            }
        }

        inputArray.swap(start, bigger) // or inputArray.swap(start, left - 1)

        return bigger
    }

}
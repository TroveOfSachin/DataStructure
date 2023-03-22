package practice.sorting

import java.util.*

import kotlin.collections.ArrayList

/**
 * ### Kth Largest In An Array
 * Given an array of integers, find the k-th largest number in it.
 *
 * #### Example One
 * ````
 * {
 *      "numbers": [5, 1, 10, 3, 2],
 *      "k": 2
 * }
 * ````
 * #### Output: `` 5 ``
 *
 * #### Example Two
 * ````
 * {
 *      "numbers": [4, 1, 2, 2, 3],
 *      "k": 4
 * }
 * ````
 * #### Output: ``2 ``
 *
 * #### Constraints:
 * - 1 <= array size <= 3 * 105
 * - -109 <= array elements <= 109
 * - 1 <= k <= array size
 */

fun main() {
    val input = arrayListOf(-100, 0, 1, 100, 200, 399)
    val outputLargest = KthElementSearch().findLargest(input, 4)


    println("Kth i.e 4 largest element =  ${input[outputLargest]}")
}

class KthElementSearch {

    fun findLargest(input: ArrayList<Int>, k: Int): Int {
        return sortLargest(input, 0, input.size - 1, input.size -k)
    }


    private fun sortLargest(input: ArrayList<Int>, start: Int, end: Int, k: Int): Int {

        if (start == end) return start

        var m = lumotoSort(input, start, end)

        return if (m ==  k) return k
        else if (k < m)
            sortLargest(input, start, m-1, k)
        else
            sortLargest(input, m + 1, end, k)

    }


    private fun lumotoSort(input: ArrayList<Int>, start: Int, end: Int): Int {
        Collections.swap(input, (start..end).random(), start)
        var orange = start
        for (green in start + 1..end) {
            if (input[green] < input[start]) {
                orange++
                Collections.swap(input, green, orange)
            }
        }
        Collections.swap(input, start, orange)

        return orange

    }


}
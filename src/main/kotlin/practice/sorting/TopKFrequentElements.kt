package practice.sorting

import java.util.Comparator
import kotlin.collections.ArrayList


/**
 * ### Top K Frequent Elements
 *
 * Given an integer array and a number k, find the k most frequent elements in the array.
 *
 * ### Example One
 * ````
 * {
 *      "arr": [1, 2, 3, 2, 4, 3, 1],
 *      "k": 2
 * }
 * ````
 * ### Output: `[3, 1]`
 *
 * ### Example Two
 * ````
 * {
 *      "arr": [1, 2, 1, 2, 3, 1],
 *      "k": 1
 * }
 * ````
 * ### Output: `[1]`
 *
 * ### Notes
 * - If multiple answers exist, return any.
 * - The order of numbers in the output array does not matter.
 *
 * Constraints:
 *
 * - 1 <= length of the given array <= 3 * 105
 * - 0 <= array element <= 3 * 105
 * - 1 <= k <= number of unique elements in the array
 */

fun main() {

    val topKFrequentElements = TopKFrequentElements()
    val output = topKFrequentElements.findKFrequentElements(arrayListOf(1, 2, 3, 2, 4, 3, 1), 2)
    println(output)
}


class TopKFrequentElements {

    fun findKFrequentElements(input: ArrayList<Int>, k: Int): ArrayList<Int> {

        val hash = mutableMapOf<Int, Int>()

        input.forEach {
            hash[it] = (hash.getOrDefault(it, 0)) + 1
        }
        val sorted =
            hash.entries.sortedWith { a: Map.Entry<Int, Int>, b: Map.Entry<Int, Int> -> b.value.compareTo(a.value) }
                .associate { it.toPair() }

        var kCounter = k
        val itr = sorted.iterator()
        val output = arrayListOf<Int>()

        while ( kCounter-- > 0) {
            output.add(itr.next().key)
        }

        return output
    }
}
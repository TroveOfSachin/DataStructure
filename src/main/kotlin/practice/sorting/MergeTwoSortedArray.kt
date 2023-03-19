package practice.sorting

import print


/**
 * #### Problem
 * ### Merge One Sorted Array Into Another
 *
 * First array has `n` positive numbers, and they are sorted in the non-descending order.
 *
 * Second array has `2n` numbers: first `n` are also positive and sorted in the same way but the last `n` are all zeroes.
 *
 * Merge the first array into the second and return the latter. You should get `2n` positive integers sorted in the non-descending order.
 *
 *#### Example
 * ````
 * {
 * "first": [1, 3, 5],
 * "second": [2, 4, 6, 0, 0, 0]
 * }
 * ````
 * #### Output
 *````
 * [1, 2, 3, 4, 5, 6]
 *````
 *
 * #### Constraints:
 *
 * - 1 <= n <= 10^5
 * - 1 <= array elements (except those zeroes) <= 2 * 10^9
 * - You can use only constant auxiliary space
 */

fun main() {

    val first = arrayListOf(1, 3, 5)
    val second = arrayListOf(2, 4, 6, 0, 0, 0)


    val output = MergeTwoSortedArray().sortOptimized(first, second)
    output.print("Output")
}


class MergeTwoSortedArray {

    fun sortWithAuxiliarySpace(first: ArrayList<Int>, second: ArrayList<Int>): ArrayList<Int> {

        var output = arrayListOf<Int>()
        second.removeAll { it == 0 }
        while (first.isNotEmpty() && second.isNotEmpty()) {
            if (first[0] < second[0]) output.add(first.removeAt(0))
            else output.add(second.removeAt(0))
        }
        while (first.isNotEmpty()) output.add(first.removeAt(0))
        while (second.isNotEmpty()) output.add(second.removeAt(0))
        return output
    }


    fun sortOptimized(first: ArrayList<Int>, second: ArrayList<Int>): ArrayList<Int> {

        var fEnd = first.size - 1
        var sMid = fEnd
        var sEnd = second.size - 1

        while (fEnd > 0 && sMid > 0) {
            second[sEnd--] = if (first[fEnd] > second[sMid]) first[fEnd--] else second[sMid--]
        }
        while (fEnd > 0) {
            second[sEnd--] = first[fEnd--]
        }

        return second
    }

}
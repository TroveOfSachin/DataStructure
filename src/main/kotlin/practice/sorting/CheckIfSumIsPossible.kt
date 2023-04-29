package practice.sorting

/**
 * ### Possible To Achieve Target Sum
 * Given a set of integers and a target value k, find whether there is a non-empty subset that sums up to k.
 * ````
 * Example One
 * {
 *  "arr": [2, 4, 8],
 *  "k": 6
 * }
 * Output: 1
 * Because 2 + 4 = 6.
 *
 * Example Two
 * {
 *  "arr": [2, 4, 6],
 *  "k": 5
 * }
 * Output: 0
 *
 * Because no subset of numbers from the input sums up to 5.
 * ````
 *
 * ### Notes
 * #### Constraints:
 *
 * 1 <= size of the input array <= 18
 * -1012 <= elements of the array, k <= 1012
 */

fun main() {

    val input: ArrayList<Long> = arrayListOf(-10, 10)
    val out = CheckIfSumIsPossible().checkIfSumPossible(input, 0L)
    println("Output: $out")
}


class CheckIfSumIsPossible {


    fun checkIfSumPossible(arr: ArrayList<Long>, k: Long): Boolean {
        return checkSum(arr, k, 0, 0, true)
    }


    private fun checkSum(numbs: ArrayList<Long>, target: Long, sum: Long, start: Int, isEmpty: Boolean): Boolean {

        if(sum == target && !isEmpty) return true

        if (start == numbs.size) return false


        //Inclusion
        var result = checkSum(numbs, target, sum + numbs[start], start + 1, false)
        if (result) return true

        // Exclusion
        result = checkSum(numbs, target, sum, start + 1, true)
        return result
    }


}
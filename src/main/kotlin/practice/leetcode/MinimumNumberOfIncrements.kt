package practice.leetcode

/**
 * [1526. Minimum Number of Increments on Subarrays to Form a Target Array](https://leetcode.com/problems/minimum-number-of-increments-on-subarrays-to-form-a-target-array/)
 */

fun main() {
    var input = intArrayOf(1, 2, 3, 4)


    val output = MinimumNumberOfIncrements().minNumberOperations(input)
    println("Min Increments : $output")


//    val output = MinimumNumberOfIncrements().construct2DArray(input, 1, 1)
//    println("Min Increments : ${output.contentDeepToString()}")


}

class MinimumNumberOfIncrements {


    fun construct2DArray(original: IntArray, m: Int, n: Int): Array<IntArray> {
        var output = Array(m) { intArrayOf() }

        if (m * n != original.size) return arrayOf()

        var row = 0
        var idx = 0
        while (idx < m) {
            output[idx] = original.copyOfRange(row, row + n)
            row += n
            idx++
        }





        return output
    }


    fun minNumberOperations(target: IntArray): Int {
        var ans = target[0]
        for (i in 1 until target.size) {
            if (target[i] > target[i - 1]) {
                ans += target[i] - target[i - 1]
            }
        }
        return ans
    }
}
package practice.leetcode

import kotlin.math.pow

/**
 * [1498. Number of Subsequences That Satisfy the Given Sum Condition](https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/)
 */


fun main() {
    val input = intArrayOf(14,4,6,6,20,8,5,6,8,12,6,10,14,9,17,16,9,7,14,11,14,15,13,11,10,18,13,17,17,14,17,7,9,5,10,13,8,5,18,20,7,5,5,15,19,14)
    val target = 22
    val ouptut = NumberOfSubsequencesThatSatisfyGivenSumCondition().numSubseq(input, target)
    println(ouptut)

}
class NumberOfSubsequencesThatSatisfyGivenSumCondition {
    val MOD = 1e9.toInt() + 7
    fun numSubseq(nums: IntArray, target: Int): Int {

        nums.sort()
        var left = 0
        var right = nums.size - 1
        var output = 0
        while (left <= right) {
            if (nums[left] + nums[right] > target) {
                right--
            } else {
                output += (2.0.pow(right-left) % MOD).toInt()

                left++
            }
        }
        return output % MOD
    }

    fun power(a: Int, b: Int): Int {
        val base = a % MOD
        if (a == 0) return 0

        if (b == 0) return 1
        if (b == 1) return (base % MOD)

        val output = power(base, b / 2)

        return if (b % 2 == 0) {
            (output * output % MOD)
        } else {
            (((output * output % MOD) * a) % MOD)
        }
    }


}

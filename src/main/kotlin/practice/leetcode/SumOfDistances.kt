package practice.leetcode

import print

/**
 * [2615. Sum of Distances](https://leetcode.com/problems/sum-of-distances/description/)
 */

fun main() {
    val input = intArrayOf(0,5,3)
    SumOfDistances().distance(input).print("Output")
}

class SumOfDistances {
    fun distance(nums: IntArray): LongArray {

        

        fun helper(current: Int, slate: LongArray): LongArray {
            if (current == nums.size) return slate

            var sum = 0L
            for (i in nums.indices) {
                if (i != current && nums[current] == nums[i]) {
                    sum += Math.abs(current - i)
                }
            }
            slate[current] = sum
            return helper(current + 1, slate)
        }
        return helper(0, LongArray(nums.size))
    }


}
package practice.leetcode.contest

import kotlin.math.abs

fun main() {
    SolutionContest2731().sumDistance(intArrayOf(-2, 0, 2), "RLL", 3)
}


data class Robot(var pos: Int, var isRight: Boolean = false)
class SolutionContest2731 {

    fun sumDistance(nums: IntArray, s: String, d: Int): Int {
        for (i in 0 until nums.size) {
            if (s[i] == 'R') {
                nums[i] += d
            } else
                nums[i] -= d
        }
        nums.sort()
        val mod = 1_000_000_007 // modulo value
        var sum:Long = 0
        var preFix:Long = 0
        for(i in nums.indices){
            sum = (sum + (i * nums[i].toLong()) - preFix % mod) % mod
            preFix += nums[i] % mod
        }
        return sum.toInt()
    }


    fun sumDistanceBruitForce(nums: IntArray, s: String, d: Int): Int {
        val mod = 1_000_000_007 // modulo value

        val sb = BooleanArray(s.length) { s[it] == 'R' }

        repeat(d) {
            for (i in nums.indices) {
                when (sb[i]) {
                    true -> nums[i] += 1
                    false -> nums[i] -= 1
                }
            }
            for (i in 1 until nums.size) {
                if (nums[i] == nums[i - 1]) {
                    sb[i] = !sb[i]
                    sb[i - 1] = !sb[i - 1]
                }
            }
        }

        var sum: Long = 0 // Use Long to handle large sums
        for (i in 0 until nums.size - 1) {
            for (j in i + 1 until nums.size) {
                sum = (sum + abs(nums[i] % mod - nums[j] % mod)) % mod
            }
        }

        return sum.toInt()


    }
}

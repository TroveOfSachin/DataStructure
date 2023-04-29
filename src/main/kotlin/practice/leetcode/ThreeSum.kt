package practice.leetcode

/**
 * ## [15. 3Sum](https://leetcode.com/problems/3sum/)
 */
class ThreeSum {

    fun threeSum(nums: IntArray): List<List<Int>> {

        val output = mutableListOf<List<Int>>()

        nums.forEachIndexed { index, it ->
            val x = twoSum(nums, index + 1, 0, it)
            if (x[0] + x[1] + it == 0) {
                output.add(arrayListOf(it, x[0], x[1]))
            }
        }

        return output
    }


    fun twoSum(nums: IntArray, start: Int, target: Int, supplement:Int): IntArray {
        // Write your code here.

        val complementMap = mutableMapOf<Int, Int>()

        for (index in start..nums.lastIndex) {

            val complement = target - nums[index] - supplement

            if (complementMap.containsKey(complement)) {
                return intArrayOf(nums[complementMap[complement]!!], nums[index])
            } else {
                complementMap[nums[index]] = index
            }
        }
        return IntArray(2)
    }
}
package practice.leetcode

/**
 * ## [15. 3Sum](https://leetcode.com/problems/3sum/)
 */
class ThreeSum {


    fun threeSum(nums: IntArray): List<List<Int>> {
        val res = mutableListOf<List<Int>>()
        nums.sort()

        for (i in nums.indices) {
            // If the current element is positive, skip the iteration as it is not possible to have a sum of zer
            if (nums[i] > 0)
                break

            // Avoiding duplicate calculation
            if (i > 0 && nums[i] == nums[i - 1])
                continue

            var left = i + 1
            var right = nums.size - 1

            while (left < right) {
                val sum = nums[i] + nums[left] + nums[right]

                when {
                    sum < 0 -> left++
                    sum > 0 -> right--
                    else -> {
                        res.add(listOf(nums[i], nums[left], nums[right]))
                        left++
                        right--

                        while (left < right && nums[left - 1] == nums[left])
                            left++
                    }
                }
            }
        }

        return res
    }
}
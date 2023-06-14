package practice.leetcode.contest

import print

/**
 * #### [2735. Collecting Chocolates](https://leetcode.com/contest/weekly-contest-349/problems/collecting-chocolates/)
 */

fun main() {
    intArrayOf(2, 3).sortedArray()


    (SolutionContest2735().summaryRanges(intArrayOf(-2147483648,-2147483647,2147483647))).print("Output")
}

class SolutionContest2735 {

    fun summaryRanges(nums: IntArray, start: Int = 0, end: Int = nums.size-1): List<String> {
        val result: MutableList<String> = mutableListOf()

        if (start > end) {
            return result
        }

        if (start == end) {
            result.add(nums[start].toString())
            return result
        }

        val mid = (start + end) / 2

        val leftRanges = summaryRanges(nums, start, mid)
        val rightRanges = summaryRanges(nums, mid + 1, end)

        if (nums[mid] + 1 < nums[mid + 1]) {
            result.add("${nums[start]}->${nums[mid]}")
            result.addAll(rightRanges)
        } else {
            result.addAll(leftRanges)
            result.addAll(rightRanges)
        }

        return result
    }

}
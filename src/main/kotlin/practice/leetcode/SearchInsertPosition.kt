package practice.leetcode

/**
 * #### [35. Search Insert Position](https://leetcode.com/problems/search-insert-position/)
 */

fun main() {
    val input = intArrayOf(1, 3, 5, 6)
    val output = SearchInsertPosition().searchInsert(input, 7)
    println(output)
}

class SearchInsertPosition {
    fun searchInsert(nums: IntArray, target: Int): Int {

        fun helper(start: Int, end: Int): Int {

            if (start == end) return start

            val mid = (start + end) / 2
            return if (target <= nums[mid]) {
                helper(start, mid)
            } else {
                helper(mid + 1, end)
            }

        }


        return helper(0, nums.size)
    }
}
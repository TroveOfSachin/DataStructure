package practice.leetcode

/**
 * ###[128. Longest Consecutive Sequence](https://leetcode.com/problems/longest-consecutive-sequence/)
 */


fun main() {

    val input = intArrayOf(9, 1, -7, -3, 2, 4, 8, 3, -1, 6, -2, -4, 7)
    println("Output: ${LongestConsecutiveSequence().longestConsecutive(input)}")
}

class LongestConsecutiveSequence {
    fun longestConsecutive(nums: IntArray): Int {
        val set = nums.toMutableSet()
        var max = 0
        var itr = 0
        while (set.isNotEmpty() && itr++ < nums.size) {
            val num = set.first()

            if (num - 1 !in set) {
                var curr = num
                var counter = 1

                while (++curr in set) {
                    counter++
                    set.remove(curr)
                }
                set.remove(num)
                max = maxOf(max, counter)

            } else if (num - 1 in set || num + 1 in set) {
                // just removing first element and adding at last
                set.remove(num)
                set.add(num)
            } else {
                set.remove(num)
                max = maxOf(max, 1)
            }

        }

        "".lowercase()

        return max
    }
}
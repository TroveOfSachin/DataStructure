package practice.leetcode

class Solution1802 {
    fun maxValue(n: Int, index: Int, maxSum: Int): Int {
        fun sum(n: Int): Long {
            return if (n < 0L) 0L else n.toLong() * (n.toLong() + 1L) / 2L
        }

        var l = 0
        var h = maxSum
        var max = l
        while (l <= h) {
            var mid = l + (h - l) / 2
            val s = n + mid + 2L + sum(mid - 1) - sum(mid - 1 - index) - sum(mid - n + index)
            if (s <= maxSum) {
                max = mid
                l = mid + 1
            } else
                h = mid - 1
        }
        return max + 1
    }
}
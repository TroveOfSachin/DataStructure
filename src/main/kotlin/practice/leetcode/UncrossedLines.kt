package practice.leetcode

/**
 * ### [1035. Uncrossed Lines](https://leetcode.com/problems/uncrossed-lines/)
 */

fun main() {
    val nums1 = intArrayOf(1, 4, 2)
    val nums2 = intArrayOf(1, 2, 4)
    println(UncrossedLines().maxUncrossedLines(nums1, nums2))

}

class UncrossedLines {
    fun maxUncrossedLines(nums1: IntArray, nums2: IntArray): Int {
        val m: Int = nums1.size
        val n: Int = nums2.size
        val dp = Array(m + 1) { IntArray(n + 1) }
        for (i in 1..m) {
            for (j in 1..n) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1])
                }
            }
        }
        return dp[m][n]
    }

}
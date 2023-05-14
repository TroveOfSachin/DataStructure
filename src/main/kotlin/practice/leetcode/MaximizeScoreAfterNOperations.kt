package practice.leetcode

/**
 * ### [1799. Maximize Score After N Operations](https://leetcode.com/problems/maximize-score-after-n-operations/)
 */
class MaximizeScoreAfterNOperations {

    fun maxScore(nums: IntArray): Int {
        val m = nums.size
        val g = Array(m) { IntArray(m) }
        for (i in 0 until m) {
            for (j in i + 1 until m) {
                g[i][j] = nums[i].gcd(nums[j])
            }
        }
        val f = IntArray(1 shl m)
        for (k in 0 until (1 shl m)) {
            val cnt = Integer.bitCount(k)
            if (cnt % 2 == 0) {
                for (i in 0 until m) {
                    if (k shr i and 1 == 1) {
                        for (j in i + 1 until m) {
                            if (k shr j and 1 == 1) {
                                f[k] = Math.max(
                                    f[k], f[k xor (1 shl i) xor (1 shl j)] + cnt / 2 * g[i][j]
                                )
                            }
                        }
                    }
                }
            }
        }
        return f[(1 shl m) - 1]
    }


    fun maxScoreOption2(nums: IntArray): Int {
        val m = nums.size
        val n = m / 2
        val dp = Array(n + 1) { IntArray(1 shl m) { -1 } }
        fun solve(i: Int, mask: Int): Int {
            if (i > n) return 0
            if (dp[i][mask] != -1) return dp[i][mask]

            for (j in 0 until m) {
                for (k in j + 1 until m) {
                    val newMask = (1 shl j) + (1 shl k)
                    if (mask and newMask == 0) dp[i][mask] =
                        maxOf(dp[i][mask], i * nums[j].gcd(nums[k]) + solve(i + 1, mask or newMask))
                }
            }

            return dp[i][mask]
        }
        return solve(1, 0)
    }

}

tailrec fun Int.gcd(b: Int): Int {
    return if (b == 0) this else b.gcd(this % b)
}
package practice.leetcode


fun main() {

    val res = MinimumCostToCutStick().minCost(9, intArrayOf(5, 6, 1, 4, 2))

    println(res)
}

class MinimumCostToCutStick {
    fun minCost(n: Int, cuts: IntArray): Int {

        val cutsSet = cuts.toMutableSet()
        cutsSet.add(0)  // Add the starting point of the stick
        cutsSet.add(n)  // Add the ending point of the stick

        fun divideAndConquer(left: Int, right: Int): Int {
            if (right - left <= 1) {
                return 0  // Base case: Stick cannot be further divided
            }

            val mid = (left + right) / 2  // Divide the stick at the midpoint

            if (mid in cutsSet) {
                // Calculate the cost for the left stick, right stick, and the cut itself
                val cost = (right - left)
                return cost + divideAndConquer(left, mid) + divideAndConquer(mid, right)
            } else {
                // Divide the problem into subproblems for the left and right sticks
                return divideAndConquer(left, mid) + divideAndConquer(mid, right)
            }
        }



        return divideAndConquer(0, n)
    }


    fun calculateCost(n: Int, cuts: IntArray): Int {

        cuts.sort()
        val m = cuts.size

        val dp = Array(m) { IntArray(m) { 0 } }

        for (len in 2..m) {
            for (i in 0 until m - len) {
                val j = i + len
                dp[i][j] = Int.MAX_VALUE

                for (k in i + 1 until j) {
                    dp[i][j] = minOf(dp[i][j], dp[i][k] + dp[k][j] + cuts[j] - cuts[i])
                }
            }
        }

        return dp[0][m - 1]
    }

//    // Example usage
//    val cuts = intArrayOf(5, 6, 1, 4, 2)
//    val n = 9
//    val minCost = calculateCost(cuts, n)
//    val stickCount = n + minCost
//    println(stickCount)  // Output: 22


}
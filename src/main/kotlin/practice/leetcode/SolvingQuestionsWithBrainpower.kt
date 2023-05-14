package practice.leetcode

/**
 * ### [2140. Solving Questions With Brainpower](https://leetcode.com/problems/solving-questions-with-brainpower/description/)
 */
class SolvingQuestionsWithBrainpower {
    fun mostPoints(questions: Array<IntArray>): Long {

        var maxSum = 0L

        val memo = LongArray(questions.size) { -1 }


        fun dfs(i: Int): Long {
            if (i >= questions.size)
                return 0L
            if (memo[i] != -1L) {
                return memo[i]
            }
            val nextSum = dfs(i + 1)
            var brainSum = questions[i][0] + dfs(i + questions[i][1] + 1)
            maxSum = Math.max(nextSum, brainSum)
            memo[i] = maxSum

            return maxSum
        }

        dfs(0)
        return maxSum
    }
}
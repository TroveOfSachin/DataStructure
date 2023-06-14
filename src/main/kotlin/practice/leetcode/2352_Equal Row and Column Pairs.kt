package practice.leetcode

import parse2DIntArray
import java.util.PriorityQueue
import kotlin.math.abs

/**
 * #### [2352. Equal Row and Column Pairs](https://leetcode.com/problems/equal-row-and-column-pairs/)
 */

fun main() {
    val input = "[[3,2,1],[1,7,6],[2,7,7]]".parse2DIntArray()
    println(Solution2352().equalPairs(input))

}

class Solution2352 {
    fun equalPairs(grid: Array<IntArray>): Int {
        val rowCount = grid.size
        val colCount = grid[0].size

        var count = 0

        // Pre-calculate the column arrays
        val columns = Array(colCount) { col ->
            IntArray(rowCount) { row ->
                grid[row][col]
            }
        }

        for (row in 0 until rowCount) {
            val rowElements = grid[row]

            for (col in 0 until colCount) {
                val colElements = columns[col]

                if (rowElements.contentEquals(colElements)) {
                    count++
                }
            }
        }

        return count

    }
}
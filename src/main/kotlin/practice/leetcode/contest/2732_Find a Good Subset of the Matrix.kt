package practice.leetcode.contest

import parse2DIntArray
import print


fun main() {
    val res = SolutionContest2732().goodSubsetofBinaryMatrix(arrayOf(intArrayOf(1,1,1), intArrayOf(1,1,1)))
    res.print("Output")
}

class SolutionContest2732 {
    fun goodSubsetofBinaryMatrix(grid: Array<IntArray>): List<Int> {
        val rows = grid.size
        val cols = grid[0].size
        val goodRows = mutableListOf<Int>()

        fun checkSubset(sums: IntArray, subsetSize: Int): Boolean {
            for (sum in sums) {
                if (sum > subsetSize / 2) return false
            }
            return true
        }

        fun findSubsets(row: Int, sums: IntArray, subsetSize: Int): Boolean {
            if (row == rows) {
                return subsetSize > 0 && checkSubset(sums, subsetSize)
            }

            if (findSubsets(row + 1, sums, subsetSize)) {
                return true
            }

            for (col in 0 until cols) {
                if (grid[row][col] == 1) {
                    sums[col]++
                }
            }

            if (findSubsets(row + 1, sums, subsetSize + 1)) {
                goodRows.add(row)
                return true
            }

            for (col in 0 until cols) {
                if (grid[row][col] == 1) {
                    sums[col]--
                }
            }

            return false
        }

        val sums = IntArray(cols)
        findSubsets(0, sums, 0)
        return goodRows.sorted()
    }
}
package practice.leetcode

import print

/**
 * #### [51. N-Queens] (https://leetcode.com/problems/n-queens/)
 * #### [52. N-Queens II](https://leetcode.com/problems/n-queens-ii/)
 */


fun main() {
    val output = NQueensII().solveNQueens(4)
    output.print("Output")
}

class NQueensII {
    fun solveNQueens(n: Int): ArrayList<ArrayList<String>> {

        val board = Array(n) { CharArray(n) { '.' } }
        val res: ArrayList<ArrayList<String>> = arrayListOf()
        val leftRow = IntArray(n)
        val upperDiagonal = IntArray(2 * n - 1)
        val lowerDiagonal = IntArray(2 * n - 1)

        solve(0, board, res, leftRow, upperDiagonal, lowerDiagonal)

        return res

    }

    private fun solve(
        col: Int,
        board: Array<CharArray>,
        res: ArrayList<ArrayList<String>>,
        leftRow: IntArray,
        upperDiagonal: IntArray,
        lowerDiagonal: IntArray
    ) {
        if (col == board.size) {
            res.add(createBoard(board))
            return
        }

        for (row in board.indices) {
            if (leftRow[row] == 0 && lowerDiagonal[row + col] == 0 && upperDiagonal[board.size - 1 + col - row] == 0) {
                board[row][col] = 'Q'
                leftRow[row] = 1
                lowerDiagonal[row + col] = 1
                upperDiagonal[board.size - 1 + col - row] = 1
                solve(col + 1, board, res, leftRow, upperDiagonal, lowerDiagonal)
                // backtracking
                board[row][col] = '.'
                leftRow[row] = 0
                lowerDiagonal[row + col] = 0
                upperDiagonal[board.size - 1 + col - row] = 0

            }
        }

    }

    private fun createBoard(board: Array<CharArray>): ArrayList<String> {
        val res = arrayListOf<String>()
        for (i in board.indices) {
            res.add(String(board[i]))
        }
        return res
    }
}
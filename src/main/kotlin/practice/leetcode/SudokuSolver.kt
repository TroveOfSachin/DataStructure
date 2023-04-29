package practice.leetcode

import print


fun main() {
    val data = arrayListOf(
        arrayListOf(8, 4, 9, 0, 0, 3, 5, 7, 0),
        arrayListOf(0, 1, 0, 0, 0, 0, 0, 0, 0),
        arrayListOf(7, 0, 0, 0, 9, 0, 0, 8, 3),
        arrayListOf(0, 0, 0, 9, 4, 6, 7, 0, 0),
        arrayListOf(0, 8, 0, 0, 5, 0, 0, 4, 0),
        arrayListOf(0, 0, 6, 8, 7, 2, 0, 0, 0),
        arrayListOf(5, 7, 0, 0, 1, 0, 0, 0, 4),
        arrayListOf(0, 0, 0, 0, 0, 0, 0, 1, 0),
        arrayListOf(0, 2, 1, 7, 0, 0, 8, 6, 5)
    )

    val output = SudokuSolver().solveSudokuPuzzle(data)
    output.print("Output")


}


class SudokuSolver {


    fun solveSudokuPuzzle(board: ArrayList<ArrayList<Int>>): ArrayList<ArrayList<Int>> {
        val bs = board.size
//        val boardSize = board.size

        fun solve(): Boolean {
            for (row in 0 until bs) {

                for (col in 0 until bs) {
                    if (board[row][col] == 0) {
                        for (i in (1..bs)) {
                            if (isValidPlacement(board, row, col, i)) {
                                board[row][col] = i
                                if (solve()) {
                                    return true
                                } else {
                                    board[row][col] = 0
                                }
                            }
                        }
                        return false
                    }


                }
            }
            return true
        }
        solve()
        return board
    }

    private fun isValidPlacement(board: ArrayList<ArrayList<Int>>, row: Int, col: Int, num: Int): Boolean {


        fun isItInRow(): Boolean {
            for (c in (0..8)) {
                if (num == board[row][c]) {
                    return true
                }
            }
            return false
        }

        fun isItInCol(): Boolean {
            for (r in (0..8)) {
                if (num == board[r][col])
                    return true
            }
            return false
        }

        fun isItInBox(): Boolean {
            val boxRowStart = row - (row % 3)
            val boxColStart = col - (col % 3)
            for (r in boxRowStart..boxRowStart + 2) {
                for (c in boxColStart..boxColStart + 2) {
                    if (board[r][c] == num) {
                        return true
                    }
                }
            }
            return false
        }


        return !isItInRow() && !isItInCol() && !isItInBox()
    }


}
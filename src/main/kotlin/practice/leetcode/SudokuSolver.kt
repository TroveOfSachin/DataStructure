package practice.leetcode

import print
import java.util.*
import kotlin.collections.ArrayList


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

    val d1 = arrayListOf(
        arrayListOf(5, 3, 0, 0, 7, 0, 0, 0, 0),
        arrayListOf(6, 0, 0, 1, 9, 5, 0, 0, 0),
        arrayListOf(0, 9, 8, 0, 0, 0, 0, 6, 0),
        arrayListOf(8, 0, 0, 0, 6, 0, 0, 0, 3),
        arrayListOf(4, 0, 0, 8, 0, 3, 0, 0, 1),
        arrayListOf(7, 0, 0, 0, 2, 0, 0, 0, 6),
        arrayListOf(0, 6, 0, 0, 0, 0, 2, 8, 0),
        arrayListOf(0, 0, 0, 4, 1, 9, 0, 0, 5),
        arrayListOf(0, 0, 0, 0, 8, 0, 0, 7, 9)
    )


    val output = SudokuSolver().solveSudokuPuzzle(d1)
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


    fun solveSudokuPuzzleLeetCode(board: Array<CharArray>) {

        board.map { it.map { c ->Character.getNumericValue(c) }}

        val bs = board.size
        fun solve(): Boolean {
            for (row in 0 until bs) {

                for (col in 0 until bs) {
                    if (board[row][col] == '.') {
                        for (i in (1..bs)) {
                            if (isValidPlacementLeetCode(board, row, col, i.toString().single())) {
                                board[row][col] = i.toString().single()
                                if (solve()) {
                                    return true
                                } else {
                                    board[row][col] = '.'
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

    }

    private fun isValidPlacementLeetCode(board: Array<CharArray>, row: Int, col: Int, num: Char): Boolean {


        fun isItInRow(): Boolean {
            for (c in (0..8)) {
                if (num.toString().single() == board[row][c]) {
                    return true
                }
            }
            return false
        }

        fun isItInCol(): Boolean {
            for (r in (0..8)) {
                if (num.toString().single() == board[r][col])
                    return true
            }
            return false
        }

        fun isItInBox(): Boolean {
            val boxRowStart = row - (row % 3)
            val boxColStart = col - (col % 3)
            for (r in boxRowStart..boxRowStart + 2) {
                for (c in boxColStart..boxColStart + 2) {
                    if (board[r][c] == num.toString().single()) {
                        return true
                    }
                }
            }
            return false
        }


        return !isItInRow() && !isItInCol() && !isItInBox()
    }


}

internal class LeetCodeSolution {

    val grids = Array(9) { IntArray(10) { 0 } }
    val rows = Array(9) { IntArray(10) { 0 } }
    val columns = Array(9) { IntArray(10) { 0 } }

    var isSolved = false

    fun solveSudoku(board: Array<CharArray>): Unit {


        val result = ArrayList<ArrayList<Int>>()

        for(b in board){
            val x = b.map { char ->
                char.toString().toInt()
            }
            result.add(ArrayList(x))

        }


        val o = solveSudokuPuzzle(result)
        for (i in board.indices) {
            for (j in board[i].indices) {
                board[i][j] = Character.getNumericValue(o[i][j]).toString().first()
            }
        }




        populateBoard(board)

        backTrack(board, 0, 0)
    }

    fun solveSudokuPuzzle(board: ArrayList<ArrayList<Int>>): ArrayList<ArrayList<Int>> {
        return arrayListOf()
    }

    private fun populateBoard(board: Array<CharArray>) {
        // fill in grids, rows, columns using the board
        for (rowIndex in 0..8) {
            for (columnIndex in 0..8) {
                if (board[rowIndex][columnIndex] != '.') {
                    place(Character.getNumericValue(board[rowIndex][columnIndex]), board, rowIndex, columnIndex)
                }
            }
        }
    }

    private fun backTrackNext(board: Array<CharArray>, currRow: Int, currColumn: Int) {
        if (currRow == board.size - 1 && currColumn == board[0].size - 1) {
            isSolved = true
        } else {
            if (currColumn < board[0].size - 1) {
                backTrack(board, currRow, currColumn + 1)
            } else {
                backTrack(board, currRow + 1, 0)
            }
        }
    }

    private fun backTrack(board: Array<CharArray>, currRow: Int, currColumn: Int) {
        if (board[currRow][currColumn] == '.') {

            for (number in 1..9) {
                if (place(number, board, currRow, currColumn)) {

                    backTrackNext(board, currRow, currColumn)

                    if (isSolved) {
                        return
                    }

                    grids[getGrid(currRow, currColumn)][number] = 0
                    rows[currRow][number] = 0
                    columns[currColumn][number] = 0

                    board[currRow][currColumn] = '.'
                }
            }
        } else {
            backTrackNext(board, currRow, currColumn)
        }
    }

    private fun place(number: Int, board: Array<CharArray>, currRow: Int, currColumn: Int): Boolean {
        val canPlaceGrid = grids[getGrid(currRow, currColumn)][number] == 0
        val canPlaceRow = rows[currRow][number] == 0
        val canPlaceColumn = columns[currColumn][number] == 0

        val canPlace = canPlaceGrid && canPlaceRow && canPlaceColumn

        if (canPlace) {
            grids[getGrid(currRow, currColumn)][number] = 1
            rows[currRow][number] = 1
            columns[currColumn][number] = 1

            board[currRow][currColumn] = Character.forDigit(number, 10)

            return true
        } else {
            return false
        }
    }

    private fun getGrid(currRow: Int, currColumn: Int): Int {
        return ((3 * (currRow / 3)) + (currColumn / 3))
    }
}




internal class Solution {
    private lateinit var p: IntArray
    fun distanceLimitedPathsExist(n: Int, edgeList: Array<IntArray>, queries: Array<IntArray>): BooleanArray {
        p = IntArray(n)
        for (i in 0 until n) {
            p[i] = i
        }
        Arrays.sort(edgeList) { a: IntArray, b: IntArray -> a[2] - b[2] }
        val m = queries.size
        val ans = BooleanArray(m)
        val qid = arrayOfNulls<Int>(m)
        for (i in 0 until m) {
            qid[i] = i
        }
        Arrays.sort(qid) { i: Int?, j: Int? -> queries[i!!][2] - queries[j!!][2] }
        var j = 0
        for (i in qid) {
            val a = queries[i!!][0]
            val b = queries[i][1]
            val limit = queries[i][2]
            while (j < edgeList.size && edgeList[j][2] < limit) {
                val u = edgeList[j][0]
                val v = edgeList[j][1]
                p[find(u)] = find(v)
                ++j
            }
            ans[i] = find(a) == find(b)
        }
        return ans
    }

    private fun find(x: Int): Int {
        if (p[x] != x) {
            p[x] = find(p[x])
        }
        return p[x]
    }
}
package practice.leetcode


/**
 * ### [36. Valid Sudoku](https://leetcode.com/problems/valid-sudoku/)
 */
class ValidSudoku {

    fun isValidSudoku_Approach_1(board: Array<CharArray>): Boolean {

        val rows = IntArray(9)
        val cols = IntArray(9)
        val blocks = IntArray(9)
        for (i in 0..8) {
            for (j in 0..8) {
                if (board[i][j] == '.') {
                    continue
                }

                val num = board[i][j] - '0'
                val pos = 1 shl (num - 1)

                //rows check
                if (rows[i] and pos != 0) {
                    return false
                }
                rows[i] = rows[i] or pos

                if (cols[j] and pos != 0) {
                    return false
                }
                cols[j] = cols[j] or pos

                val blockNum = (i / 3) * 3 + j / 3
                if (blocks[blockNum] and pos != 0) {
                    return false
                }

                blocks[blockNum] = blocks[blockNum] or pos
            }
        }

        return true
    }

    fun isValidSudoku_Approach_2(board: Array<CharArray>): Boolean {

        val seen = mutableSetOf<String>()
        for (i in 0..8) {
            for (j in 0..8) {
                val cell = board[i][j]
                if (cell == '.')
                    continue

                // IR = IN ROW
                // IC = IN COLUMN
                // IS = IN SQUARE

                if (!seen.add("$cell IR $i") ||
                    !seen.add("$cell IC $j") ||
                    !seen.add("$cell IS ${i / 3}-${j / 3}")
                ) return false
            }
        }
        return true
    }


    fun isValidSudoku(board: Array<CharArray>): Boolean {

        val rows = Array(9) { BooleanArray(9) }
        val cols = Array(9) { BooleanArray(9) }
        val boxes = Array(9) { BooleanArray(9) }
        for (i in 0 until 9) {
            for (j in 0 until 9) {
                val tem = board[i][j]
                if (tem != '.') {
                    // compare
                    val num = tem - '1'
                    val boxIndex = (i / 3) * 3 + j / 3
                    if (rows[i][num] || cols[num][j] || boxes[boxIndex][num]) {
                        return false
                    }
                    rows[i][num] = true
                    cols[num][j] = true
                    boxes[boxIndex][num] = true

                }
            }
        }
        return true
    }

}
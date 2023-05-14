package practice.leetcode

/**
 * [2661. First Completely Painted Row or Column](https://leetcode.com/problems/first-completely-painted-row-or-column/)
 */

fun main() {
    val arr = intArrayOf(2, 8, 7, 4, 1, 3, 5, 6, 9)
    val mat = arrayOf(intArrayOf(3, 2, 5), intArrayOf(1, 4, 6), intArrayOf(8, 7, 9))


        val output = FirstCompletedRowOrColumn().firstCompleteIndex(arr, mat)
        println("Output = $output")



}






class FirstCompletedRowOrColumn {


    fun firstCompleteIndex(arr: IntArray, mat: Array<IntArray>): Int {
        val filledRow = IntArray(mat.size) { 0 }
        val filledCol = IntArray(mat[0].size) { 0 }

        for (i in arr.indices) {
            if (paint(arr[i], mat, filledRow, filledCol)) {
                return i
            }
        }
        return -1
    }

    private fun paint(value: Int, mat: Array<IntArray>, filledRow: IntArray, filledCol: IntArray): Boolean {

        for (row in mat.indices) {
            for (col in mat[0].indices) {
                if (mat[row][col] == value) {
                    mat[row][col] = -mat[row][col]
                    filledRow[row]++
                    filledCol[col]++

                    if (filledRow[row] == mat[0].size || filledCol[col] == mat.size)
                        return true
                }
            }
        }
        return false
    }

}
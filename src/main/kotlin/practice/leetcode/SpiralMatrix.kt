package practice.leetcode

import print

/**
 * ### [54. Spiral Matrix](https://leetcode.com/problems/spiral-matrix/)
 * ### [59. Spiral Matrix II](https://leetcode.com/problems/spiral-matrix-ii/)
 */

fun main() {
    val arr = arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(4, 5, 6),
        intArrayOf(7, 8, 9)
    )

//    (SpiralMatrix().spiralOrder2(arr)).print("Output")
    (SpiralMatrix().generateSM(3)).print("Output")
}

class SpiralMatrix {


    fun spiralOrder(m: Array<IntArray>): List<Int> {
        val res: MutableList<Int> = mutableListOf()
        if (m.isEmpty()) return res

        var l = 0
        var r = m[0].size - 1
        var t = 0
        var b = m.size - 1

        while (l <= r && t <= b) {
            for (i in l..r) res.add(m[t][i])
            t++
            for (i in t..b) res.add(m[i][r])
            r--
            if (t <= b) {
                for (i in r downTo l) res.add(m[b][i])
                b--
            }
            if (l <= r) {
                for (i in b downTo t) res.add(m[i][l])
                l++
            }
        }
        return res
    }


    fun spiralOrder2(m: Array<IntArray>): List<Int> {
        val res: MutableList<Int> = MutableList(m.size * m[0].size) { 0 }
        if (m.isEmpty()) return res

        var left = 0
        var right = m[0].size - 1

        var leftBottom = m.size - 1
        var rightBottom = m[0].size - 1

        while (left <= right) {
            var bottomPos = right + leftBottom


            // horizontal iteration
            var tempBR = rightBottom

            for (i in left..right) {
                res[i] = m[left][i]
                res[bottomPos++] = m[leftBottom][tempBR--]
            }


            // vertical iteration
            var vRPos = right + leftBottom - 1
            var vLPos = right
            var tempBL = leftBottom
            for (i in left + 1 until rightBottom) {
                res[vRPos++] = m[i][rightBottom]
                res[vLPos--] = m[--tempBL][left]

            }
            left++
            right--
            leftBottom--
            rightBottom--
        }
        return res
    }


    fun generateSpiralMatrix(n: Int): Array<IntArray> {
        val matrix = Array(n) { IntArray(n) }
        var i = 1
        var row = 0
        var col = 0
        var deltaRow = 0
        var deltaCol = 1
        for (j in 0 until n * n) {
            matrix[row][col] = i++
            if (matrix[(row + deltaRow + n) % n][(col + deltaCol + n) % n] != 0) {
                val temp = deltaRow
                deltaRow = deltaCol
                deltaCol = -temp
            }
            row += deltaRow
            col += deltaCol
        }
        return matrix
    }

    fun generateSM(n: Int): Array<IntArray> {
        val matrix = Array(n) { IntArray(n) }
        var num = 1
        var x = 0
        var y = 0
        var direction = 0
        while (num <= n * n) {
            matrix[x][y] = num
            num++
            when (direction) {
                0 -> {
                    if (y == n - 1 || matrix[x][y + 1] != 0) {
                        direction = 1
                        x++
                    } else {
                        y++
                    }
                }
                1 -> {
                    if (x == n - 1 || matrix[x + 1][y] != 0) {
                        direction = 2
                        y--
                    } else {
                        x++
                    }
                }
                2 -> {
                    if (y == 0 || matrix[x][y - 1] != 0) {
                        direction = 3
                        x--
                    } else {
                        y--
                    }
                }
                3 -> {
                    if (x == 0 || matrix[x - 1][y] != 0) {
                        direction = 0
                        y++
                    } else {
                        x--
                    }
                }
            }
        }
        return matrix
    }

}
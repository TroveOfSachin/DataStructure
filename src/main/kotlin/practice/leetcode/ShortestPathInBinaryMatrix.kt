package practice.leetcode

import parse2DIntArray
import java.util.*


/**
 * #### [1091. Shortest Path in Binary Matrix](https://leetcode.com/problems/shortest-path-in-binary-matrix/)
 */

fun main() {

    val input = "[[0,0,0],[1,1,0],[1,1,0]]".parse2DIntArray()
    println(input.contentDeepToString())
    val output = ShortestPathInBinaryMatrix().shortestPathBinaryMatrix(input)
    println(output)
}


class ShortestPathInBinaryMatrix {

    fun shortestPathBinaryMatrix(grid: Array<IntArray>): Int {
        val n = grid.size-1;
        if (grid[0][0] == 1 || grid[n][n] == 1) return -1;
        if (n == 0) return 1;

        val cellRange = 0 .. n
        val queue = ArrayDeque<Triple<Int, Int, Int>>();
        queue.push(Triple(0, 0, 1));
        while (queue.isNotEmpty()) {
            val (cr, cc, cnt) = queue.pop();
            for (x in cr - 1..cr + 1) {
                for (y in cc - 1..cc + 1) {
                    if (x in cellRange && y in cellRange && grid[x][y] == 0) {
                        grid[x][y] = cnt + 1;
                        if (x == n && y == n) {
                            return cnt + 1;
                        } else {
                            queue.push(Triple(x, y, cnt + 1));
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        return -1;
    }

}
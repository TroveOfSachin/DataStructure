package practice.leetcode


import init
import java.util.*
import kotlin.time.ExperimentalTime
import kotlin.time.measureTime

/**
 * #### [934. Shortest Bridge](https://leetcode.com/problems/shortest-bridge/)
 */

@OptIn(ExperimentalTime::class)
fun main() {

//    val input = "[[0, 1], [1, 0], [0, -1], [0, 1]]"
//    val directions = (Array(4) { IntArray(2) }).init(input)
//
//    println(directions.contentDeepToString())


    val grid: Array<IntArray> = arrayOf(
        intArrayOf(0, 1, 0),
        intArrayOf(0, 0, 0),
        intArrayOf(0, 0, 1)
    )


    val sol2 = measureTime {
        val output = ShortestBridge().shortestBridge_Optimized(grid)
        println(output)
    }

    val sol1 = measureTime {
        val output = ShortestBridge().shortestBridge(grid)
        println(output)
    }



    println("Sol 1 : $sol1")
    println("Sol 2 : $sol2")


}

class ShortestBridge {


    fun shortestBridge(grid: Array<IntArray>): Int {
        val len = grid.size

        val direct = arrayOf(intArrayOf(0, 1), intArrayOf(0, -1), intArrayOf(1, 0), intArrayOf(-1, 0))
        val visit = mutableSetOf<Pair<Int, Int>>()

        fun isValid(row: Int, col: Int) = row < 0 || col < 0 || row == len || col == len

        fun dfs(row: Int, col: Int) {
            val cell = Pair(row, col)
            if (isValid(row, col) || grid[row][col] == 0 || visit.contains(cell))
                return
            visit.add(cell)
            for ((directRow, directCol) in direct) {
                dfs(row + directRow, col + directCol)
            }
        }


        fun bfs(): Int {
            var res = 0
            val queue = ArrayDeque(visit)
            while (queue.isNotEmpty()) {
                for (i in 0 until queue.size) {
                    val (row, col) = queue.pop()
                    for ((directRow, directCol) in direct) {
                        val curRow = row + directRow
                        val curCol = col + directCol
                        if (isValid(curRow, curCol) || visit.contains(Pair(curRow, curCol))) {
                            continue
                        }
                        if (grid[curRow][curCol] == 1) {
                            return res
                        }

                        val cell = Pair(curRow, curCol)
                        queue.add(cell)
                        visit.add(cell)
                    }
                }
                res += 1
            }
            return res

        }

        for (row in 0 until len) {
            for (col in 0 until len) {
                if (grid[row][col] == 1) {
                    dfs(row, col)
                    return bfs()
                }
            }
        }
        return 0
    }

    /**
     * Optimized Solution
     */

    fun markIsland(grid: Array<IntArray>, q: Queue<IntArray>, i: Int, j: Int, dirs: Array<Array<Int>>) {
        if (i < 0 || j < 0 || i == grid.size || j == grid[0].size) return
        if (grid[i][j] == 1) {
            grid[i][j] = 2
            for (d in dirs) markIsland(grid, q, i + d[0], j + d[1], dirs)
        } else if (grid[i][j] == 0) {
            grid[i][j] = 2
            q.add(intArrayOf(i, j))
        }
    }

    fun shortestBridge_Optimized(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size
        val edges: Queue<IntArray> = LinkedList()
        val directions = arrayOf(arrayOf(1, 0), arrayOf(-1, 0), arrayOf(0, 1), arrayOf(0, -1))
        var islandFound = false
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (!islandFound && grid[i][j] == 1) {
                    islandFound = true
                    markIsland(grid, edges, i, j, directions)
                }
            }
        }
        var ret = 0
        //val visited = Array(m){BooleanArray(n)}
        while (edges.size > 0) {
            var size = edges.size
            while (size-- > 0) {
                val cur = edges.poll()
                if (grid[cur[0]][cur[1]] == 1) return ret
                for (d in directions) {
                    val nr = cur[0] + d[0]
                    val nc = cur[1] + d[1]
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] != 2) {
                        if (grid[nr][nc] == 1) return ret + 1
                        grid[nr][nc] = 2
                        edges.add(intArrayOf(nr, nc))
                    }
                }
            }
            ret++
        }
        return ret
    }


}

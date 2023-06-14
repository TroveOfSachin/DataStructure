package practice.leetcode

import kotlin.math.pow
import kotlin.math.sqrt


fun main() {

}

class DetonateTheMaximumBombs {
    fun maximumDetonation(bombs: Array<IntArray>): Int {
        fun inRange(a: IntArray, b: IntArray): Boolean {
            val dx = (a[0] - b[0]).toDouble().pow(2)
            val dy = (a[1] - b[1]).toDouble().pow(2)
            val r = a[2].toDouble().pow(2)
            return sqrt(dx + dy) <= r
        }

        fun dfs(idx: Int, v: BooleanArray, bombs: Array<IntArray>): Int {
            var count = 0
            v[idx] = true
            for (i in bombs.indices) {
                if (!v[i] && inRange(bombs[idx], bombs[i])) {
                    count += dfs(i, v, bombs)
                }
            }
            return 1 + count
        }

        var res = 0
        for (i in bombs.indices) {
            res = maxOf(res, dfs(i, BooleanArray(bombs.size), bombs))
        }
        return res
    }
}





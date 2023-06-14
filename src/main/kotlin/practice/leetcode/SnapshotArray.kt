package practice.leetcode

import java.util.*

/**
 * #### (1146. Snapshot Array)[https://leetcode.com/problems/snapshot-array/]
 */

fun main() {
    val s = SnapshotArray(10)
    s.set(0, 4)
    s.snap()
    s.snap()
    s.set(0, 5)
    s.set(2, 6)
    s.set(0, 7)
    println("(0,2)${s.get(0,2)}")
    println("(1,2)${s.get(1,2)}")
    println("(2,2)${s.get(2,2)}")

}


class SnapshotArray(length: Int) {
    private val arr: Array<MutableList<IntArray>>
    private var idx = 0

    init {
        arr = Array(length) { mutableListOf() }

        String(("  ".toCharArray()))

    }



    fun set(index: Int, `val`: Int) {
        arr[index].add(intArrayOf(idx, `val`))
        println("SET DONE")
    }

    fun snap(): Int {
        return idx++
    }

    fun get(index: Int, snap_id: Int): Int {
        val vals: List<IntArray> = arr[index]
        var left = 0
        var right = vals.size
        while (left < right) {
            val mid = left + right shr 1
            if (vals[mid][0] > snap_id) {
                right = mid
            } else {
                left = mid + 1
            }
        }
        return if (left == 0) 0 else vals[left - 1][1]
    }
}


/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */
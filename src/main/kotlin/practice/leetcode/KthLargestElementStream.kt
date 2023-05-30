package practice.leetcode

import print
import java.util.PriorityQueue

/**
 *  #### [703. Kth Largest Element in a Stream] (https://leetcode.com/problems/kth-largest-element-in-a-stream)
 */

fun main() {
    val obj = KthLargestElementStream(2, intArrayOf(0))
    val output = arrayListOf<Int>()
    output.add(obj.add(-1))
    output.add(obj.add(1))
    output.add(obj.add(-2))
    output.add(obj.add(-4))
    output.add(obj.add(3))
    output.print("Output")
}


class KthLargestElementStream(var k: Int, nums: IntArray) {

    val heap = PriorityQueue<Int>()

    init {
        for (n in nums) {
            heap.add(n)
            if (heap.size > k) heap.poll()
        }
    }


    fun add(`val`: Int): Int {

        if (heap.size < k || heap.peek() < `val`)
            heap.add(`val`)

        if (heap.size > k) heap.poll()
        return heap.peek()
    }
}
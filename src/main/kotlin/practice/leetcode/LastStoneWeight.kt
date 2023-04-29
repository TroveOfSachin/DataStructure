package practice.leetcode

import java.util.PriorityQueue


/**
 * [1046. Last Stone Weight](https://leetcode.com/problems/last-stone-weight/)
 */

fun main() {
    val input = intArrayOf(2, 2)

    val output = LastStoneWeight().lastStoneWeight(input)

    println("Output : $output")
}


class LastStoneWeight {

    fun lastStoneWeight(stones: IntArray): Int {

        val heap = PriorityQueue<Int> { a, b -> b.compareTo(a) }
        stones.map { heap.add(it) }
        while (heap.size > 1) {
            val x = heap.poll()
            val y = heap.poll()
            if (x != y) {
                heap.add(x - y)
            }
        }

        return heap.poll()?:0


    }
}
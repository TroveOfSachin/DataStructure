package practice.leetcode

import java.util.*
import kotlin.collections.ArrayDeque

/**
 * #### [853. Car Fleet](https://leetcode.com/problems/car-fleet/)
 */

fun main() {
    val position = intArrayOf(10, 8, 0, 5, 3)
    val speed = intArrayOf(2, 4, 1, 1, 3)
    val target = 12

    val output = CarFleet().carFleet(target, position, speed)
    println(output)
}

class CarFleet {
    fun carFleet(target: Int, position: IntArray, speed: IntArray): Int {
        val sortedPair = position.zip(speed).sortedByDescending { it.first }
        val stack = Stack<Float>()

        for ((pos, spd) in sortedPair) {
            val time = (target - pos) / spd.toFloat()
            if (stack.isNotEmpty() && time <= stack.peek()) {
                continue
            }
            stack.push(time)
        }

        return stack.size
    }
}
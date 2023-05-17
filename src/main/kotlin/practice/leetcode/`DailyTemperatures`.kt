package practice.leetcode

import print
import java.util.Stack

/**
 * #### [0739_Daily Temperatures](https://leetcode.com/problems/daily-temperatures/)
 */

fun main() {
    val input = intArrayOf(73, 74, 75, 71, 69, 72, 76, 73)
    DailyTemperatures().dailyTemperatures(input).print("Output")
}

class DailyTemperatures {
    fun dailyTemperatures(temperatures: IntArray): IntArray {

        val res = IntArray(temperatures.size)

        // Pair if of temperature and day index
        val stack = Stack<Pair<Int, Int>>()

        temperatures.forEachIndexed { index, t ->
            while (stack.isNotEmpty() && stack.peek().first < t) {
                val (pTemp, pIndex) = stack.pop()
                res[pIndex] = index - pIndex

            }
            stack.push(Pair(t, index))
        }

        return res

    }


    fun dailyTemperatures_Approach_2(temperatures: IntArray): IntArray {
        val stack = Stack<Int>()
        val dayWaitList = IntArray(temperatures.size)

        for (i in temperatures.size - 1 downTo 0) {
            while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop()
            }
            dayWaitList[i] = if (stack.isEmpty()) 0 else stack.peek() - i
            stack.push(i)
        }

        return dayWaitList
    }
}
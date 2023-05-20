package practice.leetcode

import java.util.*

/**
 * #### [84. Largest Rectangle in Histogram](https://leetcode.com/problems/largest-rectangle-in-histogram/)
 */
class LargestRectangleInHistogram {
    fun largestRectangleArea(heights: IntArray): Int {

        var maxArea = 0
        // Pair of first = Index, second = height
        val stack = Stack<Pair<Int, Int>>()
        heights.forEachIndexed { idx, h ->
            var start = idx
            while (stack.isNotEmpty() && stack.peek().second > h) {
                var (sIdx, sH) = stack.pop()
                maxArea = maxOf(maxArea, sH * (idx - sIdx))
                start = sIdx
            }
            stack.push(Pair(start, h))
        }

        // iterating over remaining element in stack
        // computing area with all previous smaller heights
        for ((idx, h) in stack) {
            maxArea = maxOf(maxArea, h * (heights.size - idx))
        }

        return maxArea
    }
}
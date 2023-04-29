package practice.leetcode

import java.lang.Integer.max
import java.lang.Integer.min
import java.util.PriorityQueue

/**
 * ##[11. Container With Most Water](https://leetcode.com/problems/container-with-most-water/)
 */


class ContainerWithMostWater {

    fun maxArea(h: IntArray): Int {

        var n = h.size

        if (n == 2) return min(h[0], h[1])

        var start = 0
        var last = n - 1

        var maxArea = 0

        "".toInt()

        while (start < last) {

            maxArea = max(maxArea, min(h[start], h[last]) * (last - start))

            if (h[start] >= h[last])
                last--
            else
                start++
        }

        println(maxArea)

        return maxArea
    }
}
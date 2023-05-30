package practice.leetcode

import java.util.PriorityQueue


fun main() {
    val nums1 = intArrayOf(1, 3, 3, 2)
    val nums2 = intArrayOf(2, 1, 3, 4)
    val res = MaximumSubsequenceScore().maxScore(nums1, nums2, 3)
    println(res)
}


class MaximumSubsequenceScore {
    fun maxScore(nums1: IntArray, nums2: IntArray, k: Int): Long {

        val pairs = nums1.zip(nums2)
            .sortedByDescending { it.second }

        val pq = PriorityQueue<Int>()
        var maxScore: Long = 0
        var sum: Long = 0
        for (pair in pairs) {
            pq.add(pair.first)
            sum += pair.first
            if (pq.size > k) {
               pq.peek()
                sum -= pq.poll()
            }
            if (pq.size == k) {
                maxScore = maxOf(maxScore, sum * pair.second)
            }
        }

        return maxScore
    }
}
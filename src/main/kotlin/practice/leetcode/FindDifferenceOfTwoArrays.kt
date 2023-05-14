package practice.leetcode

import java.util.PriorityQueue


fun main() {
    val n1 = intArrayOf(1, 2, 3, 3)
    val n2 = intArrayOf(1, 1, 2, 2)
    FindDifferenceOfTwoArrays().findDifference(n1, n2)

}

class FindDifferenceOfTwoArrays {


    fun removeDuplicates(nums: IntArray): Int {
        val s = nums.toSet()
        s.forEachIndexed { index, i ->
            nums[index] = i
        }

        return s.size
    }


    fun findDifference(nums1: IntArray, nums2: IntArray): List<List<Int>> {

        val s1 = nums1.toMutableSet()
        val s2 = nums2.toMutableSet()
        val n1 = arrayListOf<Int>()

        s1.forEach {
            if (!s2.contains(it))
                n1.add(it)
            else {
                s2.remove(it)
            }
        }

        s1 - s2



        return listOf(n1, s1.toList())


    }
}
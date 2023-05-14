package practice.leetcode


/**
 * [2659. Make Array Empty](https://leetcode.com/problems/make-array-empty/)
 */

fun main() {
    val input = intArrayOf(3,4,-1)
//    val input = intArrayOf(1,2,4,3)
//    val input = intArrayOf(1,2,3)


    val output = MakeArrayEmpty().countOperationsToEmptyArray(input)
    println("Total Steps : $output")
}

class MakeArrayEmpty {

    fun countOperationsToEmptyArray(nums: IntArray): Long {
        val indexMap = mutableMapOf<Int, Int>()

        for(i in 0 until nums.size)
            indexMap[nums[i]] = i

        nums.sort()
        var ops = (nums.size).toLong()
        var lastIdx = 0
        for(i in 0 until nums.size){
            if(indexMap[nums[i]]!! < lastIdx)
                ops += (nums.size - i)
            lastIdx = indexMap[nums[i]]!!
        }

        return ops

    }
}
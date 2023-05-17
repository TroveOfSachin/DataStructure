package practice.leetcode

/**
 * ### [238. Product of Array Except Self](https://leetcode.com/problems/product-of-array-except-self/)
 */
class ProductOfArrayExceptSelf {
    fun productExceptSelf(nums: IntArray): IntArray {

        val res = IntArray(nums.size){1}

        var prefix = 1
        for( i in nums.indices){
            res[i] = prefix
            prefix *= res[i]
        }

        var postfix = 1
        for(i in nums.size-1 downTo 0){
            res[i] *= postfix
            postfix *= nums[i]
        }

        return res
    }
}
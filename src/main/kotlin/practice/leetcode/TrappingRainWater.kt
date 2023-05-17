package practice.leetcode

/**
 * ###[42. Trapping Rain Water](https://leetcode.com/problems/trapping-rain-water/)
 */


fun main() {
    val input = intArrayOf(0,1,0,2,1,0,1,3,2,1,2,1)
    val output = TrappingRainWater().trap_Approach_1(input)
    println(output)
}
class TrappingRainWater {

    /**
     * #### Approach 1: With maintaining max block level to left and max block level to right
     *
     * Time Complexity O(n)
     * Space Complexity O(n)
     *
     */
    fun trap_Approach_1(height: IntArray): Int {


        val maxLeft = IntArray(height.size)
        val maxRight = IntArray(height.size)
        val minLeftRight = IntArray(height.size)

        // finding maxLeft
        var temp = 0
        for(i in 1 until height.size){
            temp = maxOf(temp, height[i-1])
            maxLeft[i] = temp
        }
        // finding maxRight
        temp = 0
        for(i in height.size-2 downTo 0){
            temp = maxOf(temp, height[i+1])
            maxRight[i] = temp
        }

        // finding min Of Left & right
        for(i in height.indices){
            minLeftRight[i] = minOf(maxLeft[i], maxRight[i])
        }

        var waterBlock = 0

        // calculating water block count
        // if difference is negative then consider its 0 (zero)

        for(i in height.indices){
            val s = minLeftRight[i] - height[i]
            waterBlock += when{
                (s<0) -> 0
                else -> s
            }
        }

        return waterBlock
    }

    /**
     * #### Approach 2 (Optimized): using two pointer
     * Time Complexity: O(n)
     * Space Complexity: O1)
     */

    fun trap_Approach_2_Optimized(height: IntArray): Int {
        var left = 0
        var right = height.size-1

        var leftMax = height[left]
        var rightMax=  height[right]

        var res = 0

        while (left<right){
            if(leftMax < rightMax) {
                left++
                leftMax = maxOf(leftMax, height[left])
                res += leftMax - height[left]
            }else{
                right--
                rightMax = maxOf(rightMax, height[right])
                res += rightMax - height[right]
            }
        }

        return res

    }
}
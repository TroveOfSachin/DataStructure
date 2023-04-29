package practice.leetcode


/**
 * [2023. Number of Pairs of Strings With Concatenation Equal to Target](https://leetcode.com/problems/number-of-pairs-of-strings-with-concatenation-equal-to-target/)
 */
fun main() {
    val input = arrayOf("777","7","77","77")
    val output = NumberOfPairOfConcatenatedString().numOfPairs(input, "7777")
    println("Output: $output")
}

class NumberOfPairOfConcatenatedString {

    fun numOfPairs(nums: Array<String>, target: String): Int {
        val countMap = mutableMapOf<String, Int>()
        var count = 0

        for (num in nums) {
            if (target.startsWith(num)) {
                val complement = target.substring(num.length)
                count += countMap.getOrDefault(complement, 0)
            }
            if (target.endsWith(num)) {
                val complement = target.substring(0, target.length - num.length)
                count += countMap.getOrDefault(complement, 0)
            }
            countMap[num] = countMap.getOrDefault(num, 0) + 1
        }

        return count
    }
}
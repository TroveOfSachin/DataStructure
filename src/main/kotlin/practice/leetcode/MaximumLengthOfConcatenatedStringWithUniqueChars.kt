package practice.leetcode

/**
 * [1239. Maximum Length of a Concatenated String with Unique Characters](https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/description/)
 */
fun main() {

    val output = MaximumLengthOfConcatenatedStringWithUniqueChars().maxLength(listOf("cha", "r", "act", "ers"))
    println("Max Len: $output")

}

class MaximumLengthOfConcatenatedStringWithUniqueChars {

    fun maxLength(arr: List<String>): Int {

        var maxLength = 0
        val bitmasks = mutableListOf<Int>()

        // Convert each string into a bitmask where each bit represents a unique character
        for (s in arr) {
            var bitmask = 0
            for (c in s) {
                val shift = c - 'a'
                if (bitmask and (1 shl shift) != 0) {
                    bitmask = 0 // Current string has repeating characters, set bitmask to 0
                    break
                }
                bitmask = bitmask or (1 shl shift)
            }
            if (bitmask != 0) bitmasks.add(bitmask)
        }

        fun findMaxLength(currentString: Int, currentIndex: Int) {
            maxLength = maxOf(maxLength, Integer.bitCount(currentString))

            // If the current maximum length is already greater than or equal to the length of the concatenation
            // of the remaining strings, then there is no need to consider further concatenations
            for (i in currentIndex until bitmasks.size) {
                val nextStringBitmask = bitmasks[i]
                if (nextStringBitmask and currentString == 0) {
                    val nextString = currentString or nextStringBitmask
                    findMaxLength(nextString, i + 1)
                }
            }
        }

        findMaxLength(0, 0)
        return maxLength
    }
}
package practice.leetcode

/**
 * [443. String Compression](https://leetcode.com/problems/string-compression/)
 */


fun main() {

    //@formatter:off
    val input = charArrayOf('a','a','b','b','b','b','b','b','b','b','b','b','b','b','c','c','c','c','c','c','c','c','c','c','c','c','c','d','d','d','d','d','d')
    //@formatter:on

    val output = StringCompression().compress(input)
    println(input.copyOfRange(0, output).joinToString())
}


class StringCompression {
    fun compress(chars: CharArray): Int {

        var charIndex = 1
        var charCount = 0
        var currentChar = chars[0]

        for (char in chars) {
            if (char == currentChar) {
                charCount++
            } else {
                if (charCount > 1) {
                    (charCount).toString().toCharArray().forEach {
                        chars[charIndex++] = it
                    }
                }
                currentChar = char
                chars[charIndex++] = char
                charCount = 1
            }
        }

        if (charCount > 1) {
            (charCount + 1).toString().toCharArray().forEach {
                chars[charIndex++] = it
            }
        }





        return charIndex
    }

}
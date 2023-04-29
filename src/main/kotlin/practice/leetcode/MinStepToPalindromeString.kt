package practice.leetcode

/**
 * #### [1312. Minimum Insertion Steps to Make a String Palindrome](https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/)
 */

fun main() {

    var pal = mutableListOf<Char>()
    pal.addAll("Hello".toList())

    val output = MinStepToPalindromeString().minInsertions("racecar")
    println("Min Steps : $output")
}

class MinStepToPalindromeString {
    fun minInsertions(s: String): Int {

        fun helper(start: Int, end: Int): Int {
            if (start >= end) return 0

            return if (s[start] == s[end])
                helper(start + 1, end - 1)
            else{
                val st1 = helper(start+1, end)
                val st2 = helper(start, end-1)
                Math.min(st1, st2)
            }

        }
        return helper(0, s.length-1)

    }
}
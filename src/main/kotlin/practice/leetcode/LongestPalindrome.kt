package practice.leetcode

/**
 * ## 5. Longest Palindromic Substring
 * Difficulty: Medium
 * Given a string s, return the longest palindromic substring in s.
 *
 * ### Example 1:
 *````
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 * ````
 * ### Example 2:
 * ````
 * Input: s = "cbbd"
 * Output: "bb"
 * ````
 *
 * ### Constraints:
 *
 * - 1 <= s.length <= 1000
 * - s consist of only digits and English letters.
 *
 */


class LongestPalindrome {
    fun longestPalindrome(s: String): String {


        if (s.length == 1) return s
        var largestPalString = "${s[0]}"

        var start = 0
        while (start < s.length - 1) {
            var counter = start + 1
            while (counter < s.length) {

                val len = counter - start + 1


                if (s[start] == s[counter] && len > largestPalString.length) {

                    var result = checkPalindrome(s, start, counter)
                    if (result && largestPalString.length < len) {
                        largestPalString = s.substring(start, counter + 1)
                        if (largestPalString.length > s.substring(start, s.length).length) {
                            start = s.length
                            counter = s.length
                        }
                    }

                }
                counter++

            }
            start++
        }
        return largestPalString
    }

    private fun checkPalindrome(s: CharSequence, _start: Int, _end: Int): Boolean {
        var start = _start
        var end = _end
        var isPalindrome = true

        while (start <= end && isPalindrome) {
            if (s[start++] != s[end--]) {
                isPalindrome = false
            }
        }
        return isPalindrome
    }
}
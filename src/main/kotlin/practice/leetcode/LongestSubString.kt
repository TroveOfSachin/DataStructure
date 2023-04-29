package practice.leetcode


/**
 * ## 3. Longest Substring Without Repeating Characters
 *
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 * ### Example 1
 * ````
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * ````
 * ### Example 2:
 * ````
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * ````
 * ### Example 3:
 * ````
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * ````
 *
 * ### Constraints:
 *
 * - 0 <= s.length <= 5 * 104
 * - s consists of English letters, digits, symbols and spaces.
 *
 */


fun main() {

    val s = "dvdf"


    var result = LongestSubString().lengthOfLongestSubstring(s)
    println(result)


}

class LongestSubString {


    /**
     * Best Solution
     */
    fun lengthOfLongestSubstring(s: String): Int {
        val check = BooleanArray(128)
        var max = 0
        var len = 0

        for (r in s.indices) {
            val rS = s[r]
            while (check[rS.code]) check[s[len++].code] = false
            check[rS.code] = true
            max = maxOf(max, r - len + 1)
        }
        return max
    }

    fun findLongSubStr(s: String): Int {

        if (s.isEmpty()) return 0

        var map = mutableMapOf<Char, Int>()
        var longSub = 0

        var index = 0
        while (index < s.length) {

            var elementFound = map.getOrDefault(s[index], -1)

            if (elementFound >= 0) {
                index = elementFound + 1
                longSub = longSub.coerceAtLeast(map.size)
                map.clear()
            } else {
                map[s[index]] = index
                index++
            }

        }
        longSub = longSub.coerceAtLeast(map.size)

        return longSub

    }


}
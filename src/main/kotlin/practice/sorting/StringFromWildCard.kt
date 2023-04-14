package practice.sorting

import print


/**
 * ### Strings From Wild Card
 * You are given string s of length n, having m wildcard characters '?', where each wildcard character represents a single character. Write a program which returns a list of all possible distinct strings that can be generated by replacing each wildcard character in s with either '0' or '1'.
 *
 * Any string returned must not contain '?' characters, all must be replaced with either '0' or '1'.
 * ````
 * Example One
 * {
 * "s": "1?10"
 * }
 * Output:
 *
 * ["1010", "1110"]
 * Example Two
 * {
 * "s": "1?0?"
 * }
 * Output:
 *
 * ["1000", "1001", "1100", "1101"]
 * Input string has two '?' characters. Each one can be replaced with either '0' or '1' making the total number of distinct strings 22 = 4.
 * ````
 * #### Notes
 * Order of strings in the output does not matter.
 *
 * #### Constraints:
 *
 * 1 <= n <= 50
 * 0 <= m <= 17
 */


fun main() {
    StringFromWildCard().findAllPossibilities("1?1?1?").print("Output")
}


// 101010, 101011, 101110, 101111, 111010, 111011, 111110, 111111
// 101010, 101011, 101110, 101111, 111010, 111011, 111110, 111111

class StringFromWildCard {

    private val WILD_CHAR = '?'
    private val combination = ('0'..'1')

    fun findAllPossibilities(s: String): ArrayList<String> {

        val resultString = s.toCharArray()
        val output = ArrayList<String>()

        findPossibilities(s, resultString, output, 0)

        return output
    }

    private fun findPossibilities(s: String, rs: CharArray, result: ArrayList<String>, start: Int) {
        if (start == s.length) {
            result.add(String(rs))
            return
        }

        if (s[start] == WILD_CHAR) {
            combination.forEach {
                rs[start] = it
                findPossibilities(s, rs, result, start + 1)
            }

        } else {
            findPossibilities(s, rs, result, start + 1)
        }

    }


}
package practice.leetcode

/**
 * [13. Roman to Integer](https://leetcode.com/problems/roman-to-integer/)
 */

fun main() {

    println("RomanToInteger : ${RomanToInteger().romanToInt(IntegerToRoman().intToRoman(Int.MAX_VALUE))}")
}


class RomanToInteger {

    fun romanToInt(s: String): Int {


        val romanToIntMap = mapOf(
            'I' to 1, 'V' to 5, 'X' to 10, 'L' to 50,
            'C' to 100, 'D' to 500, 'M' to 1000
        )

        var finalNumber = 0
        var i = 0
        while (i < s.length) {
            val cur = romanToIntMap[s[i]] ?: 0
            val next = if (i + 1 < s.length) romanToIntMap[s[i + 1]] ?: 0 else 0
            if (cur < next) {
                finalNumber -= cur
            } else {
                finalNumber += cur
            }

            i++
        }
        return finalNumber
    }
}
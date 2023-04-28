package practice.leetcode

/**
 * [1525. Number of Good Ways to Split a String](https://leetcode.com/problems/number-of-good-ways-to-split-a-string/description/)
 */

fun main() {
    val input = "caba"
    println("$input : ${NumberOfGoodWaysSplitString().numSplits(input)}")
}

class NumberOfGoodWaysSplitString {


    fun numSplits(s: String): Int {
        val left = IntArray(26)
        val right = IntArray(26)
        val counter = intArrayOf(0, 0)

        for (c in s) {
            right[c - 'a']++
            if (right[c - 'a'] == 1) counter[1]++
        }

        var goodSplits = 0
        for (c in s) {
            val index = c - 'a'

            left[index]++
            if (left[index] == 1) counter[0]++

            right[index]--
            if (right[index] == 0) counter[1]--

            if (counter[0] == counter[1]) goodSplits++
        }
        return goodSplits
    }


    fun numSplits_1(s: String): Int {

        val rightHash = mutableMapOf<Char, Int>()
        s.forEach {
            rightHash[it] = (rightHash[it] ?: 0) + 1
        }

        var goodSplit = 0
        val leftHash = mutableSetOf<Char>()

        s.forEach {
            var charCount = rightHash[it] ?: 0
            rightHash[it] = --charCount


            if (charCount <= 0) {
                rightHash.remove(it)
            }

            leftHash.add(it)
            if (leftHash.size == rightHash.size)
                goodSplit++
        }

        return goodSplit

    }
}
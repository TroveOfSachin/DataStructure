package practice.leetcode


/**
 * ## [6. Zigzag Conversion](https://leetcode.com/problems/zigzag-conversion/)
 * Difficulty : Medium
 *
 *
 * The string "[PAYPALISHIRING]" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 * ````
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * ````
 * And then read line by line: "[PAHNAPLSIIGYIR]"
 * Write the code that will take a string and make this conversion given a number of rows:
 * ````
 * string convert(string s, int numRows);
 * ````
 * ### Example 1:
 * ````
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * ````
 * ### Example 2:
 * ````
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * ````
 * ### Example 3:
 * ````
 * Input: s = "A", numRows = 1
 * Output: "A"
 * ````
 * ### Constraints:
 *
 * - 1 <= s.length <= 1000
 * - s consists of English letters (lower-case and upper-case), ',' and '.'.
 * - 1 <= numRows <= 1000
 *
 */


class ZigzagConversion {

    private fun convertHelper(str: String, diff: Int, start: Int): Array<StringBuilder>? {

        if (start >= str.length) return null

        var sb = Array(diff) { StringBuilder() }

        var s = start

        var counter = 0
        while (counter < diff && s < str.length) {
            sb[counter].append(str[s])
            counter++
            s++
        }
        counter--
        while (counter > 1 && s < str.length) {
            --counter
            sb[counter].append(str[s])
            s++
        }

        var output = convertHelper(str, diff, s)

        return mergeSbs(sb, output)

    }

    private fun mergeSbs(
        sbList1: Array<StringBuilder>,
        sbList2: Array<StringBuilder>?
    ): Array<StringBuilder> {
        if (sbList2 == null)
            return sbList1
        (sbList1.indices).forEach {
            sbList1[it].append(sbList2[it])
        }
        return sbList1
    }


    fun convert(s: String, numRows: Int): String {

        if (s.length < numRows) return s
        val output = convertHelper(s, numRows, 0)
        var sb = StringBuilder(s.length)
        output?.forEach {
            sb.append(it)
        }
        return sb.toString()
    }


    /**
     * Best Solution with
     * Time = O(n)
     * Space = (1) - We have not used any additional space other than for building the output, which is not counted.
     * [Check Details](https://leetcode.com/problems/zigzag-conversion/editorial/)
     */

    fun convertBest(s: String, numRows: Int): String {
        val sLen = s.length
        if (numRows == 1) {
            return s
        }
        val maxDist = numRows * 2 - 2
        val buf = StringBuilder()
        for (i in 0 until numRows) {
            var index = i
            if (i == 0 || i == numRows - 1) {
                while (index < sLen) {
                    buf.append(s[index])
                    index += maxDist
                }
            } else {
                while (index < sLen) {
                    buf.append(s[index])
                    index += maxDist - i * 2
                    if (index >= sLen) {
                        break
                    }
                    buf.append(s[index])
                    index += i * 2
                }
            }
        }
        return buf.toString()
    }

}
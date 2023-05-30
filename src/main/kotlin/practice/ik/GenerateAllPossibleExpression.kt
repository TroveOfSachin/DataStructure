package practice.ik

import print

/**
 * #### Generate All Possible Expressions That Evaluate To The Given Target Value
 * Given a string `s` that consists of digits `("0".."9")` and target, a non-negative integer, find all expressions that can be built from string s that evaluate to the target.
 *
 * When building expressions, you have to insert one of the following operators between each pair of consecutive characters in s: join or `*` or `+`. For example, by inserting different operators between the two characters of string "12" we can get either 12 (1 joined with 2 or "12") or 2 ("1*2") or 3 ("1+2").
 *
 * Other operators such as `-` or `÷` are NOT supported.
 *
 * Expressions that evaluate to the target but only utilize a part of s do not count: entire s has to be consumed.
 *
 * Precedence of the operators is conventional: join has the highest precedence, * – medium and + has the lowest precedence. For example, `1 + 2 * 34 = (1 + (2 * (34))) = 1 + 68 = 69`.
 *
 * You have to return ALL expressions that can be built from string s and evaluate to the target.
 *
 * #### Example
 * ```
 * {
 * "s": "202",
 * "target": 4
 * }
 * Output:
 *
 * ["2+0+2", "2+02", "2*02"]
 * ```
 * Same three strings in any other order are also a correct output.
 *
 * #### Notes
 * - Order of strings in the output does not matter.
 * - If there are no expressions that evaluate to target, return an empty list.
 * - Returned strings must not contain spaces or any characters other than "0",..., "9", "*", "+".
 * - All returned strings must start and end with a digit.
 *
 * #### Constraints:
 * - 1 <= length of s <= 13
 * - 1 <= target <= 1013
 *
 *
 */

fun main() {
    val x = GenerateAllPossibleExpression().generateAllExpressions("202", 4)
    x.print("Output")


}

class GenerateAllPossibleExpression {

    fun generateAllExpressions(s: String, target: Long): ArrayList<String> {
        val res = ArrayList<String>()
        if (s.isEmpty()) return res


        fun helper(path: CharArray, digits: CharArray, idx: Int, length: Int, prev: Long, curr: Long) {
            if (idx == digits.size) {
                if (curr + prev == target) {
                    res.add(String(path, 0, length))
                }
            } else {
                var n: Long = 0
                var j = length + 1
                for (i in idx until digits.size) {
                    n = n * 10 + (digits[i] - '0')
                    path[j++] = digits[i]
                    path[length] = '*'
                    helper(path, digits, i + 1, j, prev, curr * n)
                    path[length] = '+'
                    helper(path, digits, i + 1, j, prev + curr, n)
                }
            }
        }


        val path = CharArray(s.length * 2 - 1)
        val digits = s.toCharArray()
        var n: Long = 0
        for (i in digits.indices) {
            n = n * 10 + (digits[i] - '0')
            path[i] = digits[i]
            helper(path, digits, i + 1, i + 1, 0, n)
        }
        return res
    }


}
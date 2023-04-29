package practice.sorting

import print
import java.util.Stack

/**
 * ### Find All Well-formed Brackets
 * Given a positive integer n, return ALL strings of length 2 * n with well-formed round brackets.
 * ````
 * Example
 * {
 * "n": 3
 * }
 * Output:
 * [
 *      "((()))",
 *      "(()())",
 *      "(())()",
 *      "()(())",
 *      "()()()"
 * ]
 * Any array containing these five strings in any order is a correct output.
 * ````
 * #### Notes
 * Order of strings in the returned array is insignificant, e.g. for n = 2 both ["(())", "()()"] and ["()()", "(())"] will be accepted.
 * #### Constraints:
 *
 * 1 <= n <= 12
 * Only use round brackets. '(' and ')'
 */

fun main() {
    val result = FindAllWellFormedBrackets().generateParenthesis(2)
    result.print("Output")
}


class FindAllWellFormedBrackets {


    /**
     * Best Solution
     *
     */

    fun generateParenthesis(n: Int): List<String> {
        val list = ArrayList<String>()
        validPath(0, "", list, 0, 0,  n)
        return list
    }

    private fun validPath(
        count: Int,
        path: String,
        list: ArrayList<String>,
        left: Int,
        right: Int,

        n: Int
    ) {
        if (count < n * 2) {
            if (left < n)
                validPath(count + 1, "$path(", list, left + 1, right, n)
            if (right < left)
                validPath(count + 1, "$path)", list, left, right + 1, n)
            return
        }
        list.add(path)
    }


    fun generateBracketsWithStack(n: Int): ArrayList<String> {
        val res = ArrayList<String>()

        fun backtrack(s: Stack<Char>, open: Int, close: Int) {
            if (s.size == 2 * n) {
                res.add(s.joinToString(""))
                return
            }

            if (open < n) {
                s.push('(')
                backtrack(s, open + 1, close)
                s.pop()

            }

            if (close < open) {
                s.push(')')
                backtrack(s, open, close + 1)
                s.pop()

            }
        }

        backtrack(Stack(), 0, 0)

        return res
    }


    fun generateBracketsBruitForce(n: Int): List<String> {
        val res = arrayListOf<String>()

        fun backtrack(s: String, open: Int, close: Int) {
            if (s.length == 2 * n) {
                res.add(s)
                return
            }

            if (open < n) {
                backtrack("$s(", open + 1, close)

            }

            if (close < open) {
                backtrack("$s)", open, close + 1)

            }
        }

        backtrack("", 0, 0)

        return res
    }


    fun form(input: Int): MutableList<String> {
        val res = mutableListOf<String>()

        fun backtrack(s: String, open: Int, close: Int, n: Int, stack: Stack<Char>) {
            if (s.length == 2 * n) {
                res.add(s)
                return
            }

            if (open < n) {
                stack.push('(')
                backtrack("$s(", open + 1, close, n, stack)
                stack.pop()
            }

            if (close < open && stack.isNotEmpty() && stack.peek() == '(') {
                stack.pop()
                backtrack("$s)", open, close + 1, n, stack)
                stack.push('(')
            }
        }



        backtrack("", 0, 0, input, Stack<Char>())
        return res


    }


}
package practice.leetcode

import java.util.*

/**
 *
 * ### 20. Valid Parentheses
 * Difficulty: Easy
 *
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 *
 * ````
 * Example 1:
 *      Input: s = "()"
 *      Output: true
 *
 * Example 2:
 *      Input: s = "()[]{}"
 *      Output: true
 *
 * Example 3:
 *      Input: s = "(]"
 *      Output: false
 * ````
 *
 * #### Constraints:
 * 1 <= s.length <= 104
 * s consists of parentheses only '()[]{}'.
 */

fun main() {
    val map = mutableMapOf('}' to '{', ']' to '[', ')' to '(')

    val arr = arrayListOf(
        "(())",
        "({{[(())]}})",
        "({({({({[][][]{}{}{}()()()})})()()}){}{}})",
        "){",
        "))",
        "]"

    )


    for (i in arr) {
        val bool = ValidParentheses().isValid(i)
        println("Given String is Valid : $bool")
    }
}

class ValidParentheses {


    fun isValid(s: String): Boolean {
        val stk = Stack<Char>()
        for (i in s) {
            if (i == '{' || i == '[' || i == '(')
                stk.push(i)
            else if (stk.isNotEmpty()) {
                val x = stk.pop()
                if (i == ')' && x != '(' || i == ']' && x != '[' || i == '}' && x != '{')
                    return false
            } else {
                return false
            }
        }
        return stk.isEmpty()
    }

    fun isValid3(s: String): Boolean {
        val stk = Stack<Char>()
        val map = mutableMapOf('}' to '{', ']' to '[', ')' to '(')
        val mapStart = mutableMapOf('{' to null, '[' to null, '(' to null)
        for (i in s) {
            if (mapStart.contains(i))
                stk.push(i)
            else if (stk.isEmpty() || stk.pop() != map[i]) {
                return false
            }
        }
        return stk.isEmpty()
    }


    fun isValid11(s: String): Boolean {
        if (s.isEmpty()) return true
        if (s.length % 2 == 1) return false

        val stk = Stack<Char>()
        val map = mutableMapOf('}' to '{', ']' to '[', ')' to '(')


        fun checkIsValid(start: Int): Boolean {
            if (start == s.length) {
                return stk.isEmpty()
            }
            when (s[start]) {
                '{', '(', '[' -> {
                    stk.push(s[start])
                }

                else -> {
                    if (stk.isEmpty() || stk.pop() != map[s[start]])
                        return false
                }
            }
            return checkIsValid(start + 1)

        }

        return checkIsValid(0)
    }
}
package practice.leetcode

import java.util.*

/**
 * #### [32. Longest Valid Parentheses](https://leetcode.com/problems/longest-valid-parentheses/)
 */

fun main() {
    
    LongestValidParentheses().longestValidParentheses(")))()()(())(((")
}

class LongestValidParentheses {
    fun longestValidParentheses(s: String): Int {


        val list = LinkedList<Int>()
        list.push(-1)

        var max = 0

        for (cId in s.indices) {

            when (s[cId]) {
                '(' -> list.push(cId)
                ')' -> {
                    list.pop()
                    if (list.isEmpty()) {
                        list.push(cId)
                    } else {
                        max = maxOf(max, cId - list.peek())
                    }
                }
            }
        }

        return max
    }
}
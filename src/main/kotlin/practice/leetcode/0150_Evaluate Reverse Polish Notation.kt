package practice.leetcode

import java.util.*

/**
 * #### [150. Evaluate Reverse Polish Notation](https://leetcode.com/problems/evaluate-reverse-polish-notation)
 */

fun main() {
    val input = arrayOf("-128", "-128", "*", "-128", "*", "-128", "*", "-1", "*", "8", "*")
    val output = EvaluateReversePolishNotation().evalRPN(input)
    println(output)
}


class EvaluateReversePolishNotation {
    fun evalRPN(tokens: Array<String>): Int {
        val stack = Stack<Int>()

        tokens.forEach {
            when (it) {

                "+" -> stack.push((stack.pop() + stack.pop()))
                "-" -> {
                    val b = stack.pop()
                    val a = stack.pop()
                    stack.push((a - b))
                }

                "*" -> {
                    stack.push((stack.pop() * stack.pop()))
                }

                "/" -> {
                    val b = stack.pop()
                    val a = stack.pop()
                    stack.push((a / b))
                }

                else -> {
                    stack.push(it.toInt())
                }
            }
        }
        return stack.pop()

    }
}
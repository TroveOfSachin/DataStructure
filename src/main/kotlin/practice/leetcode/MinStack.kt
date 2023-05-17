package practice.leetcode

import ternary
import java.util.*
import java.util.Deque
import java.util.ArrayDeque

/**
 * ####[155. Min Stack](https://leetcode.com/problems/min-stack/)
 */
class MinStack_Approach1 {

    val stack = Stack<Int>()
    val minStack = Stack<Int>()
    fun push(`val`: Int) {
        stack.push(`val`)
        minStack.push(
            if (minStack.isNotEmpty()) {
                minOf(`val`, minStack.peek())
            } else `val`
        )
    }

    fun pop() {
        stack.pop()
        minStack.pop()
    }

    fun top(): Int {
        return stack.peek()
    }

    fun getMin(): Int {
        return minStack.peek()
    }
}


/**
 * Optimized
 */
class MinStack_Approach2 {
    private data class Element(val value: Int, val min: Int)

    private val stack = mutableListOf<Element>()

    fun push(value: Int) {
        val min = if (stack.isEmpty()) value else minOf(value, stack.last().min)
        stack.add(Element(value, min))
    }

    fun pop() {
        stack.removeAt(stack.size - 1)
    }

    fun top(): Int {
        return stack.last().value
    }

    fun getMin(): Int {
        return stack.last().min
    }
}


class MinStack_Approach_3() {
    private val stack: Deque<Int> = ArrayDeque()
    private val minStack: Deque<Int> = ArrayDeque()

    fun push(value: Int) {
        stack.push(value)
        if (minStack.isEmpty() || value <= minStack.peek()) {
            minStack.push(value)
        }
    }

    fun pop() {
        val popped = stack.pop()
        if (popped == minStack.peek()) {
            minStack.pop()
        }
    }

    fun top(): Int {
        return stack.peek()
    }

    fun getMin(): Int {
        return minStack.peek()
    }

}

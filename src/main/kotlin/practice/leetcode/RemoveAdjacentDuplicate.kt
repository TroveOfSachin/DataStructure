package practice.leetcode

import java.util.*

/**
 * [1047. Remove All Adjacent Duplicates In String](https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/)
 */

fun main() {
    val input = "azxxzy"
    val output = RemoveAdjacentDuplicate().removeDuplicates(input)
    println(output)
}

class RemoveAdjacentDuplicate {
    fun removeDuplicates(s: String): String {
        val x = Stack<Char>()
        x.add(s[0])
        var counter = 1
        while (counter < s.length) {
            if (x.isNotEmpty() && s[counter] == x.peek()) {
                x.pop()
            } else {
                x.add(s[counter])
            }
            counter++
        }
        return x.joinToString("")
    }
}
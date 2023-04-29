package practice.leetcode

import java.util.Stack


/**
 * ### [989. Add to Array-Form of Integer](https://leetcode.com/problems/add-to-array-form-of-integer/)
 *
 *
 */
fun main() {
}


class AddToArrayFormOfInteger {
    fun addToArrayForm(num: IntArray, k: Int): List<Int> {


        var numPointer = num.size - 1
        var kVal = k

        val output = mutableListOf<Int>()

        var rem = k

        while (numPointer >= 0) {
            val sum = num[numPointer--] + rem
            rem = sum / 10
            output.add(sum % 10)
        }

        while (rem > 0) {
            output.add(rem % 10)
            rem /= 10
        }

        output.reverse()

        return output
    }


}
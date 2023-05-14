package practice.leetcode

import kotlin.math.sign

/**
 * ## [7. Reverse Integer](https://leetcode.com/problems/reverse-integer/)
 * ## [29. Divide Two Integers](https://leetcode.com/problems/divide-two-integers/)
 */

fun main() {
    ReverseInteger().divide(-2147483648, -1)
}


class ReverseInteger {
    fun reverse(x: Int): Int {
        var output = 0L
        var input = x
        while (input != 0) {
            output = (output * 10) + (input % 10)
            input /= 10
        }
        if (output > Int.MAX_VALUE || output < Int.MIN_VALUE) return 0
        return output.toInt()

    }


    fun divide(dividend: Int, divisor: Int): Int {

        if (dividend == Int.MIN_VALUE && divisor == -1) {
            return Int.MAX_VALUE
        }

        val res = (dividend / divisor)
        return if(res <=Int.MIN_VALUE)
            Int.MIN_VALUE
        else if( res >= Int.MAX_VALUE)
            Int.MAX_VALUE
        else
            res


    }


}

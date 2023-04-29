package practice.leetcode

/**
 * ## [7. Reverse Integer](https://leetcode.com/problems/reverse-integer/)
 */
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

}

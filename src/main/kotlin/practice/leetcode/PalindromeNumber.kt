package practice.leetcode

/**
 * ## [9. Palindrome Number](https://leetcode.com/problems/palindrome-number/)
 */
class PalindromeNumber {

    fun isPalindrome1(x: Int): Boolean {

        if (x < 0) return false

        var i = x

        var r = 0
        while (i > 0) {
            r = r * 10 + i % 10
            i /= 10
        }
        println(r)

        return r == x


    }

    fun isPalindrome(x: Int): Boolean {
        if (x < 0) return false

        fun getDigit(n: Int): Int {
            return (x / n) % 10
        }

        var maxPower = 1
        while (maxPower <= x / 10) {
            maxPower *= 10
        }

        var minPower = 1

        while (minPower < maxPower) {
            if (getDigit(maxPower) != getDigit(minPower)) {
                return false
            }

            minPower *= 10
            maxPower /= 10
        }
        return true
    }
}
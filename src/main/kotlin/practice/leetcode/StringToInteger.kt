package practice.leetcode


/**
 * ## [8. String to Integer (atoi) ](https://leetcode.com/problems/string-to-integer-atoi/)
 */
class StringToInteger {

    fun myAtoi(s: String): Int {

        var output = 0L
        var counter = 0
        var sign = 1
        var spCharOrDigit = false

        while (counter < s.length) {
            val char = s[counter++]

            if (char in '0'..'9') {
                output = output * 10 + "$char".toInt()

                if (output * sign > Int.MAX_VALUE) return Int.MAX_VALUE
                else if (output * sign < Int.MIN_VALUE) return Int.MIN_VALUE

                spCharOrDigit = true

            } else if (char == '-' || char == '+') {
                if (spCharOrDigit) break
                sign = "${char}1".toInt()
                spCharOrDigit = true
            } else if (char == ' ') {
                if (spCharOrDigit) break

            } else {
                break
            }

        }
        output *= sign


        return output.toInt()
    }

}
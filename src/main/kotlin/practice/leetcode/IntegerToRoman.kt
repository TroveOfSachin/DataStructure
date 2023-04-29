package practice.leetcode

/**
 * [12. Integer to Roman](https://leetcode.com/problems/integer-to-roman/)
 */
fun main() {
    println("Roman : ${IntegerToRoman().intToRoman(99)}")
}

class IntegerToRoman {

    fun intToRoman_1(num: Int): String {
        val values = intArrayOf(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1)
        val symbols = arrayOf("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I")
        var result = ""
        var n = num
        var i = 0
        while (n > 0) {
            val count = n / values[i]
            result += symbols[i].repeat(count)
            n %= values[i]
            i++
        }
        return result
    }


    fun intToRoman(num: Int): String {
        val result = StringBuilder()
        var nmbr = num

        while (nmbr > 0) {
            if (nmbr / 1000 > 0) {
                for (i in 0 until nmbr / 1000) {
                    result.append("M")
                }
                nmbr %= 1000

            } else if (nmbr / 100 > 0) {

                when (nmbr / 100) {
                    1 -> result.append("C")
                    2 -> result.append("CC")
                    3 -> result.append("CCC")
                    4 -> result.append("CD")
                    5 -> result.append("D")
                    6 -> result.append("DC")
                    7 -> result.append("DCC")
                    8 -> result.append("DCCC")
                    9 -> result.append("CM")
                }
                nmbr %= 100

            } else if (nmbr / 10 > 0) {
                when (nmbr / 10) {
                    1 -> result.append("X")
                    2 -> result.append("XX")
                    3 -> result.append("XXX")
                    4 -> result.append("XL")
                    5 -> result.append("L")
                    6 -> result.append("LX")
                    7 -> result.append("LXX")
                    8 -> result.append("LXXX")
                    9 -> result.append("XC")
                }
                nmbr %= 10

            } else {

                when (nmbr) {
                    1 -> result.append("I")
                    2 -> result.append("II")
                    3 -> result.append("III")
                    4 -> result.append("IV")
                    5 -> result.append("V")
                    6 -> result.append("VI")
                    7 -> result.append("VII")
                    8 -> result.append("VIII")
                    9 -> result.append("IX")
                }
                break
            }
        }


        return result.toString()
    }





}
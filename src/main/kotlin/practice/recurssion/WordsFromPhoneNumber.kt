package practice.recurssion

import print


/**
 * #### Words From Phone Number
 * Given a seven-digit phone number, return all the character combinations that can be generated according to the following mapping:
 *
 * Return the combinations in the lexicographical order.
 * ````
 * Example One
 * {
 * "phone_number": "1234567"
 * }
 * Output:
 *
 * [
 * "adgjmp",
 * "adgjmq",
 * "adgjmr",
 * "adgjms",
 * "adgjnp",
 * ...
 * "cfilns",
 * "cfilop",
 * "cfiloq",
 * "cfilor",
 * "cfilos"
 * ]
 * First string "adgjmp" in the first line comes from the first characters mapped to digits 2, 3, 4, 5, 6 and 7 respectively. Since digit 1 maps to nothing, nothing is appended before 'a'. Similarly, the fifth string "adgjnp" generated from first characters of 2, 3, 4, 5 second character of 6 and first character of 7. All combinations generated in such a way must be returned in the lexicographical order.
 *
 * Example Two
 * {
 * "phone_number": "1234567"
 * }
 * Output:
 *
 * [""]
 * ````
 * Notes
 * Return an array of the generated string combinations in the lexicographical order. If nothing can be generated, return a list with an empty string "".
 * Digits 0 and 1 map to nothing. Other digits map to either three or four different characters each.
 * Constraints:
 *
 * Input string is 7 characters long; each character is a digit.
 */

fun main() {
    val output = WordsFromPhoneNumber().getWordsFromPhoneNumber("1234567")
    output.print("Output")
}


class WordsFromPhoneNumber {

    fun getWordsFromPhoneNumber(phoneNumber: String): ArrayList<String> {
        val letterComb = arrayOf("0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz")

        fun generateCombination(str: StringBuilder, current: Int, output: ArrayList<String>, phoneLen: Int) {
            if (str.length == phoneLen) {
                output.add(str.toString())
                return
            }
            while (listOf('0', '1').contains(phoneNumber[current])) {
                generateCombination(str, current + 1, output, phoneLen - 1)
                return
            }

            letterComb["${phoneNumber[current]}".toInt()].forEach {
                str.append(it)
                generateCombination(str, current + 1, output, phoneLen)
                str.deleteCharAt(current - (phoneNumber.length - phoneLen))
            }
        }

        val output = arrayListOf<String>()
        generateCombination(StringBuilder(), 0, output, phoneNumber.length)


        return output
    }


    val NUMS = mapOf(
        2 to "abc",
        3 to "def",
        4 to "ghi",
        5 to "jkl",
        6 to "mno",
        7 to "pqrs",
        8 to "tuv",
        9 to "wxyz"
    )
    /**
    backtracking alg

     **/
    fun letterCombinations(digits: String): List<String> {
        if (digits.isEmpty()) return acc

        backtracking(0, digits, StringBuilder())
        return acc

    }
    val acc = mutableListOf<String>()

    private fun backtracking(idx: Int, digits: String, current: StringBuilder) {
        if (idx >= digits.length) {

            acc.add(current.toString())
            return
        }

        val digit = digits[idx] - '0' // ex. 2

        val letters = NUMS[digit]!! // ex."abc"

        for (c in letters) {
            current.append(c)
            backtracking(idx + 1, digits, current)
            current.setLength(current.length - 1)
        }
    }

}
package practice.leetcode

/**
 * [345. Reverse Vowels of a String](https://leetcode.com/problems/reverse-vowels-of-a-string/)
 */

fun main() {
    println(ReverseVowelsOfString().reverseVowels("hello"))
}

class ReverseVowelsOfString {

    val vowels = charArrayOf('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
    fun reverseVowels(s: String): String {

        val charArray = s.toCharArray()

        var left = 0
        var right = s.length - 1

        while (left < right) {
            while (!isVowel(s[left]) && left < right)
                left++
            while (!isVowel(s[right]) && right > left)
                right--
            val t = charArray[right]
            charArray[right] = charArray[left]
            charArray[left] = t
            left++
            right--

        }
        return String(charArray)

    }

    fun isVowel(ch: Char): Boolean {
        return (ch in vowels)
    }
}
package practice.leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LongestPalindromeTest {

    val longestPalindrome = LongestPalindrome()

    private fun longestPalindromeTest(input: String, expected: String) {
        assertEquals(expected, longestPalindrome.longestPalindrome(input))
    }

    @Test
    fun longestPalindromeTest1() {
        val input = "babad"
        val expected = "bab"
        longestPalindromeTest(input, expected)
    }

    @Test
    fun longestPalindromeTest2() {
        val input = "mojologiccigolmojo"
        val expected = "logiccigol"
        longestPalindromeTest(input, expected)
    }

    @Test
    fun longestPalindromeTest3() {
        val input = "cbbd"
        val expected = "bb"
        longestPalindromeTest(input, expected)
    }

    @Test
    fun longestPalindromeTest4() {
        val input = "forgeeksskeegfor"
        val expected = "geeksskeeg"
        longestPalindromeTest(input, expected)
    }

    @Test
    fun longestPalindromeTest5() {
        val input = "Geeks"
        val expected = "ee"
        longestPalindromeTest(input, expected)
    }

    @Test
    fun longestPalindromeTest6() {
        val input = "babcbabcbaccba"
        val expected = "abcbabcba"
        longestPalindromeTest(input, expected)
    }

    @Test
    fun longestPalindromeTest7() {
        val input = "abaaba"
        val expected = "abaaba"
        longestPalindromeTest(input, expected)
    }

    @Test
    fun longestPalindromeTest8() {
        val input = "abababa"
        val expected = "abababa"
        longestPalindromeTest(input, expected)
    }

    @Test
    fun longestPalindromeTest9() {
        val input = "abcbabcbabcba"
        val expected = "abcbabcbabcba"
        longestPalindromeTest(input, expected)
    }

    @Test
    fun longestPalindromeTest10() {
        val input = "caba"
        val expected = "aba"
        longestPalindromeTest(input, expected)
    }

    @Test
    fun longestPalindromeTest11() {
        val input = "abacdfgdcaba"
        val expected = "aba"
        longestPalindromeTest(input, expected)
    }

    @Test
    fun longestPalindromeTest12() {
        val input = "abacdfgdcabba"
        val expected = "abba"
        longestPalindromeTest(input, expected)
    }

    @Test
    fun longestPalindromeTest13 () {
        val input = "abacdedcaba"
        val expected = "abacdedcaba"
        longestPalindromeTest(input, expected)
    }

    @Test
    fun longestPalindromeTest14 () {
        val input = "ab"
        val expected = "a"
        longestPalindromeTest(input, expected)
    }
}
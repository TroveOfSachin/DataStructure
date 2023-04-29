package practice.leetcode

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class PalindromeNumberTest {

    val pal = PalindromeNumber()
    fun isPalindrome() {
    }

    @Test
    fun isPalindrome1() {

        assertEquals(true, pal.isPalindrome(121))
    }

    @Test
    fun isPalindrome2() {

        assertEquals(false, pal.isPalindrome(-121))
    }

    @Test
    fun isPalindrome3() {

        assertEquals(false, pal.isPalindrome(-10))
    }

    @Test
    fun isPalindrome4() {

        assertEquals(true, pal.isPalindrome(11))
    }

    @Test
    fun isPalindrome5() {

        assertEquals(true, pal.isPalindrome(0))
    }
}
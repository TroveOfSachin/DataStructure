package practice.leetcode

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class StringToIntegerTest {

    private val stringToInteger = StringToInteger()
    fun myAtoi(input: String, expected: Int) {
        assertEquals(expected, stringToInteger.myAtoi(input))
    }

    @Test
    fun myAtoiTest1() {
        val s = "42"
        val expected = 42
        myAtoi(s, expected)

    }

    @Test
    fun myAtoiTest2() {
        val s = "   -42"
        val expected = -42
        myAtoi(s, expected)

    }

    @Test
    fun myAtoiTest3() {
        val s = "4193 with words"
        val expected = 4193
        myAtoi(s, expected)
    }

    @Test
    fun myAtoiTest4() {
        val s = "a4193 with words"
        val expected = 4193
        myAtoi(s, expected)
    }

    @Test
    fun myAtoiTest5() {
        val s = "000-1"
        val expected = 0
        myAtoi(s, expected)
    }

    @Test
    fun myAtoiTest6() {
        val s = "123-"
        val expected = 123
        myAtoi(s, expected)
    }

    @Test
    fun myAtoiTest7() {
        val s = "98765432123344566-"
        val expected = Int.MIN_VALUE
        myAtoi(s, expected)
    }
    @Test
    fun myAtoiTest8() {
        val s = "98765432123344566"
        val expected = Int.MAX_VALUE
        myAtoi(s, expected)
    }
    @Test
    fun myAtoiTest9() {
        val s = "....-23"
        val expected = 0
        myAtoi(s, expected)
    }

    @Test
    fun myAtoiTest10() {
        val s = ".1"
        val expected = 0
        myAtoi(s, expected)
    }

    @Test
    fun myAtoiTest11() {
        val s = "23    "
        val expected = 23
        myAtoi(s, expected)
    }

}
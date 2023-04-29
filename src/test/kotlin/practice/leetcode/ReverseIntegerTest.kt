package practice.leetcode

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import kotlin.math.exp

class ReverseIntegerTest {

    private val reverseInteger = ReverseInteger()

    private fun reverseTest(input: Int, expected: Int) {
        assertEquals(expected, reverseInteger.reverse(input))
    }

    @Test
    fun reverseTest1() {
        reverseTest(123, 321)
    }

    @Test
    fun reverseTest2() {
        reverseTest(-123, -321)
    }

    @Test
    fun reverseTest3() {
        reverseTest(120, 21)
    }

    @Test
    fun reverseTest4() {
        reverseTest(1534236469, 0)
    }

    @Test
    fun reverseTest5() {
        reverseTest(-2147483412, -2143847412)
    }

    @Test
    fun reverseTest6() {
        reverseTest(-2147483648, 0)
    }
}
package practice.leetcode

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ZigzagConversionTest {

    val zigzagConversion = ZigzagConversion()

    private fun convertTest(s: String, numRows: Int, expected: String) {
        assertEquals(expected, zigzagConversion.convert(s, numRows))
    }

    @Test
    fun convertTest1() {

        val input = "PAYPALISHIRING"
        val numRows = 3

        val expected = "PAHNAPLSIIGYIR"
        convertTest(input, numRows, expected)
    }


    @Test
    fun convertTest2() {

        val input = "PAYPALISHIRING"
        val numRows = 4

        val expected = "PINALSIGYAHRPI"
        convertTest(input, numRows, expected)
    }


    @Test
    fun convertTest3() {

        val input = "RGBGRGBGRGBGRGBGRGB"
        val numRows = 3

        val expected = "RRRRRGGGGGGGGGBBBBB"
        convertTest(input, numRows, expected)
    }

    @Test
    fun convertTest4() {

        val input = "ABCDEFGHIJKLMNOPQSTUVWXYZ"
        val numRows = 5

        val expected = "AIQZBHJPSYCGKOTXDFLNUWEMV"
        convertTest(input, numRows, expected)
    }


    @Test
    fun convertTest5() {

        val input = "abcd"
        val numRows = 1

        val expected = "abcd"
        convertTest(input, numRows, expected)
    }
}
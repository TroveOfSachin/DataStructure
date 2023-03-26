package practice.leetcode

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LongestSubStringTest {

    val longestSubString = LongestSubString()

    private fun findLongSubStrTest(s: String, expected: Int) {
        assertEquals(expected, longestSubString.lengthOfLongestSubstring(s))
    }


    @Test
    fun findLongSubStrTest1() {
        val s = ""
        findLongSubStrTest(s, 0)
    }

    @Test
    fun findLongSubStrTest2() {
        val s = "au"
        findLongSubStrTest(s, 2)
    }

    @Test
    fun findLongSubStrTest3() {
        val s = "abcabcbb"
//        "pwwkew"
        findLongSubStrTest(s, 3)
    }

    @Test
    fun findLongSubStrTest4() {
        val s = "bbbbb"
//        "pwwkew"
        findLongSubStrTest(s, 1)
    }

    @Test
    fun findLongSubStrTest5() {
        val s = "pwwkew"
        findLongSubStrTest(s, 3)
    }

    @Test
    fun findLongSubStrTest6() {
        val s = "dvdf"
        findLongSubStrTest(s, 3)
    }
}
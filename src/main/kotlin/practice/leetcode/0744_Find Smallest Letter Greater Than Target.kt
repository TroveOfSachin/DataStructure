package practice.leetcode

import java.util.*

fun main() {
    val inp = charArrayOf('c','f','j')
    val obj = FindSmallestLetterGreaterThanTarget()
    val res = obj.nextGreatestLetter(inp, 'c')
    println(res)
}


class FindSmallestLetterGreaterThanTarget {
    fun nextGreatestLetter(letters: CharArray, target: Char): Char {


        val index = Arrays.binarySearch(letters, target)
        val position = if (index >= 0) index + 1 else -index - 1
        val nextIndex = position % letters.size
        return letters[nextIndex]


//        if (letters[letters.size - 1] < target || letters[0] > target) return letters[0]
//
//        fun find(start: Int, end: Int): Char {
//            if (start == end) {
//                return if (letters[start] > target) letters[start] else letters[0]
//            }
//
//            val mid = (start + end) / 2
//            return if (letters[mid] > target)
//                find(start, mid)
//            else
//                find(mid + 1, end)
//        }
//
//        val res = find(0, letters.size - 1)
//        println("Result : $res")
//        return res
    }
}
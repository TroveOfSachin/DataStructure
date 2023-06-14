package practice.leetcode.contest


fun main() {
    val s = Solution()
    val str = arrayOf("52233", "5494", "1111111", "0000", "123456789", "01", "0010", "0100", "4411794")

    str.forEach {
        println(s.longestSemiRepetitiveSubstring(it))
    }
}

class Solution {
    fun longestSemiRepetitiveSubstring(s: String): Int {

        if (s.toSet().size == s.length) return s.length
        var res = 0


        var pairIndex = 1
        while (pairIndex < s.length) {
            var hasPair = false

            var len = 1
            var pair = pairIndex
            for (j in pairIndex until s.length) {

                if (s[j - 1] == s[j]) {
                    if (hasPair) {
                        break
                    } else {
                        pair = j
                        hasPair = true
                    }
                }
                len++

            }
            res = maxOf(res, len)
            if (s.length <= res + pairIndex)
                break
            if (pair > pairIndex)
                pairIndex = pair
            else
                pairIndex++


        }

        return res

    }
}
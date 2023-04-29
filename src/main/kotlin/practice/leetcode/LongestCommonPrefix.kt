package practice.leetcode

/**
 * [14. Longest Common Prefix](https://leetcode.com/problems/longest-common-prefix/)
 */
fun main() {
    val output = LongestCommonPrefix().longestCommonPrefix(arrayOf("aaa","aa","aaa"))
    println("Output $output")
}

class LongestCommonPrefix {

    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.isEmpty()) return ""
        if (strs.size == 1) return strs[0]
        strs.sort()

        println(strs.contentDeepToString())
        val maxPrefixLen = Math.min(strs[0].length, strs[strs.size - 1].length)
        val sb = StringBuilder("")

        var idx = 0
        while (idx < maxPrefixLen) {
            if (strs[0][idx] != strs[strs.size - 1][idx]) {
                break
            }
            sb.append(strs[0][idx])
            idx++
        }

        return sb.toString()
    }
}
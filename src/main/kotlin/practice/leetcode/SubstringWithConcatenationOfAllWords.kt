package practice.leetcode

import print


/**
 * [30. Substring with Concatenation of All Words](https://leetcode.com/problems/substring-with-concatenation-of-all-words/description/)
 */


fun main() {
    val s = "wordgoodwordbestgoodbestwordword"
    val words = arrayOf("word","good","best","word")
    val output = SubstringWithConcatenationOfAllWords().findSubstring(s, words)
    output.print("Output")
}

class SubstringWithConcatenationOfAllWords {

    /**
     * TC = O(m*n)
     *
     */
    fun findSubstring_Simple(s: String, words: Array<String>): List<Int> {

        val wordLen = words[0].length
        val totalChars = wordLen * words.size
        val output = mutableListOf<Int>()
        val sortedWords = words.sorted()

        var start = 0
        while (start + totalChars <= s.length) {
            val sub = s.substring(start, start + totalChars)
            val disWords = sub.chunked(wordLen).sorted()
            if (disWords == sortedWords) {
                output.add(start)
            }
            start++
        }

        return output
    }

    /*
   For example, S="ABCDEFGHI", and L=["EFG"].
When i=0, we match "EFG" with S. In this process, we match "EFG" with "ABC", "DEF", "GHI", but they are all incorrect.
So, next time, let i=i+1 and j=i, which means S's first substr is "BCD", so we match "EFG" with "BCD", "EFG", it's correct.
But when i = wl(which equals 3), we match "EFG" with "DEF","GHI", and it's the same as i=0, so it's unnecessary.
That's my understanding about "all sub string combinations".
*/
    fun findSubstring(s: String, words: Array<String>): List<Int> {
        val ans = ArrayList<Int>()
        // the target of sliding window
        val target = words.groupingBy { it }.eachCount()

        val len = words[0].length
        for (ind in 0 until len) { // sliding window, but len times
            var l = ind
            var r = l
            val cnt = HashMap<String, Int>()
            // invariant: s[l,r) only contains the str in $words
            // expand r
            while (r+len <= s.length) {
                val w = s.substring(r, r+len)
                cnt[w] = cnt.getOrDefault(w, 0) + 1
                r += len

                // shrink l
                while (cnt[w]!! > target.getOrDefault(w, 0)) {
                    val ww = s.substring(l, l+len)
                    cnt[ww] = cnt[ww]!! - 1
                    l += len
                }

                // if window has the right size, it's one ans
                if (r-l == len * words.size) ans.add(l)
            }
        }

        return ans
    }

    fun findSubstring_NewVersion(s: String, words: Array<String>): List<Int> {
        val ans = mutableListOf<Int>()
        val wordCount = words.groupingBy { it }.eachCount().toMutableMap()
        val wordLength = words[0].length
        val windowLength = wordLength * words.size

        for (offset in 0 until wordLength) {
            var left = offset
            var right = offset

            while (right + wordLength <= s.length) {
                val word = s.substring(right, right + wordLength)
                right += wordLength

                if (wordCount.containsKey(word)) {
                    wordCount[word] = wordCount[word]!! - 1
                    while (wordCount[word]!! < 0) {
                        val leftWord = s.substring(left, left + wordLength)
                        wordCount[leftWord] = wordCount[leftWord]!! + 1
                        left += wordLength
                    }

                    if (right - left == windowLength) {
                        ans.add(left)
                        val leftWord = s.substring(left, left + wordLength)
                        wordCount[leftWord] = wordCount[leftWord]!! + 1
                        left += wordLength
                    }
                } else {
                    left = right
                    wordCount.keys.forEach { wordCount[it] = words.count { w -> w == it } }
                }
            }
        }

        return ans
    }
}
package practice.leetcode.contest


fun main() {
    println(SolutionContest2734().smallestString("cbabc"))
}

class SolutionContest2734 {
    fun smallestString(s: String): String {
        val sr = s.toCharArray()
        val n = sr.size
        var i = 0
        // skipping initial a as we need a smallest string. and smallest string start with a in alphabets
        while (i<n && sr[i] == 'a')
            i++
        // if all a then change last character to -1 i.e. 'z' as we have to do a one opration atleast
        if(i == n)
            sr[n-1] = 'z'

        // change all other characters from a till non 'a' character
        while(i<n && sr[i] != 'a'){
            sr[i]-- // changing one character to previous characters
            i++
        }
        return String(sr)

    }
}
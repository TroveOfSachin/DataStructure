package practice.leetcode

import java.util.*


/**
 * [649. Dota2 Senate](https://leetcode.com/problems/dota2-senate/)
 */

fun main() {

    val x = "ABCDABCDABCD"




    val output = Dota2Senate().predictPartyVictory("RRRRRDDDDDDDD")
    println(output)
}

fun kidsWithCandies(candies: IntArray, extraCandies: Int): List<Boolean> {
    val mx = candies.max()
    val x = "".toCharArray()
    val s = String(x)
    return candies.map{ it+extraCandies>=mx}.toList()

}

class Dota2Senate {


    val vowels = charArrayOf('a','e','i','o','u', 'A','E','I','O','U')
    fun reverseVowels(s: String): String {


        val x = mutableMapOf<Int, Int>()




        val len = s.length
        val charArray = s.toCharArray()

        var left = 0
        var right = s.length-1

        while(left<right){
            while(!isVowel(s[left]))
                left++
            while(!isVowel(s[right]))
                right--

            charArray[right] = charArray[left]
            charArray[left] = charArray[right]
            left++
            right++

        }
        return String(charArray)

    }

    fun isVowel(ch:Char):Boolean{
        return (ch in vowels )
    }



    fun predictPartyVictory(senate: String): String {
        val qr = LinkedList<Int>()
        val qd = LinkedList<Int>()
        val n: Int = senate.length
        for (i in 0 until n) {
            if (senate[i] == 'R')
                qr.add(i)
            else qd.add(i)
        }
        while (!qr.isEmpty() && !qd.isEmpty()) {
            val r_i: Int = qr.poll()
            val d_i: Int = qd.poll()
            if (r_i < d_i) qr.add(r_i + n) else qd.add(d_i + n)


        }
        return if (qr.size > qd.size) "Radiant" else "Dire"
    }
}


fun <T> T.ternary(trueCondition: () -> T, falseCondition: () -> T): () -> T {
    return if (this == true) trueCondition else falseCondition
}

fun <T> T.ternary(trueValue: T, falseValue: T): T {
    return if (this == true) trueValue else falseValue
}
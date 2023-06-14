package practice.leetcode

fun main() {
    val res = MinimumFlipsToMake().minFlips1(2, 6, 5)
    println(res)
}

class MinimumFlipsToMake {
    fun minFlips1(a: Int, b: Int, c: Int): Int {
        return Integer.bitCount(a or b xor c) + Integer.bitCount(a and b and (a or b xor c))
    }

    fun minFlips(a: Int, b: Int, c: Int): Int {
        var a = a
        var b = b
        var c = c
        var answer = 0
        while ((a != 0) or (b != 0) or (c != 0)) {
            if (c and 1 == 1) {
                if (a and 1 == 0 && b and 1 == 0) {
                    answer++
                }
            } else {
                answer += (a and 1) + (b and 1)
            }
            a = a shr 1
            b = b shr 1
            c = c shr 1
        }
        return answer
    }
}
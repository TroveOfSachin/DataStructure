package practice.leetcode

import print
import java.util.Stack


fun main() {

    val input = (5 downTo 1).toList().toIntArray()

    val output = TowerOfHanoi().arrange(input)
    output.print("Destination output")
}

class TowerOfHanoi {

    val A = Stack<Int>()
    val B = Stack<Int>()
    val C = Stack<Int>()


    fun arrange(input: IntArray): IntArray {

        for (n in 0..input.lastIndex) {
            A.push(input[n])
        }
        arrangeToH(input.size - 1, A, B, C)

        return B.toIntArray()
    }

    private fun arrangeToH(start: Int, src: Stack<Int>, dest: Stack<Int>, aux: Stack<Int>) {

        A.toArray().print("A", true)
        B.toArray().print("B", true)
        C.toArray().print("C", true)

        if (start == 0) dest.push(src.pop())
        else {
            arrangeToH(start - 1, src, aux, dest)
            dest.push(src.pop())
            arrangeToH(start - 1, aux, dest, src)
        }
    }

}
package practice.sorting

import print
import java.util.Stack
import java.util.concurrent.atomic.AtomicInteger

/**
 * Tower Of Hanoi
 * Tower of Hanoi is a mathematical puzzle where we have three pegs and n disks. The objective of the puzzle is to move the entire stack to another peg, obeying the following simple rules:
 *
 * Only one disk can be moved at a time.
 * Each move consists of taking the upper disk from one of the stacks and placing it on top of another stack i.e. a disk can only be moved if it is the uppermost disk on a stack.
 * No disk may be placed on top of a smaller disk.
 * Given n denoting the number of disks in the first peg, return all the steps required to move all disks from the first peg to the third peg in minimal number of steps.
 *
 * Example
 * {
 * "n": 4
 * }
 * Output:
 *
 * [
 * [1, 2],
 * [1, 3],
 * [2, 3],
 * [1, 2],
 * [3, 1],
 * [3, 2],
 * [1, 2],
 * [1, 3],
 * [2, 3],
 * [2, 1],
 * [3, 1],
 * [2, 3],
 * [1, 2],
 * [1, 3],
 * [2, 3]
 * ]
 * Following steps:
 *
 * [1, 2] = Shift top disk of the first peg to top of the second peg.
 * Picture after this step will be:
 * First peg: 2 3 4
 * Second peg: 1
 * Third peg: Empty
 *
 * [1, 3] = Shift top disk of the first peg to top of the third peg.
 * Picture after this step will be:
 * First peg: 3 4
 * Second peg: 1
 * Third peg: 2
 *
 * Similarly after following remaining steps, the final configuration will be:
 * First peg: Empty
 * Second peg: Empty
 * Third peg: 1 2 3 4
 *
 * Hence, our objective is achieved.
 *
 * Notes
 * Return a 2d integer array containing all the steps taken to move all n disks from the first peg to the third peg in minimal number of steps. Each row will have two integers denoting from peg and to peg, for example, if the ith row is [2, 3], then it means in this step, we moved the top disk on peg 2 to peg 3.
 * Constraints:
 *
 * 1 <= n <= 20
 */
fun main() {

    val input = (10 downTo 1).toList().toIntArray()

//    val output = TowerOfHanoi().arrange(input)
    TowerOfHanoi().tower_of_hanoi(4)
//    output.print("Destination output")
//    println("Counter = ${counter.get()}")
}

val counter = AtomicInteger(0)

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
        counter.incrementAndGet()
        A.toArray().print("A", true)
        B.toArray().print("B", true)
        C.toArray().print("C", true)
        println("*".repeat(50))

        if (start == 0) dest.push(src.pop())
        else {
            arrangeToH(start - 1, src, aux, dest)
            dest.push(src.pop())
            arrangeToH(start - 1, aux, dest, src)
        }
    }


    fun tower_of_hanoi(n: Int): ArrayList<ArrayList<Int>> {
        // Write your code here.
        toh(n, 1, 2, 3)

        output.print("Output")
        return arrayListOf()
    }


    private val output = ArrayList<ArrayList<Int>>()
    private fun toh(n: Int, src: Int, dest: Int, aux: Int) {

        if (n == 0)
            return

        toh(n - 1, src, aux, dest)
        output.add(arrayListOf(src, aux))
        toh(n - 1, dest, src, aux)

    }


}
package practice.sorting

import print
import swap

/**
 * - Given an array of numbers, rearrange them in-place so that even numbers appear before odd ones.
 *
 * - Example
 * ``
 *      {
 *          "numbers": [1, 2, 3, 4]
 *      }
 * ``
 *
 * - Output
 *      [4, 2, 3, 1]
 *
 * The order within the group of even numbers does not matter; same with odd numbers.
 * So the following are also correct outputs: `[4, 2, 1, 3], [2, 4, 1, 3], [2, 4, 3, 1]`.
 * #####
 *  ### Note
 * - It is important to practice solving this problem by rearranging numbers in-place.
 * - There is no need to preserve the original order within the even and within the odd numbers.
 * - We look for a solution of the linear time complexity that uses constant auxiliary space.
 */

fun main() {
    val inputArray = RandomArrayGenerator.getArray(10)
    inputArray.print("Original Input")
    OddEven().arrange(inputArray)
    inputArray.print("Arranged Output")
}

class OddEven {

    fun arrange(numbers: Array<Int>): Array<Int> {

        var loopCounter = 0

        var even = 0
        var odd = numbers.lastIndex

        while (even < odd) {
            loopCounter++

            if (numbers[even] % 2 != 0 && numbers[odd] % 2 != 1) {
                numbers.swap(even, odd)
                even++
                odd--
            } else if (numbers[odd] % 2 == 1) {
                odd--
            } else if (numbers[even] % 2 == 0) {
                even++
            }


        }

        println("LoopCoutner = $loopCounter")

        return numbers

    }


}


/*

1, 2, 3, 4

even = 0
odd = n-1

for 0 to n-1:
    leftEven = true
    rightEven = true

    A[even] is even:
        leftEven=true
        even++

    A[odd] is odd :
        rightOdd = true
        odd++

    if !leftEven & rightOdd
        odd++
    else leftEven & !rightOdd
        even++
    else
        swap[left, right]
        even++
        odd++






 */
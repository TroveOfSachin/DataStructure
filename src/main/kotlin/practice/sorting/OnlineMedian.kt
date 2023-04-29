package practice.sorting

import print
import java.util.PriorityQueue

/**
 * ### Online Median
 * Given a list of numbers, the task is to insert these numbers into a stream and find the median of the stream after each insertion. If the median is a non-integer, consider it’s floor value.
 *
 * The median of a sorted array is defined as the middle element when the number of elements is odd and the mean of the middle two elements when the number of elements is even.
 * ### Example
 * ````
 * {
 * "stream": [3, 8, 5, 2]
 * }
 * ````
 * ### Output:
 * ````
 * [3, 5, 5, 4]
 * ````
 * | Iteration |	Stream	|Sorted Stream|	Median|
 * |----|----|----|----|
 * |1	|`[3]`          |	`[3]`	         | `3`                |
 * |2	|`[3, 8]`	      | `[3, 8]`        |	`(3 + 8) / 2 => 5`|
 * |3	|`[3, 8, 5]`    |	`[3, 5, 8]`	 | `5`                 |
 * |4	|`[3, 8, 5, 2]`  |	`[2, 3, 5, 8]` |	`(3 + 5) / 2 => 4`|
 *
 *
 * ### Constraints:
 * - 1 <= length of stream <= 105
 * - 1 <= any value in the stream <= 105
 * - The stream can contain duplicates.
 */


fun main() {
    val stream = arrayListOf(3, 8, 5, 2)
    val output = OnlineMedian().findMedian(stream)
    output.print("Output")
}


class OnlineMedian {

    fun findMedian(stream: ArrayList<Int>): ArrayList<Int> {

        val leftHeap = PriorityQueue<Int>(compareByDescending { it }) // largest element at root
        val rightHeap = PriorityQueue<Int>() // smallest element at root

        val output = arrayListOf<Int>()

        stream.forEach {

            if (leftHeap.size == 0 && rightHeap.size == 0) {
                leftHeap.add(it)
                output.add(leftHeap.peek())
            } else {

                if (leftHeap.size == rightHeap.size) {
                    if (it <= leftHeap.peek()) {
                        leftHeap.add(it)
                        output.add(leftHeap.peek())

                    } else {
                        rightHeap.add(it)
                        output.add(rightHeap.peek())

                    }


                } else if (leftHeap.size > rightHeap.size) {

                    val leftMax = leftHeap.poll()

                    if (it <= leftMax) {
                        leftHeap.add(it)
                        rightHeap.add(leftMax)
                    } else {
                        leftHeap.add(leftMax)
                        rightHeap.add(it)
                    }
                    output.add((leftHeap.peek() + rightHeap.peek()) / 2)

                } else { // right heap size is larger
                    val rightSmall = rightHeap.poll()
                    if (it >= rightSmall) {
                        rightHeap.add(it)
                        leftHeap.add(rightSmall)
                    } else {
                        rightHeap.add(rightSmall)
                        leftHeap.add(it)
                    }
                    output.add((leftHeap.peek() + rightHeap.peek()) / 2)
                }
            }
        }

        return output
    }
}
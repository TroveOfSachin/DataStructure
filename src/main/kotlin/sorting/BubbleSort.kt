package sorting

import print
import java.sql.DriverManager.println
import java.util.concurrent.atomic.AtomicInteger


fun main() {

    val bubbleSort = BubbleSort()
    val inputArray = RandomArrayGenerator.getArray(10)

    // inputArray.sort() // uncomment this line if wanted to check with best case
    inputArray.print("UnSorted Array")
    bubbleSort.sort(inputArray)
    inputArray.print("Sorted Array")

    print("${"*".repeat(50)}\n")
    print("Loop Count : ${bubbleSort.loopIndex.get()} \n")


}

class BubbleSort {


    val loopIndex: AtomicInteger = AtomicInteger()

    fun sort(array: Array<Int>): Array<Int> {
        var n = array.size
        var swapped: Boolean

        do {
            loopIndex.incrementAndGet()
            swapped = false
            for (i in 1 until n) {
                loopIndex.incrementAndGet()
                if (array[i - 1] > array[i]) {
                    val temp = array[i]
                    array[i] = array[i - 1]
                    array[i - 1] = temp
                    swapped = true
                }
            }
            n--
        } while (swapped)

        return array

    }
}
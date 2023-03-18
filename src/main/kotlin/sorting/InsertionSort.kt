package sorting

import java.util.concurrent.atomic.AtomicInteger


fun main() {
    val insertionSort = InsertionSort()
    val sampleArray = RandomArrayGenerator.getArray(10)

    println("UnSorted Array")
    println(sampleArray.contentToString())

    sampleArray.sort()
//    sampleArray.reverse()
    println("Reverse Sorted Array")
    println(sampleArray.contentToString())
    println("Sorted Array")
    insertionSort.sort(sampleArray)
    println(sampleArray.contentToString())




}

class InsertionSort {
    fun sort(sampleArray: Array<Int>) {

        val loopCounter: AtomicInteger = AtomicInteger()

        val n = sampleArray.size


        for (outerIndex in 1 until n) {

            loopCounter.incrementAndGet()

            val sortedElement = sampleArray[outerIndex]

            var innerIndex = outerIndex - 1

            while (innerIndex >= 0 && sampleArray[innerIndex] > sortedElement) {
                loopCounter.incrementAndGet()
                sampleArray[innerIndex + 1] = sampleArray[innerIndex]

                innerIndex--
            }
            sampleArray[++innerIndex] = sortedElement

        }

        println("Loop Count : ${loopCounter.get()}")

    }

}



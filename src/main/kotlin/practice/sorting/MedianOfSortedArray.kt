package practice.sorting

import java.util.PriorityQueue

fun main() {
    val a1 = arrayListOf(3)
    val a2 = arrayListOf(-2, -1)


    val output = MedianOfSortedArray().findMedian(a1.toIntArray(), a2.toIntArray())
    println(output)
}


class MedianOfSortedArray {

    fun findMedian(a: IntArray, b: IntArray): Double {

        val heapLeft = PriorityQueue<Int>()
        val heapRight = PriorityQueue<Int>(compareByDescending { it })

        var aIndex = 0
        var bIndex = 0
        fun addToHeap(it: Int) {
            heapLeft.add(it)
            if ((heapLeft.size - heapRight.size) == 2) {
                heapRight.add(heapLeft.poll())
            }
        }

        while (aIndex < a.size && bIndex < b.size) {
            addToHeap(a[aIndex++])
            addToHeap(b[bIndex++])
        }

        while (aIndex < a.size) addToHeap(a[aIndex++])
        while (bIndex < b.size) addToHeap(b[bIndex++])

        var result = if ((heapLeft.size - heapRight.size) == 1) {
            if (heapRight.size > heapLeft.size)
                heapRight.peek().toDouble()
            else
                heapLeft.peek().toDouble()
        } else {
            (heapRight.peek() + heapLeft.peek()) / 2.0
        }

        return result

    }


    private val queue = PriorityQueue<MyArray>()

    /**
     * Accepted Solutions Runtime Distribution
     */
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val sum = nums1.size + nums2.size
        val count = sum / 2 - 1
        if (nums1.isNotEmpty()) {
            queue.add(MyArray(nums1))
        }
        if (nums2.isNotEmpty()) {
            queue.add(MyArray(nums2))
        }
        for (i in 0 until count) {
            moveNext()
        }
        if (sum % 2 == 1) {
            if (sum > 2) {
                moveNext()
            }
            return queue.remove().get();
        }
        val last = queue.peek().get()
        moveNext()
        return (last + queue.remove().get()) / 2
    }

    private fun moveNext() {
        val arr = queue.remove()
        if (arr.index + 1 < arr.nums.size) {
            arr.index++
            queue.offer(arr)
        }
    }

    class MyArray(val nums: IntArray) : Comparable<MyArray> {
        var index = 0

        override fun compareTo(other: MyArray): Int {
            return nums[index] - other.nums[other.index]
        }

        fun get(): Double {
            return nums[index].toDouble()
        }
    }


    /**
     *
     * Accepted Solutions Memory Distribution
     */

    fun findMedianSortedArraysBestWithSpace(a: IntArray, b: IntArray): Double {
        val totalSize = a.size + b.size
        val med = (totalSize) / 2

        val arr = IntArray(totalSize) { 0 }

        var leftIndex = 0
        var rightIndex = 0
        while (leftIndex < a.size && rightIndex < b.size) {
            if (a[leftIndex] < b[rightIndex]) {
                arr[leftIndex + rightIndex] = a[leftIndex]
                leftIndex += 1
            } else {
                arr[leftIndex + rightIndex] = b[rightIndex]
                rightIndex += 1
            }
        }
        while (leftIndex < a.size) {
            arr[leftIndex + rightIndex] = a[leftIndex]
            leftIndex += 1
        }
        while (rightIndex < b.size) {
            arr[leftIndex + rightIndex] = b[rightIndex]
            rightIndex += 1
        }

        return if (totalSize % 2 == 1) {
            arr[med].toDouble()
        } else {
            (arr[med].toDouble() + arr[med - 1].toDouble()) / 2
        }
    }


}
package practice.sorting

import com.sun.jdi.connect.Connector.IntegerArgument
import java.util.*
import kotlin.collections.ArrayList


/**
 *
 * ### [347. Top K Frequent Elements](https://leetcode.com/problems/top-k-frequent-elements/)
 *
 * ### Top K Frequent Elements
 *
 * Given an integer array and a number k, find the k most frequent elements in the array.
 *
 * ### Example One
 * ````
 * {
 *      "arr": [1, 2, 3, 2, 4, 3, 1],
 *      "k": 2
 * }
 * ````
 * ### Output: `[3, 1]`
 *
 * ### Example Two
 * ````
 * {
 *      "arr": [1, 2, 1, 2, 3, 1],
 *      "k": 1
 * }
 * ````
 * ### Output: `[1]`
 *
 * ### Notes
 * - If multiple answers exist, return any.
 * - The order of numbers in the output array does not matter.
 *
 * Constraints:
 *
 * - 1 <= length of the given array <= 3 * 105
 * - 0 <= array element <= 3 * 105
 * - 1 <= k <= number of unique elements in the array
 */

fun main() {

    val x = 0
    if(x == 0 ){
        val x = 5
        println(x)
    }else println("Y")

    println("13" + 5 + 3)



    val nums = intArrayOf(1, 1, 1, 2, 2, 3, 3, 3, 3, 3, 3, 3, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6)
    val map = mutableMapOf<Int, Int>()

    for (num in nums) {
        map[num] = map.getOrDefault(num, 0) + 1
    }

    val queue = PriorityQueue<Int> { n1, n2 -> map.getOrDefault(n2, 0) - map.getOrDefault(n1, 0) }


    for (num in map.keys) queue.add(num)

    println(queue)


    val topKFrequentElements = TopKFrequentElements()
    //@formatter:off
    val output = topKFrequentElements.findKFrequentElements_Approach_2(arrayListOf(1, 1, 1, 2, 2, 3, 3, 3, 3, 3, 3, 3, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6,), 3)
    //@formatter:on


    println(output)
}


class TopKFrequentElements {

    fun findKFrequentElements(input: ArrayList<Int>, k: Int): ArrayList<Int> {

        val hash = mutableMapOf<Int, Int>()

        input.forEach {
            hash[it] = (hash.getOrDefault(it, 0)) + 1
        }
        val sorted =
            hash.entries.sortedWith { a: Map.Entry<Int, Int>, b: Map.Entry<Int, Int> -> b.value.compareTo(a.value) }
                .associate { it.toPair() }

        var kCounter = k
        val itr = sorted.iterator()
        val output = arrayListOf<Int>()

        while (kCounter-- > 0) {
            output.add(itr.next().key)
        }

        return output
    }


    fun findKFrequentElements_Approach_2(nums: ArrayList<Int>, k: Int): IntArray {


        val freqMap = HashMap<Int, Int>()
        for (num in nums) {
            freqMap[num] = freqMap.getOrDefault(num, 0) + 1
        }

        val queue = PriorityQueue<Int> { n1, n2 -> freqMap.getOrDefault(n2, 0) - freqMap.getOrDefault(n1, 0) }

        for (num in freqMap.keys) queue.add(num)

        val result = IntArray(k)
        for (i in 0 until k) {
            result[i] = queue.remove()
        }

        return result

    }

    fun topKFrequent(nums: IntArray, k: Int): IntArray {

        val map = mutableMapOf<Int, Int>()
        val ans = IntArray(k)
        for (num in nums) {
            map[num] = map.getOrDefault(num, 0) + 1
        }

        val minHeap = PriorityQueue<Pair<Int, Int>>() { a, b -> a.first - b.first }

        for ((num, fre) in map) {

            minHeap.offer(Pair(fre, num))

            if (minHeap.size > k) {
                minHeap.poll()
            }

        }

        var count = 0
        while (!minHeap.isEmpty()) {

            ans[count] = minHeap.peek().second
            count++
            minHeap.poll()

        }

        return ans
    }


    /*
    Approach 3
     */


    class PairComparator : Comparator<Pair<Int, Int>> {
        override fun compare(a: Pair<Int, Int>, b: Pair<Int, Int>): Int {
            return a.first - b.first
        }
    }


    fun topKFrequentApproach_3(nums: IntArray, k: Int): IntArray {

        val map = HashMap<Int, Int>()
        val ans = IntArray(k) { -1 }


        val heap = PriorityQueue<Pair<Int, Int>>(k, PairComparator())

        for ((num, fre) in map) {
            heap.offer(Pair(fre, num))
            if (heap.size > k) {
                heap.poll()
            }
        }

        var count = 0
        while (!heap.isEmpty()) {
            ans[count++] = heap.poll().second
        }

        return ans
    }

}




package practice.leetcode

import java.util.*


/**
 * ##[1094. Car Pooling](https://leetcode.com/problems/car-pooling/)
 */


//trips[0] = [numPassengers, from, to]

fun main() {


    var output = CarPooling().carPooling(arrayOf(intArrayOf(2, 1, 5), intArrayOf(3, 3, 7)), 4)
    println("Can do All Trips : $output")
    output = CarPooling().carPooling(arrayOf(intArrayOf(2, 1, 5), intArrayOf(3, 3, 7)), 5)
    println("Can do All Trips : $output")
    output = CarPooling().carPooling(arrayOf(intArrayOf(2, 1, 5), intArrayOf(3, 5, 7)), 3)
    println("Can do All Trips : $output")
    output = CarPooling().carPooling(arrayOf(intArrayOf(3, 2, 7), intArrayOf(3, 7, 9), intArrayOf(8, 3, 9)), 11)
    println("Can do All Trips : $output")

    output = CarPooling().carPooling(
        arrayOf(
            intArrayOf(9, 3, 4),
            intArrayOf(9, 1, 7),
            intArrayOf(4, 2, 4),
            intArrayOf(7, 4, 5)
        ), 23
    )
    println("TRUE Expected - Can do All Trips : $output")



    println("False Expected - Can do All Trips : $output")

//    [[9,3,4],[9,1,7],[4,2,4],[7,4,5]] , 23
}


const val passenger = 0
const val start = 1
const val end = 2

class CarPooling {

  fun carPooling_Approach1(trips: Array<IntArray>, capacity: Int): Boolean {
      val arr = IntArray(1001) { 0 }

      for (trip in trips) {
          val nPassengers = trip[0]
          val start = trip[1]
          val end = trip[2]

          arr[start] = nPassengers + arr[start]
          arr[end] = -nPassengers + arr[end]
      }

      var currentPassengers = 0
      for (capPeople in arr) {
          currentPassengers += capPeople
          if (currentPassengers > capacity) return false
      }

      return true
  }


    fun carPooling_Approach2(trips: Array<IntArray>, capacity: Int): Boolean {
        return carPooling(trips, capacity, 0)
    }

    private val arr = IntArray(1001) { 0 }
    fun carPooling(trips: Array<IntArray>, capacity: Int, pointer: Int): Boolean {

        if (pointer == trips.size) return checkCapacity(capacity)

        val (nPassengers, start, end) = trips[pointer]
        arr[start] = nPassengers + arr[start]
        arr[end] = -nPassengers + arr[end]

        return if (arr[start] > capacity) false
        else carPooling(trips, capacity, pointer + 1)

    }

    private fun checkCapacity(capacity: Int): Boolean {
        var currentPassengers = 0
        for (capPeople in arr) {
            currentPassengers += capPeople
            if (currentPassengers > capacity) return false
        }

        return true
    }


    private val map = hashMapOf<Int, Int>()

    private fun carPool(trips: Array<IntArray>, capacity: Int, pointer: Int): Boolean {

        if (pointer == trips.size) return checkMapCapacity(capacity)

        val trip = trips[pointer]
        val nPassengers = trip[0]
        val start = trip[1]
        val end = trip[2]

        map[start] = nPassengers + map.getOrDefault(start, 0)
        map[end] = -nPassengers + map.getOrDefault(end, 0)

        if (map[start]!! > capacity)
            return false

        return carPool(trips, capacity, pointer + 1)
    }

    private fun checkMapCapacity(capacity: Int): Boolean {
        var cabPeople = 0

        val itr = map.iterator()

        while (itr.hasNext()) {
            cabPeople += itr.next().value
            if (cabPeople > capacity) return false
        }

        return true
    }

    fun carPooling(trips: Array<IntArray>, capacity: Int): Boolean {
        return carPool(trips, capacity, 0)
    }


}
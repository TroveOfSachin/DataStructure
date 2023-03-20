package practice.sorting

import print


/**
 * ### Problem
 *
 * ### Intersection Of Three Sorted Arrays
 * Given three arrays sorted in the ascending order, return their intersection sorted array in the ascending order.
 *
 * #### Example One
 * ````
 * {
 * "arr1": [2, 5, 10],
 * "arr2": [2, 3, 4, 10],
 * "arr3": [2, 4, 10]
 * }
 * ````
 * #### Output:
 * ````
 * [2, 10]
 * ````
 *
 * #### Example Two
 * ````
 * {
 * "arr1": [1, 2, 3],
 * "arr2": [],
 * "arr3": [2, 2]
 * }
 * ````
 * #### Output:
 *````
 * [-1]
 * ````
 * #### Example Three
 * ````
 * {
 * "arr1": [1, 2, 2, 2, 9],
 * "arr2": [1, 1, 2, 2],
 * "arr3": [1, 1, 1, 2, 2, 2]
 * }
 * ````
 * #### Output:
 * ````
 * [1, 2, 2]
 * ````
 * ### Notes
 * - If the intersection is empty, return an array with one element -1.
 * ### Constraints:
 *
 * - 0 <= length of each given array <= 105
 * - 0 <= any value in a given array <= 2 * 106
 */


fun main() {
    var arr1 = arrayListOf(1, 2, 3)
    var arr2 = arrayListOf<Int>()
    var arr3 = arrayListOf(1, 1, 1, 2, 2, 2)

//    var result = IntersectionOfThreeArray().findIntersectionWay1(arr1, arr2, arr3)
//
//    result.print("Output")

    var result = IntersectionOfThreeArray().findIntersectionWay2(arr1, arr2, arr3)

    result.print("Output")

}

class IntersectionOfThreeArray {


    fun findIntersectionWay1(arr1: ArrayList<Int>, arr2: ArrayList<Int>, arr3: ArrayList<Int>): ArrayList<Int> {
        var result = find(arr1, arr2)
        if (result.isEmpty()) return arrayListOf(-1)
        result = find(result, arr3)
        if (result.isEmpty())  result = arrayListOf(-1)
        return result
    }

    fun find(arr1: ArrayList<Int>, arr2: ArrayList<Int>): ArrayList<Int> {

        val output = arrayListOf<Int>()

        var fStart = 0
        var sStart = 0

        while (fStart < arr1.size && sStart < arr2.size) {

            if (arr1[fStart] == arr2[sStart]) {
                output.add(arr1[fStart])
                fStart++
                sStart++
            } else if (arr1[fStart] < arr2[sStart]) fStart++
            else sStart++
        }

        return output
    }


    fun findIntersectionWay2(arr1: ArrayList<Int>, arr2: ArrayList<Int>, arr3: ArrayList<Int>): ArrayList<Int> {

        var a = 0;
        var b = 0;
        var c = 0;

        val output = ArrayList<Int>()
        while (a < arr1.size && b < arr2.size && c < arr3.size) {
            if (arr1[a] == arr2[b] && arr2[b] == arr3[c]) {
                output.add(arr1[a]);
            }

            val min = minOf(arr1[a], arr2[b], arr3[c])
            if (min == arr1[a]) a++
            if (min == arr2[b]) b++
            if (min == arr3[c]) c++
        }

        if (output.isEmpty()) output.add(-1)
        return output
    }


}
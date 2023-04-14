package practice.pc

import kotlin.math.round


/**
 * #### Permute Array Of Integers Duplicates Allowed
 * Given an array of numbers with possible duplicates, return all of its permutations in any order.
 * ````
 * Example
 * {
 *  "arr": [1, 2, 2]
 * }
 * Output:
 *
 * [
 *  [1, 2, 2],
 *  [2, 1, 2],
 *  [2, 2, 1]
 * ]
 * ````
 * #### Notes
 * #### Constraints:
 * - 1 <= size of the input array <= 9
 * - 0 <= any array element <= 9
 */


fun main() {


//    fun solution(prices: MutableList<Double>, notes: MutableList<String>, x: Double): Boolean {
//        var payment = 0.0
//        prices.forEachIndexed { index, price ->
//
//            if (notes[index] != "Same as in-store") {
//
//                var note = notes[index].split(" ")
//
//                val salePricePercentile = note[0].dropLast(1).toDouble()
//                var status = note[1].trim()
//
//                var inStorePrice = (price / (1 + round(salePricePercentile / 100))).toFloat()
//
//                val extraPayment = price - inStorePrice
//
//                if (status == "higher")
//                    payment += extraPayment
//                else
//                    payment -= extraPayment
//
//            }
//
//        }
//        return payment <= x
//    }



    fun solution(prices: DoubleArray, notes: Array<String>, x: Double): Boolean {
        var overpayment = 0.0
        for (i in prices.indices) {
            if(notes[i] != "Same as in-store") {
                val percent = (notes[i].split(" ")[0].replace("%", "")).toDouble() / 100.0
                val inStorePrice = prices[i] / (1 + percent)
                val difference = prices[i] - inStorePrice
                overpayment += difference
            }
        }
        return overpayment <= x
    }


    val out = solution(
        doubleArrayOf(110.0, 95.0, 70.0), arrayOf(
            "10.0% higher than in-store",
            "5.0% lower than in-store",
            "Same as in-store"
        ), 5.0
    )

    println(out)

}


class PermuteArrayOfInteger {
    fun getPermutations(arr: ArrayList<Int>?): ArrayList<ArrayList<Int>>? {
        val result = ArrayList<ArrayList<Int>>()

        return result
    }


    fun cal(arr: ArrayList<Int>, start: Int): ArrayList<ArrayList<Int>> {
        if (start == arr.size) return arrayListOf()




        return arrayListOf()
    }
}
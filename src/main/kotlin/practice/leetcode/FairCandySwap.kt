package practice.leetcode

import print
import java.util.*


/**
 * [888. Fair Candy Swap](https://leetcode.com/problems/fair-candy-swap/description/)
 */


fun main() {

    val alice = intArrayOf(1, 3, 4, 2, 2)

    val bob = intArrayOf(3, 2, 5, 1)
    val output = FairCandySwap().minCost(alice, bob)
    println("Output : $output")
}


class FairCandySwap {
    fun fairCandySwap(aliceSizes: IntArray, bobSizes: IntArray): IntArray {

        val aliceSum = aliceSizes.sum()
        val bobSum = bobSizes.sum()
        val sumDiff = (aliceSum + bobSum) / 2
        val aliceSet = aliceSizes.toHashSet()

        for (bob in bobSizes) {
            val alice = sumDiff - (bobSum - bob)
            if (aliceSet.contains(alice))
                return intArrayOf(alice, bob)
        }

        return intArrayOf()
    }

    fun minCost(basket1: IntArray, basket2: IntArray): Long {
        val totalCost1 = basket1.sum()
        val totalCost2 = basket2.sum()

        // If the total cost of both baskets is not equal, it is impossible to make both baskets equal
        if (totalCost1 != totalCost2) {

            val t = TreeSet((1..1000).toList())
            t.pollFirst()



            return -1
        }

        var cost = 0
        var diff = 0
        val freq1 = HashMap<Int, Int>()
        for (fruit in basket1) {
            freq1[fruit] = freq1.getOrDefault(fruit, 0) + 1
        }
        val freq2 = HashMap<Int, Int>()
        for (fruit in basket2) {
            freq2[fruit] = freq2.getOrDefault(fruit, 0) + 1
        }

        // For each unique fruit, find the difference in frequency between both baskets and add the minimum cost of swapping
        for (fruit in (basket1 + basket2).distinct()) {
            diff = Math.abs((freq1[fruit] ?: 0) - (freq2[fruit] ?: 0))
            if (diff % 2 == 1) {
                // If the difference in frequency is odd, it is impossible to make both baskets equal
                return -1
            }
            cost += (diff / 2) * Math.min(
                fruit,
                Math.min(basket1.minOf { if (it == fruit) Int.MAX_VALUE else it },
                    basket2.minOf { if (it == fruit) Int.MAX_VALUE else it })
            )
        }

        return cost.toLong()
    }
}
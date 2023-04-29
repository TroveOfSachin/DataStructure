package practice.code_signal

import java.math.BigDecimal

/**
 *
 */
class FindTheOverPayment {

    fun solution(prices: MutableList<Double>, notes: MutableList<String>, x: Double): Boolean {
        val prices1 = prices.map { it.toFloat() }
        var overpayment = 0.0f
        for (i in prices1.indices) {
            if (notes[i] != "Same as in-store") {
                val note = notes[i].split(" ")
                val percent = (note[0].dropLast(1)).toFloat()

                if(note[1] == "higher"){
                    val inStorePrice = (prices1[i] / (1.0f + percent / 100.0f))
                    val difference = (prices1[i] - inStorePrice)
                    overpayment += difference
                }else{
                    val inStorePrice = (prices1[i] / (1.0f - percent / 100.0f))
                    val difference = inStorePrice - prices1[i]
                    overpayment -= difference
                }
            }
        }
        return overpayment <= x
    }
}

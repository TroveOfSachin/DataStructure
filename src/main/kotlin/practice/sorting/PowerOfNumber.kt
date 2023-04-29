package practice.sorting


/**
 * Power
 * Given a base a and an exponent b. Your task is to find a^b. The value could be large enough. So, calculate a^b % 1000000007.
 *
 * Example
 * {
 * "a": 2,
 * "b": 10
 * }
 * Output:
 *
 * 1024
 * Notes
 * Constraints:
 *
 * 0 <= a <= 104
 * 0 <= b <= 109
 * a and b together won't be 0
 */

fun main() {
    val output = PowerOfNumber().calculate_power(31, 100)
    println("Power = $output")
}

class PowerOfNumber {

    val MOD = 1000000007

//    fun power(base: Int, exponent: Int): Any {
//        if (exponent == 0) return 1 % MOD
//        return (base * power(base, exponent - 1)) % MOD
//    }

    fun calculate_power(a: Long, b: Long): Int {
        return calculatePower(a, b).toInt()
    }


    fun calculatePower(a: Long, b: Long): Long {

        val base = a % MOD
        if (a == 0L) return 0

        if (b == 0L) return 1
        if (b == 1L) return (base % MOD)

        val output = calculatePower(base, b / 2)

        return if (b % 2 == 0L) {
            (output * output % MOD)
        } else {
            (((output * output % MOD) * a) % MOD)
        }
    }

}
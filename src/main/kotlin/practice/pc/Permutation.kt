package practice.pc

import permuteWithRepetition
import permuteWithoutRepetition
import print


fun main() {
    val x = arrayListOf(1, 2, 2)
//    x.permuteWithRepetition(3).print("Output with Repetition")
//
    x.permuteWithoutRepetition().print("Output without Repetition")
//
//
    val output =  Permutation().createPermutationWithSelf(arrayListOf(1,2,2), 3)
    output.print("Output Custom")

//    Permutation().pinCode(2)
}

class Permutation {

    fun pinCode(n: Int) {
        fun pinHelper(prefix: String, n: Int) {
            if (n == 0)
                print("$prefix, ")
            else {
                for (i in 0..5) {
                    pinHelper("$prefix$i", n - 1)
                }
            }
        }

        pinHelper("", n)
    }


    fun createPermutationWithSelf(arr: List<Int>, numberOfPlaces: Int): ArrayList<String> {
        val num = arr.size
        val output = arrayListOf<String>()
        fun helper(n: Int, s: String) {
            if (n == 0) {
                output.add(s)
            } else {
                for (i in 0 until num)
                    helper(n - 1, "$s${arr[i]}")
            }

        }

        helper(numberOfPlaces, "")

        return output
    }

    fun <T> List<T>.permuteWithoutRepetition(): List<List<T>> =
        when {
            isEmpty() -> listOf(emptyList())
            size == 1 -> listOf(this)
            else -> flatMap { element ->
                val remainingElements = this - element
                remainingElements.permuteWithoutRepetition().map { permutation -> listOf(element) + permutation }
            }
        }


    fun <T> List<T>.permuteWithRepetition(length: Int): List<List<T>> {
        if (length == 0) {
            return listOf(emptyList())
        }
        return flatMap { element ->
            val permutations = permuteWithRepetition(length - 1)
            permutations.map { it + element }
        }
    }


}



/*

    x + x *(y /100) = a
    x + xy/100 = a
    x (1+ y/ 100) = a
    x = a / (1+y/100)
    x = 100 / (1 + 10/100)



 */

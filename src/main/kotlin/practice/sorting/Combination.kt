package practice.sorting

import print


fun main() {
    val output = Combination().createCombinationWithAndWithoutSelf(intArrayOf(1, 2, 3))
    output.print("Output")
}
class Combination {

    fun createCombinationWithAndWithoutSelf(arr: IntArray): ArrayList<String> {
        val num = 4
        val output = arrayListOf<String>()
        fun helper(n: Int, s: String) {
            if (n == 1) {
                output.add(("${s}0"))
                output.add(("${s}1"))
            } else {
                helper(n - 1, "${s}0")
                helper(n - 1, "${s}1")
            }

        }

        helper(num, "")

        return output
    }


}
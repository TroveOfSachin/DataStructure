package practice.leetcode


/**
 * #### [990. Satisfiability of Equality Equations] (https://leetcode.com/problems/satisfiability-of-equality-equations/description/)
 */
fun main() {

    val input = arrayOf("a==b", "b!=c", "c==a")

    println("Stability : ${SatisfiabilityOfEqualityEquations().equationsPossible(input)}")
}


class SatisfiabilityOfEqualityEquations {

    fun equationsPossible(equations: Array<String>): Boolean {

        // initialize all the alphabet values through it indices
        val values = IntArray(26) { it }

        for (eq in equations) {
            if (eq[1] == '=') {
                val var1 = eq[0] - 'a'
                val var2 = eq[3] - 'a'
                union(var1, var2, values)
            }
        }
        for (eq in equations) {
            if (eq[1] == '!') {
                val var1 = eq[0] - 'a'
                val var2 = eq[3] - 'a'
                val var1V = find(var1, values)
                val var2V = find(var2, values)
                if (var1V == var2V) {
                    return false
                }
            }
        }
        return true

    }

    private fun union(var1: Int, var2: Int, values: IntArray) {
        val root1 = find(var1, values)
        val root2 = find(var2, values)
        values[root2] = root1
    }

    private fun find(variable: Int, values: IntArray): Int {
        var varIndex = variable
        while (values[varIndex] != varIndex) {
            varIndex = values[varIndex]
        }
        return varIndex
    }
}
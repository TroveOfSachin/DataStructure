package practice.pc

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



    fun getDistinctSubsets(str: String): ArrayList<String> {
        // Write your code here.

        val res = mutableSetOf<String>()
        val s = String(str.toCharArray().sortedArray())
        fun findSubset(start:Int, sb:StringBuilder){
            if(start == s.length) {
                return
            }

            for(i in start until s.length){
                sb.append(s[i])
                res.add(sb.toString())
                findSubset(i+1, sb)
                sb.deleteAt(sb.length-1)
            }

        }

        findSubset(0, StringBuilder(""))


        return ArrayList(res)
    }



}
package practice.leetcode


/**
 * #### [1557. Minimum Number of Vertices to Reach All Nodes](https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes/)
 */

fun main() {
    val inputList = listOf(
        listOf(0, 1),
        listOf(0, 2),
        listOf(2, 5),
        listOf(3, 4),
        listOf(4, 2)
    )

    MinimumNumberOfVerticesToReachAllNodes().findSmallestSetOfVertices(6, inputList)

}

class MinimumNumberOfVerticesToReachAllNodes {

    fun findSmallestSetOfVertices(n: Int, edges: List<List<Int>>): List<Int> {


        val s: MutableSet<Int> = HashSet()
        for (e in edges) {
            s.add(e[1])
        }
        val ans: MutableList<Int> = ArrayList()
        for (i in 0 until n) {
            if (!s.contains(i)) {
                ans.add(i)
            }
        }
        return ans
    }
}
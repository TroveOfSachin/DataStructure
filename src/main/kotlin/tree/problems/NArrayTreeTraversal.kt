package tree.problems

import print
import tree.base.BinaryTreeNode
import tree.base.MultiTreeNode
import tree.base.SampleTreeData

/**
 *
 */

fun main() {

    fun getDistinctElementCounts(arr: IntArray): Map<Int, List<Int>> {
        val grouped = arr.withIndex().groupBy { it.value }
        return grouped.mapValues { it.value.map { it.index } }
    }


    val arr = intArrayOf(1, 2, 3, 2, 4, 1, 5, 5, 6, 1)
    val distinctCounts = getDistinctElementCounts(arr)
    println(distinctCounts)

}

class NArrayTreeTraversal {

    fun preorder(root: MultiTreeNode?): List<Int> {

        fun traverse(root: MultiTreeNode?, output: ArrayList<Int>) {
            if (root == null) return
            output.add(root.value)
            root.childrens?.let {
                it.forEach { child ->
                    traverse(child, output)
                }
            }
        }

        val output = arrayListOf<Int>()

        traverse(root, output)
        return output


    }
}
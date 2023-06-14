package practice.leetcode

import tree.base.BinaryTreeNode
import java.lang.Math.abs
import java.util.PriorityQueue
import kotlin.random.Random


class Solution530 {
    fun getMinimumDifference(root: BinaryTreeNode?): Int {
        var res = Int.MAX_VALUE
        fun dfs(node:BinaryTreeNode?){
            if(node == null) return

            node.left?.let{
                res = minOf(res, abs(node.value - it.value))
                dfs(it)
            }
            if(res == 1) return
            node.right?.let{
                res = minOf(res, abs(it.value - node.value))
                dfs(it)
            }
            if(res == 1) return

        }
        dfs(root)
        return res
    }
}
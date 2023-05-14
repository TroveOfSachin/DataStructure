package tree.problems

import tree.base.BinaryTreeNode
import tree.base.SampleTreeData

fun main() {
    val root = SampleTreeData.getTreeAsNode()
    val output = RootToLeafPathSumEqualToK().pathSum(root, -103)
    println("Root To Leaf Path Sum Equal To K Possible? : $output")
}

class RootToLeafPathSumEqualToK {
    fun pathSum(root: BinaryTreeNode?, k: Int): Boolean {
        fun findSum(node: BinaryTreeNode?, sum: Long, target:Long): Boolean {
            if (node == null) return false

            if (node.left == null && node.right == null) return (sum + node.value == target)

            return findSum(node.left, sum + node.value, target) || findSum(node.right, sum + node.value, target)

        }

        return findSum(root, 0L, k.toLong())
    }
}
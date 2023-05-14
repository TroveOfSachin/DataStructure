package practice.leetcode

import print
import tree.base.BinaryTreeNode
import tree.base.SampleTreeData
import java.util.*

/**
 * [103. Binary Tree Zigzag Level Order Traversal](https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/)
 */

fun main() {
    val root = SampleTreeData.getTreeAsNode()
    val output = BinaryTreeZigZagTraversal().zigzagLevelOrder(root)
    output.print("LevelOrder Traversal")
}

class BinaryTreeZigZagTraversal {
    fun zigzagLevelOrder(root: BinaryTreeNode?): ArrayList<ArrayList<Int>> {
        val result = ArrayList<ArrayList<Int>>()
        if (root == null) return result


        val queue: Deque<BinaryTreeNode> = LinkedList()
        queue.add(root)
        queue.toList()
        var isLeftToRight = true
        while (queue.isNotEmpty()) {
            var qSize = queue.size
            val level = ArrayList<Int>()

            while (qSize > 0) {
                val node = queue.poll()

                level.add(node.value)


                node.left?.let { queue.offer(node.left) }
                node.right?.let { queue.offer(node.right) }
                qSize--

            }
            if (!isLeftToRight)
                level.reverse()
            result.add(level)
            isLeftToRight = !isLeftToRight
        }

        return result
    }
}
package tree.problems

import tree.base.BinaryTreeNode
import tree.base.SampleTreeData
import java.util.*

fun main() {


    val root = SampleTreeData.getTreeAsNode()

    val res = MirrorOfTree().mirror(root)
    println(res)
}

class MirrorOfTree {

    fun mirror(root: BinaryTreeNode?): BinaryTreeNode? {
        if (root == null) return null
        fun preOrderTraversal(
            node: BinaryTreeNode?,
            mirror: BinaryTreeNode?,
        ) {

            maxOf(1, 3)

            if (node == null || mirror == null)
                return

//            mirror.left = if (node.left == null) null else BinaryTreeNode(node.left!!.value)
//            mirror.right = if (node.right == null) null else BinaryTreeNode(node.right!!.value)

            node.left?.let {
                mirror.left = BinaryTreeNode(it.value)
                preOrderTraversal(node.left, mirror.left)
            }
            node.right?.let {
                mirror.right = BinaryTreeNode(it.value)
                preOrderTraversal(node.right, mirror.right)
            }

        }

        var mirror: BinaryTreeNode? = BinaryTreeNode(root.value)
        preOrderTraversal(root, mirror)



        return mirror

    }
}
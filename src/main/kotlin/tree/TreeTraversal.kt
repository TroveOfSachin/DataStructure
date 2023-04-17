package tree

import print
import kotlin.collections.ArrayList

fun main() {
    val root = SampleTreeData.getTreeAsNode()
    var output = TreeTraversal().preOrder(root)
    output.print("PreOrder Traversal")
    output = TreeTraversal().inOrder(root)
    output.print("PreOrder Traversal")
    output = TreeTraversal().postOrder(root)
    output.print("PostOrder Traversal")
}


class TreeTraversal {

    fun preOrder(root: BinaryTreeNode?): ArrayList<Int> {

        fun traverse(root: BinaryTreeNode?, output: ArrayList<Int>): ArrayList<Int> {
            if (root == null) return output
            output.add(root.key)
            traverse(root.left, output)
            traverse(root.right, output)
            return output
        }
        return traverse(root, arrayListOf())
    }

    fun inOrder(root: BinaryTreeNode?): ArrayList<Int> {

        fun traverse(root: BinaryTreeNode?, output: ArrayList<Int>): ArrayList<Int> {
            if (root == null) return output

            traverse(root.left, output)
            output.add(root.key)
            traverse(root.right, output)
            return output
        }
        return traverse(root, arrayListOf())
    }

    fun postOrder(root: BinaryTreeNode?): ArrayList<Int> {

        fun traverse(root: BinaryTreeNode?, output: ArrayList<Int>): ArrayList<Int> {
            if (root == null) return output

            traverse(root.left, output)
            traverse(root.right, output)
            output.add(root.key)
            return output
        }
        return traverse(root, arrayListOf())
    }
}
package tree.problems

import tree.base.BTreePrinter
import tree.base.BinaryTreeNode
import tree.base.SampleTreeData


fun main() {

    val root = SampleTreeData.getTreeAsNode()
    val k = root?.left

    BTreePrinter.printNode(root)

//    var output = SuccessorPredecessor().findSuccessor(root, k!!)
//    println("Successor of ${k.key} = ${output?.key}")
    var output = SuccessorPredecessor().findPredecessor(root, k!!)
    println("Predecessor of ${k.key} = ${output?.key}")

}


class SuccessorPredecessor {

    fun findSuccessor(root: BinaryTreeNode?, k: BinaryTreeNode): BinaryTreeNode? {

        if (root == null) return null

        // checking right half as smallest element in the right of TreeNode is successor
        if (k.right != null) {
            var curr = k.right
            while (curr?.left != null)
                curr = curr.left

            return curr
        }

        // checking if right is null and parents available
        // try and find the k element in the TreeNode
        // while finding the element make sure you have tracked of ancestor where ancestor is left node of parent


        var ancestor: BinaryTreeNode? = null
        var current = root
        while (current?.key != k.key) {
            if (k.key < current?.key!!) {
                ancestor = current
                current = current.left

            } else {
                current = current.right
            }
        }

        return ancestor


    }


    fun findPredecessor(root: BinaryTreeNode?, k: BinaryTreeNode): BinaryTreeNode? {

        if (root == null) return null

        // checking right half as smallest element in the right of TreeNode is successor
        if (k.left != null) {
            var curr = k.left
            while (curr?.right != null)
                curr = curr.right

            return curr
        }

        // checking if right is null and parents available
        // try and find the k element in the TreeNode
        // while finding the element make sure you have tracked of ancestor where ancestor is left node of parent

        var ancestor: BinaryTreeNode? = null
        var current = root
        while (current!=null && current.key != k.key) {
            if (k.key > current?.key!!) {
                ancestor = current
                current = current.right

            } else {
                current = current.left
            }
        }

        return ancestor

    }


}




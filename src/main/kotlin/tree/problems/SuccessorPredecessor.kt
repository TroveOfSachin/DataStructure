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
    println("Predecessor of ${k.value} = ${output?.value}")

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
        while (current?.value != k.value) {
            if (k.value < current?.value!!) {
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
        while (current != null && current.value != k.value) {
            if (k.value > current?.value!!) {
                ancestor = current
                current = current.right

            } else {
                current = current.left
            }
        }

        return ancestor

    }


    var foundA = false
    var foundB = false

    fun lca(root: BinaryTreeNode?, a: BinaryTreeNode?, b: BinaryTreeNode?): Int {
        if (root == null || a == null || b == null) {
            return 0
        }

        val pathToAorB = ArrayList<Pair<Int, Boolean>>()
        preorder(root, a.value, b.value, pathToAorB)

        var lca: Int = 0
        var i = 0
        while (i < pathToAorB.size && pathToAorB[i].second) {
            lca = pathToAorB[i].first
            i++
        }

        return lca
    }

    var lca = true

    private fun preorder(node: BinaryTreeNode, a: Int, b: Int, pathToAOrB: ArrayList<Pair<Int, Boolean>>) {

        if (foundA && foundB) {
            return
        }

        pathToAOrB.add(node.value to lca)


        if (node.value == a) {
            foundA = true
            lca = false
        }
        if (node.value == b) {
            foundB = true
            lca = false
        }

        if (node.left != null) {
            preorder(node.left!!, a, b, pathToAOrB)
        }
        if (node.right != null) {
            preorder(node.right!!, a, b, pathToAOrB)
        }
        if (!foundA || !foundB) {
            pathToAOrB.removeAt(pathToAOrB.size - 1)
        }
    }


}




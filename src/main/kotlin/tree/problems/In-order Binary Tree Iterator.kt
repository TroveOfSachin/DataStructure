package tree.problems

import print
import tree.base.BinaryTreeNode
import tree.base.SampleTreeData


fun main() {

    val root = SampleTreeData.getTreeAsNode()
    val operations = arrayListOf("next", "has_next", "next", "next", "has_next", "has_next", "next")
    val res = implement_tree_iterator(root, operations)
    res.print("Output")


}

class TreeIterator(root: BinaryTreeNode?) {

    private val queue = ArrayDeque<Int>()

    private fun inOrderTravel(root: BinaryTreeNode?, queue: ArrayDeque<Int>) {
        if (root == null) return
        root.left?.let { inOrderTravel(root.left, queue) }
        queue.add(root.value)
        root.right?.let { inOrderTravel(root.right, queue) }
    }


    init {
        inOrderTravel(root, queue)
    }

    fun next(): Int {
        return if (queue.isEmpty()) 0 else queue.removeFirst()
    }

    fun hasNext(): Int {
        return if (queue.isNotEmpty()) 1 else 0
    }
}


fun implement_tree_iterator(root: BinaryTreeNode?, operations: ArrayList<String>): ArrayList<Int> {

    val ti = TreeIterator(root)
    val res = arrayListOf<Int>()

    for (op in operations) {
        when (op) {
            "next" -> res.add(ti.next())
            "has_next" -> res.add(ti.hasNext())
        }
    }

    return res
}


class `In-order Binary Tree Iterator` {


}
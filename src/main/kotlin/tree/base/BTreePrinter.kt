package tree.base

import java.util.*
import kotlin.collections.ArrayList

object BTreePrinter {
    fun printNode(root: BinaryTreeNode?) {
        val maxLevel = maxLevel(root)
        val sb = StringBuilder()
        printNodeInternal(Collections.singletonList(root), 1, maxLevel, sb)
        println(sb)
    }

    private fun printNodeInternal(nodes: List<BinaryTreeNode?>, level: Int, maxLevel: Int, sb: StringBuilder) {
        if (nodes.isEmpty() || isAllElementsNull(nodes)) return

        val floor = maxLevel - level
        val edgeLines = Math.pow(2.0, (floor - 1).toDouble()).toInt()
        val betweenSpaces = Math.pow(2.0, floor.toDouble()).toInt() - 1

        printWhitespaces((edgeLines - 1) / 2, sb)

        val newNodes: MutableList<BinaryTreeNode?> = ArrayList()
        for (node in nodes) {
            if (node != null) {
                sb.append(node.value)
                newNodes.add(node.left)
                newNodes.add(node.right)
            } else {
                newNodes.add(null)
                newNodes.add(null)
                sb.append(" ")
            }
            printWhitespaces(betweenSpaces, sb)
        }
        sb.append("\n")

        if (level < maxLevel) {
            printNodeInternal(newNodes, level + 1, maxLevel, sb)
        }
    }

    private fun printWhitespaces(count: Int, sb: StringBuilder) {
        for (i in 0 until count) {
            sb.append(" ")
        }
    }

    private fun maxLevel(node: BinaryTreeNode?): Int {
        return if (node == null) 0 else maxLevel(node.left).coerceAtLeast(maxLevel(node.right)) + 1
    }

    private fun <T> isAllElementsNull(list: List<T?>): Boolean {
        for (element in list) {
            if (element != null) {
                return false
            }
        }
        return true
    }
}
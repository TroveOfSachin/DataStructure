package practice.leetcode

import tree.base.BinaryTreeNode

/**
 * #### [156. Binary Tree Upside Down](https://leetcode.com/problems/binary-tree-upside-down/)
 */
class BinaryTreeUpsideDown {
    fun flipUpsideDown(
        root: BinaryTreeNode?,
        left: BinaryTreeNode? = null,
        right: BinaryTreeNode? = null
    ): BinaryTreeNode? {
        if (root == null) return null
        val (curLeft, curRight) = root.left to root.right

        root.left = left
        root.right = right
        if (curLeft == null && curRight == null)
            return root
        return flipUpsideDown(curLeft, curRight, root)
    }
}
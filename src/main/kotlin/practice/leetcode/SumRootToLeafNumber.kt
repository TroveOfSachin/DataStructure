package practice.leetcode


import tree.base.BinaryTreeNode
import tree.base.MultiTreeNode
import tree.base.SampleTreeData
import java.util.*
import kotlin.collections.ArrayList

/**
 * #### [129. Sum Root to Leaf Numbers](https://leetcode.com/problems/sum-root-to-leaf-numbers/)
 * Difficulty: Medium
 *
 * You are given the root of a binary tree containing digits from 0 to 9 only.
 *
 * Each root-to-leaf path in the tree represents a number.
 *
 *
 * For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
 * Return the total sum of all root-to-leaf numbers. Test cases are generated so that the answer will fit in a 32-bit integer.
 *
 * A leaf node is a node with no children.
 * ````
 * Example 1:
 *  Input: root = [1,2,3]
 *  Output: 25
 *  Explanation:
 *      The root-to-leaf path 1->2 represents the number 12.
 *      The root-to-leaf path 1->3 represents the number 13.
 *      Therefore, sum = 12 + 13 = 25.
 *
 * Example 2:
 *  Input: root = [4,9,0,5,1]
 *  Output: 1026
 *  Explanation:
 *      The root-to-leaf path 4->9->5 represents the number 495.
 *      The root-to-leaf path 4->9->1 represents the number 491.
 *      The root-to-leaf path 4->0 represents the number 40.
 *      Therefore, sum = 495 + 491 + 40 = 1026.
 * ````
 *
 * #### Constraints:
 *
 * - The number of nodes in the tree is in the range [1, 1000].
 * - 0 <= Node.val <= 9
 * - The depth of the tree will not exceed 10.
 */


fun main() {

    val root = SampleTreeData.getTreeAsNode()


    val srln = SumRootToLeafNumber()
    val output = srln.smallestFromLeaf(root)
    println("Sum = $output")


}

class SumRootToLeafNumber {

    fun sumNumbersWithExtension(root: BinaryTreeNode?): Int {
        fun BinaryTreeNode?.sumNumbers(parentNum: Int): Int {
            this ?: return 0
            val num = parentNum * 10 + value
            left ?: right ?: return num
            return left.sumNumbers(num) + right.sumNumbers(num)
        }
        return root.sumNumbers(0)
    }

    fun sumNumbers(root: BinaryTreeNode?): Int {

        var allSum = 0

        fun helper(root: BinaryTreeNode?, sum: Int) {
            if (root == null) {
                return
            }
            val newSum = sum * 10 + root.value
            if (root.isLeaf()) {
                allSum += newSum
                return
            }

            helper(root.left, newSum)
            helper(root.right, newSum)

        }
        helper(root, 0)

        return allSum

    }


    fun BinaryTreeNode.isLeaf() = this.left == null && this.right == null


    /**
     * #### [112. Path Sum](https://leetcode.com/problems/path-sum/)
     * Difficulty: Easy
     * Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.
     *
     * A leaf is a node with no children.
     *
     * ````
     * Example 1
     *      Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
     *      Output: true
     *      Explanation: The root-to-leaf path with the target sum is shown.
     *
     * Example 2:
     *      Input: root = [1,2,3], targetSum = 5
     *      Output: false
     *      Explanation: There two root-to-leaf paths in the tree:
     *      (1 --> 2): The sum is 3.
     *      (1 --> 3): The sum is 4.
     *      There is no root-to-leaf path with sum = 5.
     *
     * Example 3:
     *      Input: root = [], targetSum = 0
     *      Output: false
     *      Explanation: Since the tree is empty, there are no root-to-leaf paths.
     * ````
     *
     * #### Constraints:
     *
     * The number of nodes in the tree is in the range [0, 5000].
     * -1000 <= Node.val <= 1000
     * -1000 <= targetSum <= 1000
     */
    fun hasPathSum(root: BinaryTreeNode?, targetSum: Int): Boolean {

        if (root == null) return false


        fun pathSum(root: BinaryTreeNode, pathSum: Int) {

        }
        return false
    }


    fun hasPathSumWithExtension(root: BinaryTreeNode?, targetSum: Int): Boolean {
        fun BinaryTreeNode?.pathSum(parentSum: Int, target: Int): Boolean {
            this ?: return false
            val num = parentSum + value
            left ?: right ?: return num == target
            return left.pathSum(num, target) || right.pathSum(num, target)
        }
        return root.pathSum(0, targetSum)
    }


    fun smallestFromLeaf(root: BinaryTreeNode?): String {

        val chars = ('a'..'z').toList()
        var smallestString: String? = null

        fun findSmallest(root: BinaryTreeNode?, slate: Stack<Char>) {
            if (root == null) return

            slate.push(chars[root.value])

            if (root.left == null && root.right == null) {
                val current = slate.reversed().joinToString("")
                smallestString?.let {
                    if (it > current && slate.size > 1)
                        smallestString = current
                } ?: run {
                    if (slate.size > 1)
                        smallestString = current
                }
            }

            findSmallest(root.left, slate)
            findSmallest(root.right, slate)
            slate.pop()
        }

        findSmallest(root, Stack())
        return smallestString ?: ""
    }

    fun levelOrder(root: MultiTreeNode?): List<List<Int>> {
        val res = mutableListOf<MutableList<Int>>()
        if (root == null) return listOf()

        val q = LinkedList<MultiTreeNode>()
        q.add(root)
        res.add(mutableListOf(root.value))

        while (q.isNotEmpty()) {
            val sub = mutableListOf<Int>()
            val n = q.poll()

            n.childrens?.let {
                it.forEach { child ->
                    q.add(child!!)
                    sub.add(child.value)
                }
            }
            res.add(sub)
        }
        return res


    }


}
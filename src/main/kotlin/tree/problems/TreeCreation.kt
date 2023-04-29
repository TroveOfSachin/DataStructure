package tree.problems

import tree.base.BinaryTreeNode
import tree.base.SampleTreeData
import java.util.Stack
import kotlin.math.max

fun main() {
//    val input = arrayListOf(2, 0, 1, 3, 5, 4)
//    val output = TreeCreation().buildBinarySearchTree(input)
//    println("Tree = ${output.toString()}")


    println((true && false || true))
    println(false || false && true)


//    val input = SampleTreeData.getTreeAsNode()
//
//    var output = TreeCreation().binaryTreeToCdll(input)
//    println("Unival Size with counter = $output")
//    output = TreeCreation().countUniValue2(input)
//    println("Unival Size with Boolean = $output")

}

class TreeCreation {

    fun buildBinarySearchTree(preorder: ArrayList<Int>): BinaryTreeNode? {

        var index = 0

        fun insert(minValue: Int, maxValue: Int): BinaryTreeNode? {
            if (index >= preorder.size) {
                return null
            }

            val value = preorder[index]
            if (value < minValue || value > maxValue) {
                return null
            }

            val node = BinaryTreeNode(value)
            index++

            node.left = insert(minValue, value)
            node.right = insert(value, maxValue)

            return node
        }
        return insert(Int.MIN_VALUE, Int.MAX_VALUE)
    }


    fun isBalanceTree(input: BinaryTreeNode?): Boolean {

        fun checkBST(node: BinaryTreeNode?, min: Int, max: Int): Boolean {
            if (node == null) return true
            val isValid = node.value in (min + 1) until max
            val isLeftValid = checkBST(node.left, min, node.value)
            val isRightValid = checkBST(node.right, node.value, max)
            return isValid && isLeftValid && isRightValid
        }

        return checkBST(input, Int.MIN_VALUE, Int.MAX_VALUE)

    }


    fun countUniValue(root: BinaryTreeNode?): Int {

        if (root == null) return 0




        fun helper(node: BinaryTreeNode?, count: Int): Int {
            if (node?.left == null && (node?.right == null)) {
                return 1
            }

            var isUniVal = count + 1

            var isUniValLeft = 0
            if (node.left != null) {
                isUniValLeft = helper(node.left, count)
                if (isUniValLeft != count || node.value != node.left!!.value) isUniVal += isUniValLeft
            }
            var isUniValRight = 0
            if (node.right != null) {
                isUniValRight = helper(node.right, count)
                if (isUniValRight != count || node.value != node.right!!.value) isUniVal += isUniValLeft
            }




            return count + max(isUniValLeft, isUniValRight)


        }
        return helper(root, 0)
    }


    fun countUniValue2(root: BinaryTreeNode?): Int {

        if (root == null) return 0

        var counter = 0


        fun helper(node: BinaryTreeNode?): Boolean {
            if (node?.left == null && (node?.right == null)) {
                ++counter
                return true
            }

            var isUniVal = true

            if (node.left != null) {
                val isUniValLeft = helper(node.left)
                if (!isUniValLeft || node.value != node.left!!.value) isUniVal = false
            }

            if (node.right != null) {
                val isUniValRight = helper(node.right)
                if (!isUniValRight || node.value != node.right!!.value) isUniVal = false
            }

            if (isUniVal) ++counter

            return isUniVal


        }
        helper(root)
        return counter
    }


    fun binaryTreeToCdll(root: BinaryTreeNode?): BinaryTreeNode? {

        val map = mutableMapOf<Int, BinaryTreeNode?>()
        var output: BinaryTreeNode? = null

        var head: BinaryTreeNode? = null
        var headTail = head
        var child: BinaryTreeNode? = null
        var childTail = child

        fun traverse(root: BinaryTreeNode?, prev: BinaryTreeNode?) {
            if (root == null) return


            traverse(root.left, root) //output.left = prev

            if (head == null && root.left == null) {
                head = root
                headTail = head
            }

            traverse(root.right, root)
            if (child == null && root.right == null) {
                child = prev?.right
                childTail = child
            }


            headTail?.right = prev
            prev?.left = headTail

            childTail?.left = prev
            prev?.right = childTail


        }
        traverse(root, null)
        println(output)
        return output
    }


    fun binary_tree_to_cdll(root: BinaryTreeNode?): BinaryTreeNode? {
        // Write your code here.
        if (root == null) return null

        var inorderList = arrayListOf<BinaryTreeNode>()
        getInorder(root, null, inorderList)
        return getDoubllyLL(inorderList)
    }

    fun getInorder(root: BinaryTreeNode?, prev: BinaryTreeNode?, inorderList: ArrayList<BinaryTreeNode>) {
        if (root == null)
            return
        getInorder(root.left, root, inorderList)
        inorderList.add(root)
        getInorder(root.right, root, inorderList)
        println("right")


//        d
//
//
//
//
//


    }

    fun getDoubllyLL(inorderList: ArrayList<BinaryTreeNode>): BinaryTreeNode? {

        val size = inorderList.size - 1
        for (i in 0..inorderList.size - 2) {
            inorderList[i].right = inorderList[i + 1]
            inorderList[i + 1].left = inorderList[i]
        }
        inorderList[size].right = inorderList[0]
        inorderList[0].left = inorderList[size]

        return inorderList[0]
    }


}
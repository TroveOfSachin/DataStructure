package tree.problems

import print
import tree.base.BinaryTreeNode
import tree.base.SampleTreeData
import java.util.*
import kotlin.collections.ArrayDeque
import kotlin.collections.ArrayList

fun main() {

//    var queue = LinkedList<Int>()
//
//    for (i in (1..5)) queue.add(i)
//    println("LinkedList Add Sequence : ${(1..5).joinToString()}}")
//    println("LinkedList with 'Add' Sequence: ${queue.joinToString()}")
//    var sb = StringBuilder()
//    while(queue.isNotEmpty())
//        sb.append("${queue.pop()}, ")
//    println("LinkedList 'Pop' Sequence : ${sb.toString().removeSuffix(", ")}")
//
//
//    for (i in (1..5)) queue.push(i)
//    println("\nLinkedList Push Sequence : ${(1..5).joinToString()}")
//    println("LinkedList with 'Push' : ${queue.joinToString()}")
//    sb = StringBuilder()
//    while(queue.isNotEmpty())
//        sb.append("${queue.pop()}, ")
//    println("LinkedList 'Pop' Sequence : ${sb.toString().removeSuffix(", ")}")
//
//    println("*".repeat(50))
//
//    var stack = Stack<Int>()
//
//    for (i in (1..5)) stack.add(i)
//    println("Stack Add Sequence : ${(1..5).joinToString()}")
//    println("Stack with 'Add' : ${stack.joinToString()}")
//    sb = StringBuilder()
//    while(stack.isNotEmpty())
//        sb.append("${stack.pop()}, ")
//    println("Stack 'Pop' Sequence : ${sb.toString().removeSuffix(", ")}")
//
//    stack.clear()
//    stack = Stack<Int>()
//    for (i in (1..5)) stack.push(i)
//    println("\nStack Push Sequence : ${(1..5).joinToString()}")
//    println("Stack with 'Push' : ${stack.joinToString()}")
//    sb = StringBuilder()
//    while(stack.isNotEmpty())
//        sb.append("${stack.pop()}, ")
//    println("Stack 'Pop' Sequence : ${sb.toString().removeSuffix(", ")}")


    val root = SampleTreeData.getTreeAsNode()
    var output = TreeTraversal().preOrder(root)
    output.print("PreOrder Traversal")
    output = TreeTraversal().inOrder(root)
    output.print("PreOrder Traversal")
    output = TreeTraversal().postOrder(root)
    output.print("PostOrder Traversal")
    var o1 = TreeTraversal().levelOrder(root)
    o1.print("LevelOrder Traversal")
    var o2 = TreeTraversal().postOrderWithoutRecursion(root)
    o2.print("LevelOrder Traversal")
    o2 = TreeTraversal().postOrderWithoutRecursion_2(root)
    o2.print("LevelOrder Traversal")
}




class TreeTraversal {


    fun x(): List<List<Int>> {
        return arrayListOf()
    }

    fun levelOrder(root: BinaryTreeNode?): List<List<Int>> {
        val result: MutableList<List<Int>> = mutableListOf()
        if (root == null) return result
        val queue: Deque<BinaryTreeNode> = LinkedList()
        queue.add(root)
        while (queue.isNotEmpty()) {
            val level = mutableListOf<Int>()
            var qSize = queue.size
            while (qSize > 0) {
                val node = queue.poll()
                level.add(node.value)
                node.left?.let { queue.add(node.left) }
                node.right?.let { queue.add(node.right) }
                qSize--
            }
            result.add(level)
        }
        return result
    }

    fun preOrder(root: BinaryTreeNode?): ArrayList<Int> {

        fun traverse(root: BinaryTreeNode?, output: ArrayList<Int>): ArrayList<Int> {
            if (root == null) return output
            output.add(root.value)
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
            output.add(root.value)

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
            output.add(root.value)
            return output
        }
        return traverse(root, arrayListOf())
    }


    fun postOrderWithoutRecursion(root: BinaryTreeNode?): ArrayList<Int> {

        val res = arrayListOf<Int>()
        val stack = Stack<BinaryTreeNode>()
        var curr = root
        var prev:BinaryTreeNode? = null

        while(curr!=null || stack.isNotEmpty()){
            while (curr!=null){
                stack.push(curr)
                curr = curr.left
            }

            curr = stack.peek()
            if(curr.right == null || curr.right == prev){
                curr = stack.pop()
                res.add(curr.value)
                prev = curr
                curr = null
            }else{
                curr = curr.right
            }
        }


        return res
    }


    fun postOrderWithoutRecursion_2(root: BinaryTreeNode?): ArrayList<Int> {

        if(root == null) return arrayListOf()

        val result = ArrayList<Int>()
        val stack = Stack<BinaryTreeNode>()

        stack.push(root)

        while(stack.isNotEmpty()) {
            val curr = stack.pop()
            result.add(curr.value)
            curr.left?.let { binaryTreeNode -> stack.add(binaryTreeNode) }
            curr.right?.let { binaryTreeNode -> stack.add(binaryTreeNode) }
        }

        return ArrayList(result.reversed())
    }


}
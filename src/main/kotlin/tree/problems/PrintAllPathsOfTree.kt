package tree.problems

import linkedlist.ListNode
import tree.base.BinaryTreeNode
import tree.base.SampleTreeData
import java.util.*
import java.util.concurrent.atomic.AtomicInteger
import kotlin.collections.ArrayList
import kotlin.math.max


fun main() {
    val root = SampleTreeData.getTreeAsNode()
//    val output = PrintAllPathsOfTree().getAllBFS(root)
//
//    output.print("BFS Output")
//
//    val output1 = PrintAllPathsOfTree().getAllDFS(root)
//    output1.print("DFS Output")


    val arr7 = arrayListOf(
        -1, 2, 3, 5, 6, 7, 10
    )

    var node = ListNode.create(arr7)

    val pa = PrintAllPathsOfTree()

    var output = pa.findMaxSumOfTree(root)


    println("Sum of  Tree = $output ")
//    output = pa.balanceSearchTree(node)
//    println("balanceSearchTree : Counter : ${pa.counter.get()}")
//    println("Stable Tree = $output ")


}

class PrintAllPathsOfTree {

    val counter = AtomicInteger(0)

    fun getAllBFS(root: BinaryTreeNode?): ArrayList<ArrayList<Int>> {


        val result = arrayListOf<ArrayList<Int>>()
        if (root == null) return result


        val queue = LinkedList<BinaryTreeNode>()
        queue.offer(root)



        while (queue.isNotEmpty()) {
            val levelSize = queue.size
            val levelList = arrayListOf<Int>()
            for (i in 0 until levelSize) {
                val node = queue.poll()
                levelList.add(node.value)
                if (node.left != null) {
                    queue.offer(node.left)
                }
                if (node.right != null) {
                    queue.offer(node.right)
                }
            }
            result.add(levelList)

        }

        return result
    }


    fun getAllDFS(root: BinaryTreeNode?): ArrayList<ArrayList<Int>> {
        val paths = arrayListOf<ArrayList<Int>>()
        if (root == null) {
            return arrayListOf()
        }
        fun dfs(node: BinaryTreeNode?, path: ArrayList<Int>) {
            if (node == null) {
                return
            }
            path.add(node.value)
            if (node.left == null && node.right == null) {
                paths.add(ArrayList(path))
            } else {
                dfs(node.left, path)
                dfs(node.right, path)
            }
            path.removeAt(path.lastIndex)
        }
        dfs(root, arrayListOf())


        return paths
    }

    fun getAllPathWithSum(root: BinaryTreeNode?, k: Int): ArrayList<ArrayList<Int>> {

        val output = ArrayList<ArrayList<Int>>()

        fun findPath(root: BinaryTreeNode?, sum: Int, path: Stack<Int>) {

            if (root == null) {
                return
            }
            path.push(root.value)
            if (root.left == null && root.right == null && sum + path.peek() == k) {

                output.add(arrayListOf<Int>().apply { addAll(path) })
                path.pop()
                return
            }

            findPath(root.left, sum + root.value, path)
            findPath(root.right, sum + root.value, path)
            path.pop()

        }
        findPath(root, 0, Stack())


        return if (output.isEmpty()) arrayListOf(arrayListOf(-1)) else output

    }


    /** Find the diameter fo the Tree
     * Which mean longest path of left + right is a diameter of Tree
     */
    fun findDiameterOfTree(root: BinaryTreeNode?): Int {
        var maxPathLen = 0
        fun longestPath(root: BinaryTreeNode?): Int {
            if (root == null) return 0
            val left = longestPath(root.left)
            val right = longestPath(root.right)
            maxPathLen = maxPathLen.coerceAtLeast(left + right)
            return (left.coerceAtLeast(right)) + 1
        }

        return longestPath(root)

    }


    /**
     * Convert Sorted List To Binary Search Tree
     */
    fun sortedListToBalanceSearchTree(listNode: ListNode?): BinaryTreeNode? {

        val counter = AtomicInteger(0)

        var node = listNode
        val listArray = arrayListOf<Int>()
        while (node != null) {
            counter.incrementAndGet()
            listArray.add(node.value)
            node = node.next
        }

        fun bst(listArray: ArrayList<Int>, start: Int, end: Int): BinaryTreeNode? {
            counter.incrementAndGet()
            if (start > end) return null
            if (start == end) return BinaryTreeNode(listArray[start])

            val mid = start + (end - start) / 2

            val rootNode = BinaryTreeNode(listArray[mid])
            rootNode.left = bst(listArray, start, mid - 1)
            rootNode.right = bst(listArray, mid + 1, end)
            return rootNode
        }

        println("sortedListToBalanceSearchTree Counter : ${counter.get()}")
        return bst(listArray, 0, listArray.size - 1)


    }

    fun balanceSearchTree(head: ListNode?): BinaryTreeNode? {
        counter.incrementAndGet()
        if (head == null) return null
        if (head.next == null) return BinaryTreeNode(head.value)

        var slow = head
        var fast = head
        var prev: ListNode? = null
        while (fast?.next != null) {
            counter.incrementAndGet()
            prev = slow
            slow = slow?.next
            fast = fast.next?.next
        }

        val newNode = BinaryTreeNode(slow?.value!!)
        prev?.next = null
        newNode.left = balanceSearchTree(head)
        newNode.right = balanceSearchTree(slow.next)

        return newNode


    }


    fun findMaxSumOfTree(root: BinaryTreeNode?): Int {
        var treeMax = Int.MIN_VALUE
        fun longestPath(root: BinaryTreeNode?): Int {
            if (root == null) return 0
            val left = longestPath(root.left)
            val right = longestPath(root.right)
            val rootMax = max(root.value, max(right + root.value, left + root.value))
            val allMax = max(rootMax, root.value + left + right)
            treeMax = max(allMax, treeMax)
            return rootMax
        }
        longestPath(root)

        return treeMax

    }


}
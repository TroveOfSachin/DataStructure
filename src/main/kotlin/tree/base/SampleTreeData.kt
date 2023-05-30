package tree.base

import linkedlist.ListNode
import java.util.*

object SampleTreeData {

    // @formatter:off
    private val arr = arrayListOf(
        44,
        17, 88,
        8, 32, 65, 97,
        null, null, 28, null, 54, 82, 93, null,
        null, null, null, null, null, 29, null, null, null, null, 76, null, null, null, null, null,
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 80
    )
    // @formatter:on

    private val arr2 = arrayListOf(
        1,
        2
    )

    private val arr3 = arrayListOf(
        1,
        2, 3,
        4, 5, 6, 7,
        null, null, 8, 9
    )

    private val arr4 = arrayListOf(
        2,
        5, 4,
        0, 1, 3, 6
    )

    private val arr5 = arrayListOf(
        10,
        25, 30,
        45, null, 40, 50
    )

    private val arr6 = arrayListOf(
        100,
        200, 300,

        )


    private val arr1 = (0..4).toList()

    private val arr7 = arrayListOf(
        1,
        2, 3,
        4, 5, 6
    )

    private val arr8 = arrayListOf(
        4,
        0, 3,
        2, 5, null, null,
        6, null, null, null, null, null, null, null,
        1
    )

    private val arr9 = arrayListOf<Int?>(
        200,
        100, 300
    )




    private val root: BinaryTreeNode? = createTreeFromArray(arr8)
    fun getTreeAsNode() = root

    private val multiArr1 = arrayOf(1, null, 3, 2, 4, null, 5, 6)



    fun createTreeFromArray(arr: List<Int?>?): BinaryTreeNode? {



        if (arr.isNullOrEmpty() || arr[0] == null) {
            return null
        }

        val root = BinaryTreeNode(arr[0]!!)
        createTreeFromArrayHelper(arr, root, 0)
        return root
    }


    private fun createTreeFromArrayHelper(arr: List<Int?>, node: BinaryTreeNode?, index: Int) {
        if (node == null) {
            return
        }

        val leftIndex = 2 * index + 1
        val rightIndex = 2 * index + 2

        if (leftIndex < arr.size && arr[leftIndex] != null) {
            node.left = BinaryTreeNode(arr[leftIndex]!!)
//        node.left?.parent = node
        }

        if (rightIndex < arr.size && arr[rightIndex] != null) {
            node.right = BinaryTreeNode(arr[rightIndex]!!)
//        node.right?.parent = node
        }

        createTreeFromArrayHelper(arr, node.left, leftIndex)
        createTreeFromArrayHelper(arr, node.right, rightIndex)
    }


    fun getTreeAsList() = arr

}
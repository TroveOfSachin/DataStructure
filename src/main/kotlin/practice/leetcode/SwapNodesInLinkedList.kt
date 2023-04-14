package practice.leetcode

import linkedlist.ListNode


/**
 * ### [1721. Swapping Nodes in a Linked List](https://leetcode.com/problems/swapping-nodes-in-a-linked-list/)
 * Difficulty: Medium
 *
 * You are given the head of a linked list, and an integer k.
 *
 * Return the head of the linked list after swapping the values of the kth node from the beginning and the kth node from the end (the list is 1-indexed).
 *
 *
 * ````
 * Example 1:
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [1,4,3,2,5]
 *
 * Example 2:
 * Input: head = [7,9,6,6,7,8,3,0,9,5], k = 5
 * Output: [7,9,6,6,8,7,3,0,9,5]
 * ````
 *
 * ### Constraints:
 *
 * - The number of nodes in the list is n.
 * - 1 <= k <= n <= 105
 * - 0 <= Node.val <= 100
 */


fun main() {
    val arr = (1..2).toMutableList()

    var head: ListNode? = null

    for (i in arr.indices.reversed()) {
        val newNode = ListNode(arr[i])
        newNode.next = head
        head = newNode
    }

    val x = SwapNodesInLinkedList().swapNodes(head, 2)
    x?.printListNode()
}

class SwapNodesInLinkedList {

    fun swapNodes(head: ListNode?, k: Int): ListNode? {
        var totalNodes = 0
        var firstNode: ListNode? = head
        fun helper(node: ListNode?, index: Int) {
            ++totalNodes
            if (node == null) return
            if (index == k) firstNode = node

            helper(node.next, index + 1)


            if (totalNodes - k == index) firstNode?.value = node.value.also { node.value = firstNode?.value!! }
        }
        helper(head, 1)
        return head
    }
}
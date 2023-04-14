package practice.leetcode

import linkedlist.ListNode

/**
 * #### [24. Swap Nodes in Pairs](https://leetcode.com/problems/swap-nodes-in-pairs/)
 * Complexity: Medium
 * Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)
 * ````
 * Example 1:
 * Input: head = [1,2,3,4]
 * Output: [2,1,4,3]
 *
 * Example 2:
 * Input: head = []
 * Output: []
 *
 * Example 3:
 * Input: head = [1]
 * Output: [1]
 * ````
 * #### Constraints:
 *
 * The number of nodes in the list is in the range [0, 100].
 * 0 <= Node.val <= 100
 */

fun main() {
    val arr = (1..11).toMutableList()

    var head: ListNode? = null

    for (i in arr.indices.reversed()) {
        val newNode = ListNode(arr[i])
        newNode.next = head
        head = newNode
    }

    val x = SwapNodesInPair().swapPairs(head)
    x?.printListNode()
}

class SwapNodesInPair {

    fun swapPairs(head: ListNode?): ListNode? {
        fun swapNodes(head: ListNode?): ListNode? {
            if (head?.next == null) {
                return head
            }

            val result = swapNodes(head.next?.next)
            val newHead = head.next
            head.next = result
            newHead?.next = head
            return newHead
        }
        return swapNodes(head)
    }


    fun swapPairs1(head: ListNode?): ListNode? {
        if (head?.next == null) return head


        var tail = head

        val newHead = ListNode(0)
        var newTail: ListNode? = newHead


        fun helper(node: ListNode?) {
            if (node?.next == null) return


            val first = tail // first
            tail = tail?.next
            first?.next = null

            val second = tail
            newTail?.next = second
            newTail = newTail?.next
            tail = tail?.next
            second?.next = first
            first?.next = tail
            newTail = newTail?.next

            helper(tail)

        }
        helper(head)

        return newHead.next

    }
}
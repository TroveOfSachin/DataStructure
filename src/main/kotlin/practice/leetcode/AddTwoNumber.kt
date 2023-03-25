package practice.leetcode

import linkedlist.ListNode
import java.util.*


/**
 *
 * ## Add Two Numbers
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * ````
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 * ````
 *
 * ````
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 * ````
 *
 * ````
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 * ````
 *
 * ### Constraints:
 *
 * - The number of nodes in each linked list is in the range [1, 100].
 * - 0 <= Node.val <= 9
 * - It is guaranteed that the list represents a number that does not have leading zeros.
 *
 *
 */


fun main() {
    val e1 = LinkedList(listOf(2,4,3))
    val e2 = LinkedList(listOf(5,6,4))
    val lists = arrayListOf(e1, e2)
    val input = arrayListOf<ListNode?>()

    lists.forEach {

        var head: ListNode? = null
        var tail: ListNode? = null

        it.forEach { node ->

            node?.let {
                tail?.let { cc ->
                    cc.next = ListNode(node)
                    tail = cc.next
                } ?: run {
                    tail = ListNode(node)
                    head = tail
                }
            }
        }


        input.add(head)
    }


    val output = AddTwoNumber().addTwoNumbers(input[0]!!, input[1]!!)

    output?.printListNode()
}

class AddTwoNumber {

    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {

        var l1Current = l1
        var l2Current = l2

        var head = ListNode(0)
        var tail: ListNode? = head
        var carry = 0

        while (l1Current != null || l2Current !== null || carry > 0) {
            val sum = (l1Current?.value ?: 0) + (l2Current?.value ?: 0) + carry
            carry = sum / 10
            tail?.next = ListNode(sum % 10)
            tail = tail?.next
            l1Current = l1Current?.next
            l2Current = l2Current?.next
        }

        return head.next
    }

}
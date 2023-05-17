package practice.leetcode

import linkedlist.ListNode
import java.util.*


/**
 * #### [2130. Maximum Twin Sum of a Linked List](https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/)
 */


fun main() {
    val output = MaximumTwinSumOfLinkedList().pairSum(ListNode.create(listOf(5,4,2,1)))
    println(output)
}

class MaximumTwinSumOfLinkedList {
    fun pairSum(head: ListNode?): Int {

        if (head == null) return 0
        if (head.next == null) return head.value
        var slow = head
        var fast = head
        var stack = Stack<ListNode>()
        while (fast?.next != null) {
            stack.push(slow)
            slow = slow?.next;
            fast = fast.next!!.next;
        }

        var max = 0
        while (slow != null) {
            max = maxOf(stack.pop().value + slow.value)
            slow = slow.next
        }

        return max

    }
}

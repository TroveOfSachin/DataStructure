package practice.leetcode

import linkedlist.ListNode

/**
 * [21. Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists/)
 */


fun main() {
    val arr1 = intArrayOf(1, 2, 4)
    val arr2 = intArrayOf(1, 3, 4)
    var list1 = ListNode(0)
    var list1Tail = list1
    var list2 = ListNode(0)
    var list2Tail = list2
    arr1.map {
        list1Tail.next = ListNode(it)
        list1Tail = list1Tail.next!!
    }

    arr2.map {
        list2Tail.next = ListNode(it)
        list2Tail = list2Tail.next!!
    }

    val output = MergeTwoSortedList().mergeTwoLists(list1.next, list2.next)
    println("$output")

}


class MergeTwoSortedList {

    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {

        var l1 = list1
        var l2 = list2

        val head = ListNode(0)
        var tail = head

        while (l1 != null && l2 != null) {
            if (l1.value < l2.value) {
                tail.next = l1
                l1 = l1.next
            } else {
                tail.next = l2
                l2 = l2.next
            }
            tail = tail.next!!
        }

        if (l1 != null) {
            tail.next = l1
        }

        if (l2 != null) {
            tail.next = l2
        }

        return head.next
    }
}
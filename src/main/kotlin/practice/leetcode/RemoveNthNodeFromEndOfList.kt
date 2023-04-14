package practice.leetcode

import linkedlist.ListNode


fun main() {
    val arr = (1..1).toMutableList()
    var head: ListNode? = null

    for (i in arr.indices.reversed()) {
        val newNode = ListNode(arr[i])
        newNode.next = head
        head = newNode
    }

    val x = RemoveNthNodeFromEndOfList().removeNthFromEnd(head, 1)
    x?.printListNode()
}

class RemoveNthNodeFromEndOfList {

    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        var count = 0
        fun remove(node: ListNode?): ListNode? {
            if (node == null) {
                return null
            }
            node.next = remove(node.next)
            count++
            if (count == n) {
                return node.next
            }
            return node
        }
        return remove(head)
    }
}
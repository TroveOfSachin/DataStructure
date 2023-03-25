package practice.leetcode


/**
 * ## Reverse Nodes in k-Group
 * Given the `head` of a linked list, reverse the nodes of the list `k` at a time, and return the modified list.
 *
 * `k` is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of `k` then left-out nodes, in the end, should remain as it is.
 *
 * You may not alter the values in the list's nodes, only nodes themselves may be changed.
 *
 * ### Example - 1
 * ````
 *  Input: head = [1,2,3,4,5], k = 2
 *  Output: [2,1,4,3,5]
 * ````
 *
 * ### Example - 2
 * ````
 * Input: head = [1,2,3,4,5], k = 3
 * Output: [3,2,1,4,5]
 *
 * ### Constraints:
 *
 * - The number of nodes in the list is n.
 * - 1 <= k <= n <= 5000
 * - 0 <= Node.val <= 1000
 *
 */


fun main() {

    val arr = (1..10).toMutableList()

    var head: ListNode? = null

    for (i in arr.indices.reversed()) {
        val newNode = ListNode(arr[i])
        newNode.next = head
        head = newNode
    }


//    val output = ReverseNodesInKGroup().reverseKGroup(head, 5)
    val output = listNodeLength(head)
    println(output)


}

fun listNodeLength(head: ListNode?): Int {
    var node = head
    var count = 0
    while (node != null) {
        count++
        node = node.next
    }
    return count
}


private fun printList(head: ListNode?) {
    var current = head
    while (current != null) {
        print("${current.value}->")
        current = current.next

    }
}


class ListNode(var value: Int) {
    var next: ListNode? = null
}


class ReverseNodesInKGroup {

    private fun getCount(head: ListNode?): Int {
        var nodeCount = 0
        var current = head
        while (current != null) {
            nodeCount++
            current = current.next
        }
        return nodeCount
    }

    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {

        if (k == 1) return head

        var count = getCount(head)

//        if (count < k) {
//            return head
//        }

        var cur: ListNode? = head // current node
        var prev: ListNode? = null // is holding next value so that current can be assigned to next for reverse
        var next: ListNode? = null // to maintain the sequence of next of current node.

        var counter = 0

        while (cur?.next != null && counter < k) {
            next = cur?.next
            cur?.next = prev
            prev = cur
            cur = next
            counter++
        }


        var out = prev
        while (prev?.next != null) {
            prev = prev.next
        }

        prev?.next = reverseKGroup(cur, k)


        return out
    }

    fun reverseLL(node: ListNode?): ListNode? {

        if (node == null) return node

        var prev: ListNode? = null
        var cur = node
        var next: ListNode? = null
        var counter = 0
        while (cur != null) {
            next = cur.next
            cur.next = prev
            prev = cur
            cur = next
            counter++
        }


        return prev
    }
}
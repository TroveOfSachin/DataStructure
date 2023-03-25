package linkedlist.singly

import linkedlist.ListNode


fun main() {
//    val arr = (1..5).toMutableList()
//
//    var head: ListNode? = null
//
//    for (i in arr.indices.reversed()) {
//        val newNode = ListNode(arr[i])
//        newNode.next = head
//        head = newNode
//    }
//
//    val output = LinkedListOps().reverseTillFirstK(head, 3)
//
////    printListNode(output)

    val arr1 = intArrayOf(1, 2, 3)
    val arr2 = intArrayOf(2, 5, 8)
    merge(arr1, arr2)


}

fun merge(arr1: IntArray, arr2: IntArray): IntArray {
    val m = arr1.size
    val n = arr2.size

    // Traverse the first array from right to left
    for (i in m - 1 downTo 0) {
        // Find the smallest element in the second array that is greater than or equal to the current element of the first array
        var j = 0
        while (j < n && arr2[j] < arr1[i]) {
            j++
        }

        // If there is an element in arr2 that is equal to the current element of arr1, move it to the front of arr2
        while (j > 0 && j < n && arr2[j - 1] == arr1[i]) {
            val temp = arr2[j - 1]
            arr2[j - 1] = arr2[j]
            arr2[j] = temp
            j--
        }

        // If the current element of arr1 is greater than the smallest element in arr2, swap the two elements
        if (j < n && arr2[j] < arr1[i]) {
            val temp = arr1[i]
            arr1[i] = arr2[j]
            arr2[j] = temp

            // Move the swapped element in arr2 to its correct position
            var k = j + 1
            while (k < n && arr2[k] < arr2[k - 1]) {
                val temp2 = arr2[k]
                arr2[k] = arr2[k - 1]
                arr2[k - 1] = temp2
                k++
            }
        }
    }

    // Merge the two sorted arrays
    val mergedArray = IntArray(m + n)
    var i = 0
    var j = 0
    var k = 0
    while (i < m && j < n) {
        if (arr1[i] <= arr2[j]) {
            mergedArray[k++] = arr1[i++]
        } else {
            mergedArray[k++] = arr2[j++]
        }
    }
    while (i < m) {
        mergedArray[k++] = arr1[i++]
    }
    while (j < n) {
        mergedArray[k++] = arr2[j++]
    }
    return mergedArray
}




private fun printListNode(head: ListNode?) {
    println()
    var current = head
    while (current != null) {
        print("${current.value}->")
        current = current.next
    }
}


class LinkedListOps {

    fun insertAtHead(head: ListNode?, newNode: ListNode): ListNode? {
        if (head == null) return head
        var newHead = head
        newNode.next = newHead
        newHead = newNode
        return newHead
    }

    fun insertAtTail(head: ListNode?, newNode: ListNode): ListNode? {

        head?.let {
            var current: ListNode? = head

            while (current?.next != null) {
                current = current.next
            }
            current?.next = newNode

            return head
        } ?: run {
            return null
        }


    }

    fun insertAtSpecificPosition(head: ListNode?, newNode: ListNode, position: Int): ListNode? {
        if (head == null) return head

        var current = head
        var counter = 0
        while (current != null && counter < position - 1) {
            current = current.next
            counter++
        }

        val next = current?.next
        newNode.next = next
        current?.next = newNode

        return head

    }

    fun deleteAtHead(head: ListNode?): ListNode? {
        return if (head == null) head
        else {
            var temp = head
            var next = head
            next = head.next
            next
        }
    }


    fun deleteAtTail(head: ListNode?): ListNode? {
        return if (head == null) head
        else {
            var last = head
            var lastToNext: ListNode? = null
            while (last?.next != null) {
                lastToNext = last
                last = last.next
            }
            lastToNext?.next = null
            return head
        }
    }

    fun deleteAtSpecificPosition(head: ListNode?, position: Int): ListNode? {
        if (head == null) return head


        var original = head
        var last: ListNode? = null

        var counter = 0
        while (original?.next != null && counter < position - 1) {
            last = original
            original = original.next
            counter++
        }

        last?.next = original?.next

        return head


    }

    fun reverse(head: ListNode?): ListNode? {

        var current = head
        var prev: ListNode? = null
        var next: ListNode? = null

        while (current != null) {
            next = current.next
            current.next = prev
            prev = current
            current = next

        }
        return prev
    }

    fun reverseTillFirstK(head: ListNode?, position: Int): ListNode? {
        var current = head
        var next: ListNode? = null
        var prev: ListNode? = null
        var counter = 0
        while (current != null && counter < position - 1) {
            next = current.next
            current.next = prev
            prev = current
            current = next

            counter++
        }


        insertAtTail(prev, reverseTillFirstK(current, position)!!)

        return prev

    }


}
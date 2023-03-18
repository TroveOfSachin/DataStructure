package practice.sorting

import print
import java.util.*


/**
 * Given k linked lists where each one is sorted in the ascending order, merge all of them into a single sorted linked list.
 *
 * Ex.
 * {
 * "lists": [
 * [1, 3, 5],
 * [3, 4],
 * [7]
 * ]
 * }
 *
 *
 * Output: [1, 3, 3, 4, 5, 7]
 *
 *
 * @param lists: ArrayList<LinkedListNode?>
 *
 */


fun main() {
    val solution = MergeKSortedLinkedList()

    val lists: ArrayList<LinkedListNode?> = ArrayList()
    var head: LinkedListNode? = null
    var node: LinkedListNode? = null
    (1..5 step 2).forEach { counter ->
        node?.let {
            it.next = LinkedListNode(counter, null)
            node = it.next
        } ?: run {
            node = LinkedListNode(counter, null)
            head = node

        }
    }

    lists.add(head)
    head = null
    node = null
    (3..4).forEach { counter ->
        node?.let {
            it.next = LinkedListNode(counter, null)
            node = it.next
        } ?: run {
            node = LinkedListNode(counter, null)
            head = node

        }
    }
    lists.add(head)
    head = null
    node = null
    (7..7).forEach { counter ->
        node?.let {
            it.next = LinkedListNode(counter, null)
            node = it.next
        } ?: run {
            node = LinkedListNode(counter, null)
            head = node

        }
    }
    lists.add(head)


    val result = solution.sort(lists)
    val output = mutableListOf<Int>()
    var current = result

    while (current != null) {
        output.add(current.value)
        current = current.next
    }

    output.toTypedArray().print("Sorted Element")
}


open class LinkedListNode(val value: Int, var next: LinkedListNode? = null)


open class NodeIndexPair(val value: Int, var index: Int) : Comparable<NodeIndexPair> {
    override fun compareTo(other: NodeIndexPair): Int = this.value - other.value

}


class MergeKSortedLinkedList {


    fun sort(lists: ArrayList<LinkedListNode?>): LinkedListNode? {


        // maintain priority queue to get mininum element and its index in list

        val minHeap = PriorityQueue<NodeIndexPair>()
        lists.forEachIndexed { index, node ->
            node?.let {
                minHeap.add(NodeIndexPair(node.value, index))
            }

        }


        // as we had already sorted linkedList, PQ can return min element when pop
        // to start with lets take an head & tail with any sentinal value

        var head: LinkedListNode? = LinkedListNode(0)
        var tail: LinkedListNode? = head

        // lets execute pop the PriorityQueue and while popping it up, we will add the pop nodes next reference in the PQ
        // hence will iterate execution till PQ is not empty

        while (minHeap.isNotEmpty()) {
            var minIndex = minHeap.poll().index // "poll" as it will return the min element and remove it from queue

            tail?.next = lists[minIndex]
            tail = tail?.next

            lists[minIndex] = lists[minIndex]!!.next
            tail?.next = null

            lists[minIndex]?.let {
                minHeap.add(NodeIndexPair(it.value, minIndex))
            }
            // if next node is null then there are no elements remains in the node chain


        }

        return head?.next
    }


}


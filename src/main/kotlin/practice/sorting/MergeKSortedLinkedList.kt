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


    val e1 = LinkedList((1..5 step 2).toList())
    val e2 = LinkedList((3..4).toList())
    val e3 = LinkedList((7..7).toList())
    val e4 = LinkedList((3..15 step 3).toList())
    val lists = arrayListOf(e1, e2, e3, e4)
    val input = arrayListOf<LinkedListNode?>()

    lists.forEach {

        var head: LinkedListNode? = null
        var tail: LinkedListNode? = null

        it.forEach { node ->

            node?.let {
                tail?.let { cc ->
                    cc.next = LinkedListNode(node, null)
                    tail = cc.next
                } ?: run {
                    tail = LinkedListNode(node, null)
                    head = tail
                }
            }
        }


        input.add(head)
    }

    var result = solution.sortWithoutAuxiliarySpace(input)
    val output = mutableListOf<Int>()

    while (result != null) {
        output.add(result.value)
        result = result.next
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

    fun sortA(lists: ArrayList<LinkedListNode?>): LinkedListNode? {


        if (lists.isEmpty()) return null

        val minHeap = PriorityQueue<LinkedListNode> { a, b -> b.value.compareTo(a.value) }
        var result: LinkedListNode? = null
        lists.forEach {
            var temp = it
            while (temp != null) {
                var next = temp.next
                temp.next = null
                minHeap.add(temp)
                temp = next
            }
        }

        for (i in 0 until minHeap.size) {
            result?.let {
                val newNode = minHeap.poll()
                newNode.next = result
                result = newNode

            } ?: run {
                result = minHeap.poll()
            }
        }
        return result
    }


    fun sortWithoutAuxiliarySpace(lists: ArrayList<LinkedListNode?>): LinkedListNode? {
        if (lists.isEmpty()) return null
        return MergeKSortedLinkedListInPlace().sort(lists, 0, lists.lastIndex)
    }

    private class MergeKSortedLinkedListInPlace {

        fun sort(lists: ArrayList<LinkedListNode?>, start: Int, end: Int): LinkedListNode? {

            if (start == end) return lists[start]

            // calculate mid
            val mid = (end + start) / 2
            val left = sort(lists, start, mid)
            val right = sort(lists, mid + 1, end)

            return mergeLeftRight(left, right)
        }

        private fun mergeLeftRight(left: LinkedListNode?, right: LinkedListNode?): LinkedListNode? {

            if (left == null)
                return right
            if (right == null)
                return left

            return if (left.value < right.value) {
                left.next = mergeLeftRight(left.next, right)
                left
            } else {
                right.next = mergeLeftRight(left, right.next)
                right
            }
        }
    }

}


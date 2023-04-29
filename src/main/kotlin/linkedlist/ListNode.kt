package linkedlist

data class ListNode(var value: Int, var next: ListNode? = null) {

    fun printListNode() {
        println()
        var current = this
        while (current != null) {
            print("${current.value}->")
            if (current.next == null) break
            current = current.next!!
        }
    }

    companion object {


        fun create(arr: List<Int>): ListNode? {

            var head: ListNode? = null

            for (i in arr.indices.reversed()) {
                val newNode = ListNode(arr[i])
                newNode.next = head
                head = newNode
            }
            return head
        }
    }

}
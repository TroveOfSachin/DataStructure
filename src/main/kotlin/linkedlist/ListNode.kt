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

}
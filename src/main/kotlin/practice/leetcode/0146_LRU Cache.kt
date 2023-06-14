package practice.leetcode

/***
 * #### (146. LRU Cache)[https://leetcode.com/problems/lru-cache/]
 */

data class Node(val key: Int, val value: Int, var prev: Node? = null, var next: Node? = null)
class LRUCache(private val capacity: Int) {

    val map: HashMap<Int, Node> = HashMap()
    var head: Node = Node(-1, -1)
    var tail: Node = Node(-1, -1)

    init {
        head.next = tail
        tail.prev = head
    }

    fun get(key: Int): Int {
        if (!map.contains(key))
            return -1
        val node = map[key]!!
        remove(node)
        add(node)
        return node.value

    }

    fun put(key: Int, value: Int) {
        if (map.contains(key))
            remove(map[key]!!)

        val n = Node(key, value)
        map[key] = n
        add(n)
        if (map.size > capacity) {
            val nd = head.next
            if (nd != null) {
                remove(nd)
            }
            if (nd != null) {
                map.remove(nd.key)
            }
        }

    }

    fun add(node: Node) {
        var end = tail.prev
        end?.next = node
        node.prev = end
        node.next = tail
        tail.prev = node
    }

    fun remove(node: Node) {
        node.prev?.next = node.next
        node.next?.prev = node.prev
    }
}

class LRUCache2(private val capacity: Int) {

    private val ns = object : LinkedHashMap<Int, Int>(capacity, 1f, true) {
        override fun removeEldestEntry(eldest: MutableMap.MutableEntry<Int, Int>?) = size > capacity
    }

    fun get(key: Int): Int = ns[key] ?: -1
    fun put(key: Int, value: Int) {
        ns[key] = value
    }

}
package practice.code_signal

import ternary

fun main() {
    val inputArray = arrayOf(
        intArrayOf(1, 3),
        intArrayOf(0, 2),
        intArrayOf(1, 3),
        intArrayOf(0, 2)
    )

    var output = IsGraphBipartite().bipartiteWithIterative(inputArray)
    println("Iterative : $output")
    output = IsGraphBipartite().bipartiteWithIRecursion(inputArray)
    println("Recursive : $output")
    output = IsGraphBipartite().isBipartite(inputArray)
    println("DFS : $output")
}


class IsGraphBipartite {
    fun bipartiteWithIterative(graph: Array<IntArray>): Boolean {

        val color = IntArray(graph.size) { 0 }

        // BFS Traversal
        for (i in graph.indices) {
            val q = ArrayDeque<Int>()
            if (color[i] == 1 || color[i] == -1)
                continue

            q.add(i)
            color[i] = -1
            while (q.isNotEmpty()) {
                val cur = q.removeFirst()
                for (next in graph[cur]) {
                    if (color[next] == 0) {
                        color[next] = -color[cur]
                        q.add(next)
                    }

                    if (color[next] == color[cur]) return false
                }
            }

        }

        return true
    }

    fun bipartiteWithIRecursion(graph: Array<IntArray>): Boolean {

        val color = IntArray(graph.size) { 0 }

        fun bfs(i: Int): Boolean {

            if (color[i] != 0)
                return true
            val q = ArrayDeque<Int>()
            q.add(i)
            color[i] = -1
            while (q.isNotEmpty()) {
                val cur = q.removeFirst()
                for (next in graph[cur]) {

                    if (color[next] == 0) {
                        color[next] = -color[cur]
                        q.add(next)
                    }

                    if (color[next] == color[cur]) return false


                }
            }
            return true
        }


        for (i in graph.indices) {
            if (!bfs(i))
                return false
        }

        return true
    }

    /*
    Notice that every edge should connect a node in set A and set B. If both nodes are in the same set, the answer is false.
    - For each node in the graph we should do a dfs
    - keep a map "node > setA || setB"
    - for each DFS iter if node is not visited, visit it and mark the set in map. If visited check if the set we are coming from is not the same set.
     */


    sealed class PartSet {
        object RED : PartSet()
        object BLUE : PartSet()
    }

    fun isBipartite(graph: Array<IntArray>): Boolean {

        val map = HashMap<Int, PartSet>()

        fun dfs(node: Int, fromPartition: PartSet?, graph: Array<IntArray>): Boolean {
            if (map.containsKey(node)) {
                return map[node]!! != fromPartition
            }

            // put into the B partition since coming from A
            val toPartition = (fromPartition == PartSet.RED).ternary(PartSet.BLUE, PartSet.RED)
            
            map[node] = toPartition
            for (neigh in graph[node]) {
                if (!dfs(neigh, toPartition, graph)) return false
            }

            return true
        }


        for (node in graph.indices) {
            if (!dfs(node, null, graph)) return false
        }

        return true
    }


}
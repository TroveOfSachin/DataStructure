package practice.leetcode

/**
 * [1579. Remove Max Number of Edges to Keep Graph Fully Traversable](https://leetcode.com/problems/remove-max-number-of-edges-to-keep-graph-fully-traversable/)
 */
class RemoveMaxNumberOfEdgesToKeepGraphFullyTraversable {

    fun maxNumEdgesToRemove(n: Int, edges: Array<IntArray>): Int {
        val ufa = UnionFind(n)
        val ufb = UnionFind(n)
        var ans = 0
        for (e in edges) {
            val t = e[0]
            val u = e[1]
            val v = e[2]
            if (t == 3) {
                if (ufa.union(u, v)) {
                    ufb.union(u, v)
                } else {
                    ++ans
                }
            }
        }
        for (e in edges) {
            val t = e[0]
            val u = e[1]
            val v = e[2]
            if (t == 1 && !ufa.union(u, v)) {
                ++ans
            }
            if (t == 2 && !ufb.union(u, v)) {
                ++ans
            }
        }
        return if (ufa.cnt == 1 && ufb.cnt == 1) ans else -1
    }

}


internal class UnionFind(n: Int) {
    private val p: IntArray
    private val size: IntArray
    var cnt: Int

    init {
        p = IntArray(n)
        size = IntArray(n)
        for (i in 0 until n) {
            p[i] = i
            size[i] = 1
        }
        cnt = n
    }

    fun find(x: Int): Int {
        if (p[x] != x) {
            p[x] = find(p[x])
        }
        return p[x]
    }

    fun union(a: Int, b: Int): Boolean {
        val pa = find(a - 1)
        val pb = find(b - 1)
        if (pa == pb) {
            return false
        }
        if (size[pa] > size[pb]) {
            p[pb] = pa
            size[pa] += size[pb]
        } else {
            p[pa] = pb
            size[pb] += size[pa]
        }
        --cnt
        return true
    }
}
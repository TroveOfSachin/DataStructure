package practice.leetcode.contest

class GreatestCommonDivisorTraversal {
    fun canTraverseAllPairs(arr: IntArray): Boolean {
        val N = arr.size
        val has = BooleanArray(1 shl 17)
        val MAX = 100000

        for (x in arr) {
            has[x] = true
        }

        if (N == 1) {
            return true
        }

        if (has[1]) {
            return false
        }

        val union = DSU(2 * MAX + 1)
        for (d in 2..MAX) {
            val root = d + MAX
            var v = d
            while (v <= MAX) {
                if (has[v]) {
                    union.merge(root, v)
                }
                v += d
            }
        }

        val comps = HashSet<Int>()
        for (i in 2..MAX) {
            if (has[i]) {
                comps.add(union.find(i))
            }
        }

        return comps.size == 1
    }
}

class DSU(private val N: Int) {
    private val dsu: IntArray = IntArray(N + 1) { it }

    fun find(x: Int): Int {
        return if (dsu[x] == x) x else find(dsu[x]).also { dsu[x] = it }
    }

    fun merge(x: Int, y: Int) {
        val fx = find(x)
        val fy = find(y)
        if (fx == fy) {
            return
        }
        dsu[fx] = fy
    }
}
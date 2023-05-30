package practice.leetcode

class EvaluateDivision {



    private class Node(var parent: String, var weight: Double)

    fun calcEquation(equations: List<List<String>>, values: DoubleArray, queries: List<List<String>>): DoubleArray {
        val variables = mutableMapOf<String, Node>()

        for (i in equations.indices) {
            val equation = equations[i]
            val variable1 = equation[0]
            val variable2 = equation[1]
            val value = values[i]

            union(variables, variable1, variable2, value)
        }

        val results = DoubleArray(queries.size)

        for (i in queries.indices) {
            val query = queries[i]
            val variable1 = query[0]
            val variable2 = query[1]

            results[i] = if (variable1 in variables && variable2 in variables) {
                val root1 = findRoot(variables, variable1)
                val root2 = findRoot(variables, variable2)

                if (root1 == root2) {
                    variables[variable1]!!.weight / variables[variable2]!!.weight
                } else {
                    -1.0
                }
            } else {
                -1.0
            }
        }

        return results
    }

    private fun union(
        variables: MutableMap<String, Node>,
        variable1: String,
        variable2: String,
        value: Double
    ) {
        val root1 = findRoot(variables, variable1)
        val root2 = findRoot(variables, variable2)

        if (root1 != root2) {
            variables[root1]!!.parent = root2
            variables[root1]!!.weight = value * variables[variable2]!!.weight / variables[variable1]!!.weight
        }
    }

    private fun findRoot(variables: MutableMap<String, Node>, variable: String): String {
        if (variables[variable]!!.parent != variable) {
            val parent = variables[variable]!!.parent
            val root = findRoot(variables, parent)
            variables[variable]!!.parent = root
            variables[variable]!!.weight *= variables[parent]!!.weight
        }
        return variables[variable]!!.parent
    }





    fun calcEquation1(equations: List<List<String>>, values: DoubleArray, queries: List<List<String>>): DoubleArray {

        val graph = mutableMapOf<String, MutableMap<String, Double>>()
        val res = DoubleArray(queries.size) { -1.0 }
        equations.forEachIndexed { index, (varA, varB) ->
//            val varA = eq[0] // variable 1
//            val varB = eq[1] // variable 2
            graph.putIfAbsent(varA, mutableMapOf())
            graph.putIfAbsent(varB, mutableMapOf())
            graph[varA]?.set(varB, values[index])
            graph[varB]?.set(varA, 1 / values[index])
        }


        fun dfs(varA: String, varB: String, seen: HashSet<String>, pathProduct: Double): Double {
            if (!graph.containsKey(varA) || !graph.containsKey(varB)) return -1.0

            if (varA == varB) return pathProduct

            seen.add(varA)
            for (entry in graph[varA]!!.entries) {
                if (seen.contains(entry.key))
                    continue
                val cal = dfs(entry.key, varB, seen, pathProduct * entry.value)
                if (cal != -1.0) {
                    return cal
                }
            }
            return -1.0

        }

        queries.forEachIndexed { index, (varA, varB) ->

            res[index] = dfs(varA, varB, hashSetOf(), 1.0)

        }
        return res
    }
}
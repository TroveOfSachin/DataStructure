package practice.leetcode

/**
 * #### [333. Largest BST Subtree](https://leetcode.com/problems/largest-bst-subtree/)
 */


fun main() {
    " ".toCharArray()
    val s = "leetscode"
    val dict = arrayOf("leet","code","leetcode")
    val ss = mutableSetOf<Char>()
    dict.forEach {
        ss.addAll(it.toList())
    }

    val output = (s.toSet()).intersect(ss)
    println(output)

}

class LargestBSTSubtree {




}
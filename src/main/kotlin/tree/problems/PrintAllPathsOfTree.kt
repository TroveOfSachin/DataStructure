package tree.problems

import print
import tree.base.BinaryTreeNode
import tree.base.SampleTreeData
import java.util.*


fun main() {
    val root = SampleTreeData.getTreeAsNode()
    val output = PrintAllPathsOfTree().getAllBFS(root)

    output.print("BFS Output")

    val output1 = PrintAllPathsOfTree().getAllDFS(root)
    output1.print("DFS Output")


}

class PrintAllPathsOfTree {

    fun getAllBFS(root: BinaryTreeNode?): ArrayList<ArrayList<Int>> {


        val result = arrayListOf<ArrayList<Int>>()
        if (root == null) return result


        val queue = LinkedList<BinaryTreeNode>()
        queue.offer(root)



        while (queue.isNotEmpty()) {
            val levelSize = queue.size
            val levelList = arrayListOf<Int>()
            for (i in 0 until levelSize) {
                val node = queue.poll()
                levelList.add(node.key)
                if (node.left != null) {
                    queue.offer(node.left)
                }
                if (node.right != null) {
                    queue.offer(node.right)
                }
            }
            result.add(levelList)

        }

        return result
    }


    fun getAllDFS(root: BinaryTreeNode?): ArrayList<ArrayList<Int>> {
        val paths = arrayListOf<ArrayList<Int>>()
        if (root == null) {
            return arrayListOf()
        }
        fun dfs(node: BinaryTreeNode?, path: ArrayList<Int>) {
            if (node == null) {
                return
            }
            path.add(node.key)
            if (node.left == null && node.right == null) {
                paths.add(ArrayList(path))
            } else {
                dfs(node.left, path)
                dfs(node.right, path)
            }
            path.removeAt(path.lastIndex)
        }
        dfs(root, arrayListOf())


        return paths
    }





}
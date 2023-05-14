package tree.problems

import print
import tree.base.BinaryTreeNode
import tree.base.SampleTreeData
import java.util.*
import kotlin.collections.ArrayList

/**
 *
 */


fun main() {
    val root = SampleTreeData.getTreeAsNode()
    val output = RightSideViewOfABinaryTree().rightView(root)
    output.print("Root To Leaf Path Sum Equal To K Possible?")
//    [4, 3, 5, 6, 1]
}
class RightSideViewOfABinaryTree {
    fun rightView(root: BinaryTreeNode?): ArrayList<Int> {
        if(root == null) return arrayListOf()
        val res = ArrayList<Int>()
        var rtView = 0
        val queue : Queue<BinaryTreeNode?> = LinkedList()
        queue.offer(root)
        while(queue.isNotEmpty()){
            val size = queue.size-1
            for(i in 0..size){
                val node = queue.poll()
                rtView = node?.value!!
                node.left?.let { queue.offer(it) }
                node.right?.let { queue.offer(it) }
            }
            res.add(rtView)
        }
        return res
    }
}
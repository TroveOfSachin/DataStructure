package tree.base

data class BinaryTreeNode(
    var key: Int, var value: Any? = null, var left: BinaryTreeNode? = null, var right: BinaryTreeNode? = null
) {
    override fun toString(): String {
//        return "[$key, ${value}${left.toString()}, ${right?.toString()}]"
        return "$key"
    }
}

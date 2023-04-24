package tree.base

data class BinaryTreeNode(
    var value: Int, var left: BinaryTreeNode? = null, var right: BinaryTreeNode? = null
) {
    override fun toString(): String {
        return "[$value, ${left.toString()}, ${right?.toString()}]"
//        return "$key"
    }
}

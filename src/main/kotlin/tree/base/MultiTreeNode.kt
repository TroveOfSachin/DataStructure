package tree.base

data class MultiTreeNode(
    var value: Int ,
    var childrens: MutableList<MultiTreeNode>? = null,
) {
    override fun toString(): String {
        return "[$value, ${childrens?.joinToString()}]"
    }
}

package tree

data class MultiTreeNode(
    var key: Int,
    var value: Int? = null,
    var childrens: List<MultiTreeNode?>? = null,
) {
    override fun toString(): String {
        return "[$key, $value, ${childrens?.joinToString()}]"
    }
}

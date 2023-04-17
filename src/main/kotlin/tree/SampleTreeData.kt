package tree

object SampleTreeData {

    // @formatter:off
    private val arr = arrayListOf(
        44,
        17, 88,
        8, 32, 65, 97,
        null, null, 28, null, 54, 82, 93, null,
        null, null, null, null, null, 29, null, null, null, null, 76, null, null, null, null, null,
        null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 80
    )
    // @formatter:on

    private val arr2 = arrayListOf(
        1,
        2
    )

    private val arr3 = arrayListOf(
        1,
        2, 3,
        4, 5, 6, 7,
        null, null, 8, 9
    )

    private val arr4 = arrayListOf(
        2,
        5, 4,
        0, 1, 3, 6
    )


    private val arr1 = (0..4).toList()


    private val root: BinaryTreeNode? = createTreeFromArray(arr1)


     fun createTreeFromArray(arr: List<Int?>?): BinaryTreeNode? {
        if (arr.isNullOrEmpty() || arr[0] == null) {
            return null
        }

        val root = BinaryTreeNode(arr[0]!!)
        createTreeFromArrayHelper(arr, root, 0)
        return root
    }

    private fun createTreeFromArrayHelper(arr: List<Int?>, node: BinaryTreeNode?, index: Int) {
        if (node == null) {
            return
        }

        val leftIndex = 2 * index + 1
        val rightIndex = 2 * index + 2

        if (leftIndex < arr.size && arr[leftIndex] != null) {
            node.left = BinaryTreeNode(arr[leftIndex]!!)
//        node.left?.parent = node
        }

        if (rightIndex < arr.size && arr[rightIndex] != null) {
            node.right = BinaryTreeNode(arr[rightIndex]!!)
//        node.right?.parent = node
        }

        createTreeFromArrayHelper(arr, node.left, leftIndex)
        createTreeFromArrayHelper(arr, node.right, rightIndex)
    }


    fun getTreeAsNode() = root

    fun getTreeAsList() = arr

}
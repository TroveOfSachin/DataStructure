package tree

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SuccessorPredecessorTest {

    val s = SuccessorPredecessor()

    private fun findPredecessor(input: ArrayList<Int?>, k: BinaryTreeNode, expected: Int) {
        assertEquals(expected, s.findPredecessor(SampleTreeData.createTreeFromArray(input), k)?.value)
    }

    @Test
    fun findPredecessor_000() {
        val input = arrayListOf<Int?>(
            1,
            2, 3,
            4, 5, 6, 7,
            null, null, 8, 9
        )
        val k = BinaryTreeNode(9)
        val expected = 5
        findPredecessor(input, k, expected)
    }


    @Test
    fun findPredecessor_001() {
        val input = arrayListOf<Int?>(
            1,
            2
        )
        val k = BinaryTreeNode(2)
        val expected = 1
        findPredecessor(input, k, expected)
    }

    @Test
    fun findPredecessor_002() {
        val input = arrayListOf<Int?>(
            1,
            2
        )
        val k = BinaryTreeNode(1)
        val expected = 1
        findPredecessor(input, k, expected)
    }

    @Test
    fun findPredecessor_003() {
        val input = arrayListOf<Int?>(
            1,
            2
        )
        val k = BinaryTreeNode(1)
        val expected = 1
        findPredecessor(input, k, expected)
    }
}
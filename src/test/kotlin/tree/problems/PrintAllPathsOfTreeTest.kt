package tree.problems

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import tree.base.BinaryTreeNode
import tree.base.SampleTreeData
import tree.base.SampleTreeData.createTreeFromArray

class PrintAllPathsOfTreeTest {

    val p = PrintAllPathsOfTree()
    private fun getAllPathWithSum(input: ArrayList<Int?>, k: Int, expected: ArrayList<ArrayList<Int>>) {
        val output = p.getAllPathWithSum(createTreeFromArray(input), k)
        assertEquals(expected, output)

    }

    @Test
    fun getAllPathWithSum_000() {

        val input =
            arrayListOf(
                10,
                25, 30,
                45, null, 40, 50
            )

        val sum = 80
        val expected = arrayListOf(
            arrayListOf(10, 25, 45),
            arrayListOf(10, 30, 40)
        )

        getAllPathWithSum(input, sum, expected)
    }

    @Test
    fun getAllPathWithSum_001() {

        val input =
            arrayListOf<Int?>(
                5,
                5, 5
            )

        val sum = 10
        val expected = arrayListOf(
            arrayListOf(5, 5),
            arrayListOf(5, 5)
        )

        getAllPathWithSum(input, sum, expected)
    }

    @Test
    fun getAllPathWithSum_002() {

        val input =
            arrayListOf<Int?>(
                12
            )

        val sum = 12
        val expected = arrayListOf(
            arrayListOf(12),
        )

        getAllPathWithSum(input, sum, expected)
    }


    @Test
    fun getAllPathWithSum_003() {

        val input =
            arrayListOf<Int?>(
                5,
                3, 1,
                null, null, 2, -1,
                null, null, 3
            )

        val sum = 8
        val expected = arrayListOf(
            arrayListOf(5, 3),
            arrayListOf(5, 1, 2),
            arrayListOf(5, 1, -1, 3),
        )

        getAllPathWithSum(input, sum, expected)
    }

    @Test
    fun getAllPathWithSum_004() {

        val input =
            arrayListOf<Int?>(
                0,
                0, 0,
                0, 0, 0, 0
            )

        val sum = 0
        val expected = arrayListOf(
            arrayListOf(0, 0, 0),
            arrayListOf(0, 0, 0),
            arrayListOf(0, 0, 0),
        )

        getAllPathWithSum(input, sum, expected)
    }

    @Test
    fun getAllPathWithSum_005() {

        val input =
            arrayListOf<Int?>(
                7,
                8, 3,
                0, null, null, null,
                null, -1
            )

        val sum = 14
        val expected = arrayListOf(
            arrayListOf(7, 8, 0, -1),

            )

        getAllPathWithSum(input, sum, expected)
    }


    @Test
    fun getAllPathWithSum_006() {

        val input =
            arrayListOf<Int?>(
                10000,
                10000, 0
            )

        val sum = 0
        val expected = arrayListOf(
            arrayListOf(-1),
        )

        getAllPathWithSum(input, sum, expected)
    }

    @Test
    fun getAllPathWithSum_007() {

        val input =
            arrayListOf<Int?>(
                10000,
                10000, 0
            )

        val sum = 0
        val expected = arrayListOf(
            arrayListOf(-1),
        )

        getAllPathWithSum(input, sum, expected)
    }

    @Test
    fun getAllPathWithSum_008() {

        val input =
            arrayListOf<Int?>(
                100,
                200
            )

        val sum = 100
        val expected = arrayListOf(
            arrayListOf(-1),
        )

        getAllPathWithSum(input, sum, expected)
    }

    @Test
    fun getAllPathWithSum_009() {

        val input =
            arrayListOf<Int?>(
                5,
                null, 3,
                null, 1,
                null, -1
            )

        val sum = 8
        val expected = arrayListOf(
            arrayListOf(5, 3, 1, -1),
        )

        getAllPathWithSum(input, sum, expected)
    }

    @Test
    fun getAllPathWithSum_010() {

        val input =
            arrayListOf<Int?>(
                2,
                5, null,
                10, null,
                -1
            )

        val sum = 17
        val expected = arrayListOf(
            arrayListOf(-1),
        )

        getAllPathWithSum(input, sum, expected)
    }

    @Test
    fun getAllPathWithSum_011() {

        val input =
            arrayListOf<Int?>(
                7,
                -7, -7,
                7, 7, null, 7,
                null, null, -7, -7, null, -7
            )

        val sum = 0
        val expected = arrayListOf(
            arrayListOf(7, -7, 7, -7),
            arrayListOf(7, -7, 7, -7),
            arrayListOf(7, -7, 7, -7),
        )

        getAllPathWithSum(input, sum, expected)
    }

    @Test
    fun getAllPathWithSum_012() {

        val input =
            arrayListOf<Int?>(
                -7,
                -7, -7,
                -7, -7, null, -7,
                null, null, -7, -7, null, -7
            )

        val sum = 28
        val expected = arrayListOf(
            arrayListOf(-1),
        )

        getAllPathWithSum(input, sum, expected)
    }

    @Test
    fun getAllPathWithSum_013() {

        val input =
            arrayListOf(
                100000,
                100000, null,
                100000, null,
                100000, null,
                100000, null,
                100000, null,
                100000, null,
                100000, null,
                100000, null,
                100000, null,
            )

        val sum = 1000000
        val expected = arrayListOf(
            arrayListOf<Int>().apply { repeat(10) { add(100000) } }
        )

        getAllPathWithSum(input, sum, expected)
    }
}
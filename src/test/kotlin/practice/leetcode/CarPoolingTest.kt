package practice.leetcode

import org.junit.jupiter.api.Test
import print
import java.lang.StringBuilder
import kotlin.test.assertEquals

class CarPoolingTest {

    private val carPooling = CarPooling()

    private fun carPoolingTest(input: Array<IntArray>, capacity: Int, expected: Boolean) {
        assertEquals(expected, carPooling.carPooling_Approach2(input, capacity))

    }

    @Test
    fun carPoolingTest1() {
        val input = arrayOf(
            intArrayOf(12, 93, 896),
            intArrayOf(77, 291, 904),
            intArrayOf(78, 424, 659),
            intArrayOf(41, 668, 962),
            intArrayOf(79, 2, 493),
            intArrayOf(7, 369, 840),
            intArrayOf(60, 229, 928),
            intArrayOf(41, 7, 163),
            intArrayOf(46, 621, 736),
            intArrayOf(97, 958, 984),
            intArrayOf(53, 832, 980),
            intArrayOf(15, 218, 815),
            intArrayOf(24, 74, 428),
            intArrayOf(12, 415, 959),
            intArrayOf(20, 81, 85),
            intArrayOf(45, 567, 601),
            intArrayOf(17, 266, 535),
            intArrayOf(65, 828, 943),
            intArrayOf(30, 416, 432),
            intArrayOf(27, 48, 142),
            intArrayOf(52, 413, 756),
            intArrayOf(21, 79, 274),
            intArrayOf(4, 260, 387),
            intArrayOf(49, 180, 314),
            intArrayOf(51, 628, 880),
            intArrayOf(94, 271, 462),
            intArrayOf(41, 163, 457),
            intArrayOf(30, 187, 925),
            intArrayOf(39, 349, 999),
            intArrayOf(5, 289, 809),
            intArrayOf(9, 214, 374),
            intArrayOf(10, 302, 534),
            intArrayOf(59, 412, 778),
            intArrayOf(77, 306, 497),
            intArrayOf(17, 594, 839),
            intArrayOf(53, 404, 892),
            intArrayOf(5, 525, 844),
            intArrayOf(89, 275, 619),
            intArrayOf(2, 27, 310),
            intArrayOf(79, 473, 755),
            intArrayOf(10, 812, 853),
            intArrayOf(76, 55, 549),
            intArrayOf(100, 643, 770),
            intArrayOf(36, 701, 997),
            intArrayOf(59, 354, 475),
            intArrayOf(70, 586, 924),
            intArrayOf(60, 146, 972),
            intArrayOf(32, 121, 305),
            intArrayOf(27, 75, 132),
            intArrayOf(17, 32, 758),
            intArrayOf(24, 389, 465),
            intArrayOf(81, 55, 258),
            intArrayOf(70, 74, 728),
            intArrayOf(36, 184, 703),
            intArrayOf(66, 603, 853),
            intArrayOf(63, 319, 964),
            intArrayOf(15, 355, 676),
            intArrayOf(69, 312, 521),
            intArrayOf(83, 344, 995),
            intArrayOf(41, 73, 439),
            intArrayOf(28, 384, 758),
            intArrayOf(90, 341, 365),
            intArrayOf(11, 473, 980),
            intArrayOf(49, 631, 737),
            intArrayOf(6, 116, 531),
            intArrayOf(99, 334, 460),
            intArrayOf(78, 358, 508),
            intArrayOf(26, 426, 823),
            intArrayOf(10, 312, 677),
            intArrayOf(48, 532, 711),
            intArrayOf(64, 433, 635),
            intArrayOf(62, 591, 765),
            intArrayOf(100, 150, 837),
            intArrayOf(24, 60, 945),
            intArrayOf(6, 72, 237),
            intArrayOf(21, 602, 838),
            intArrayOf(75, 255, 629),
            intArrayOf(54, 824, 935),
            intArrayOf(53, 169, 263),
            intArrayOf(49, 401, 744),
            intArrayOf(1, 603, 922),
            intArrayOf(88, 284, 984),
            intArrayOf(25, 896, 998),
            intArrayOf(13, 379, 493),
            intArrayOf(2, 293, 295),
            intArrayOf(31, 106, 600),
            intArrayOf(91, 284, 631),
            intArrayOf(42, 16, 880),
            intArrayOf(89, 62, 803),
            intArrayOf(96, 168, 279),
            intArrayOf(8, 731, 902),
            intArrayOf(44, 348, 755),
            intArrayOf(68, 462, 537),
            intArrayOf(96, 694, 913),
            intArrayOf(51, 190, 651),
            intArrayOf(7, 92, 179),
            intArrayOf(91, 5, 65),
            intArrayOf(14, 338, 818),
            intArrayOf(98, 423, 953),
            intArrayOf(15, 636, 664)
        )

        input.sortBy { it[1] }

        val x = StringBuilder()
        input.forEach { x.append(it.joinToString(",", "[", "]")) }
        println(x.toString())

        val capacity = 2637
        val expected = false
        carPoolingTest(input, capacity, expected)

    }


    @Test
    fun carPoolingTest2() {
        val input = arrayOf(
            intArrayOf(9, 3, 4),
            intArrayOf(9, 1, 7),
            intArrayOf(4, 2, 4),
            intArrayOf(7, 4, 5)
        )
        val capacity = 23
        val expected = true
        carPoolingTest(input, capacity, expected)
    }

    @Test
    fun carPoolingTest3() {
        val input = arrayOf(
            intArrayOf(41, 7, 163),
            intArrayOf(41, 163, 457),

            )
        val capacity = 500
        val expected = true
        carPoolingTest(input, capacity, expected)
    }


}
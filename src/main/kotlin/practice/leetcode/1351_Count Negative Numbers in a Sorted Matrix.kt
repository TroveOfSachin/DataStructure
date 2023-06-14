package practice.leetcode

/**
 * #### (1351. Count Negative Numbers in a Sorted Matrix)[https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/]
 */

fun main() {
    val c = CountNegativeNumbersInSortedMatrix()
    c.countNegatives(intArrayOf( -1, -1, 1, 2, 3,4).sortedArray())
}

class CountNegativeNumbersInSortedMatrix {

    fun countNegatives(grid: IntArray): Int {


        var mid = grid.size/2
        while (mid>=0 || mid <grid.size){
            if(grid[mid] == 0){

            }
        }



        fun count(left: Int, right: Int): Int {
            if (grid[right] < 0) return right - left + 1
            if (grid[left] >= 0) return 0


            val mid = (left + right) / 2
            return count(left, mid) + count(mid + 1, right)

        }

        val cnt = count(0, grid.size - 1)
        val x = maxOf(cnt, grid.size - cnt )
//        for (r in grid) {
//            cnt +=
//        }

        println(x)
        return x
    }


}
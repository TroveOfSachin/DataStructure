package practice.sorting

import print
import swap


/**
 * ####Problem
 *
 * ### Dutch National Flag
 * Given some balls of three colors arranged in a line, rearrange them such that all the red balls go first, then green and then blue ones.
 *
 * Do rearrange the balls in place. A solution that simply counts colors and overwrites the array is not the one we are looking for.
 *
 * This is an important problem in search algorithms theory proposed by Dutch computer scientist Edsger Dijkstra. Dutch national flag has three colors (albeit different from ones used in this problem).
 *
 * ### Example
 * ````
 * {
 * "balls": ["G", "B", "G", "G", "R", "B", "R", "G"]
 * }
 * ````
 * ### Output
 * ````
 * ["R", "R", "G", "G", "G", "G", "B", "B"]
 * ````
 *
 * There are a total of 2 red, 4 green and 2 blue balls. In this order they appear in the correct output.
 *
 * ### Constraints:
 * - 1 <= n <= 100000
 * - Do this in ONE pass over the array, NOT TWO passes
 * - Solution is only allowed to use constant extra memory
 */

fun main() {
    val balls = arrayListOf('G', 'B', 'G', 'G', 'R', 'B', 'R', 'G')

    val output = DutchNationalFlag().reArrange(balls)
    output.print("Output")


}

class DutchNationalFlag {

    fun reArrange(balls: ArrayList<Char>): ArrayList<Char> {
        var red = 0
        var blue = balls.size - 1
        var green = 0
        while (green <= blue) {
            if (balls[green] == 'R') {
                balls.swap(green++, red++)
            } else if (balls[green] == 'B')
                balls.swap(green, blue--)
            else green++

        }
        return balls
    }

}


/*

    r = 0
    b = n-1




    ['G', 'B', 'G', 'G', 'R', 'B', 'R', 'G']

    if A[i] == 'R' :
        swap A[r++ , i]
    else if A[i] == 'B'
        swap A[b-- , i]








 */
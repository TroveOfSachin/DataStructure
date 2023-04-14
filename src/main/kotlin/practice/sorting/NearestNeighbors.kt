package practice.sorting


/**
 * #### Nearest Neighbors
 * Given coordinates of a point p and n other points on a two-dimensional surface, find k points out of n which are the nearest to point p.
 *
 * Distance is measured by the standard Euclidean method.
 * ````
 * Example One
 * {
 *      "p_x": 1,
 *      "p_y": 1,
 *      "k": 1,
 *      "n_points": [
 *          [0, 0],
 *          [1, 0]
 *      ]
 * }
 * Output:
 * [
 *      [1, 0]
 * ]
 * The distance of point {0, 0} from point p{1, 1} is sqrt(2) and that of point {1, 0} is 1. We need to choose 1(k) point having the minimum distance from point p. So it is {1, 0}.
 *
 * Example Two
 * {
 *      "p_x": 1,
 *      "p_y": 1,
 *      "k": 2,
 *      "n_points": [
 *          [1, 0],
 *          [2, 1],
 *          [0, 1]
 *      ]
 * }
 * Output:
 * [
 *      [1, 0],
 *      [2, 1]
 * ]
 * ````
 * We can see that there are all the points are at the same distance from point p. So the answer can be any 2 points. Here {{1, 0}, {0, 1}} and {{2, 1}, {0, 1}} are all equally acceptable answers.
 *
 * ### Notes
 * #### Constraints:
 *
 * 1 <= n <= 100000
 * k <= n
 * -1000000000 <= coordinates of points <=1000000000
 */

fun main() {

}
class NearestNeighbors {
}
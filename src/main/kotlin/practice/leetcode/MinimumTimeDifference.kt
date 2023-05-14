package practice.leetcode


fun main() {
    val input = listOf(
        "23:59",
        "00:00",
        "23:59",
        "00:00",
        "23:59",
        "00:00",
        "23:59",
        "00:00",
        "23:59",
        "00:00",
        "23:59",
        "00:00",
    )
    val output = MinimumTimeDifference().findMinDifference(input)
    println("$output")
}




class MinimumTimeDifference {






    fun findMinDifference(timePoints: List<String>): Int {


        for (i in timePoints.indices step 2) {
            println(timePoints[i])
        }

        if (timePoints.size > 24 * 60) return 0

        val time = mutableListOf<Int>()
        timePoints.map {
            val (hours, minutes) = it.split(":").map { time -> time.toInt() }
            time.add(hours * 60 + minutes)
        }
        time.sort()
        time.add(time[0] + 24 * 60)

        var result = 24 * 60

        for (i in 1 until timePoints.size) {
            result = Math.min(result, (time[i] - time[i - 1]))
        }


        return result


    }
}
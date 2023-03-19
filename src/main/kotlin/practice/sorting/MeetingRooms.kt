package practice.sorting

import kotlin.collections.ArrayList

/**

Given a list of meeting intervals where each interval consists of a start and an end time, check if a person can attend all the given meetings such that only one meeting can be attended at a time.

Example: 1

{
"intervals": [[1, 5], [5, 8], [10, 15]]
}

output: 1


Example: 2
{
"intervals": [[1, 5], [4, 8]]
}
output: 0


 */


fun main() {
    val meetingRooms = MeetingRooms()

    val inputData = arrayListOf(arrayListOf(1, 5), arrayListOf(4, 8), arrayListOf(10, 15))
    val canAttendAllMeetings = meetingRooms.canAttendAllMeetings(inputData)

    println( if(canAttendAllMeetings == 1 ) "Can Attend All Meetings" else "Cannot Attend All Meetings" )
}

class MeetingRooms {

    fun canAttendAllMeetings(intervals: ArrayList<ArrayList<Int>>): Int {

        // Sorting all schedule in ascending order so that we can compare the overlapping schedule
        intervals.sortBy { it[0] }

        if (intervals.size <= 1) return 1

        for (scheduleIndex in 0 until intervals.lastIndex) {
            val schedule = intervals[scheduleIndex]
            val nextSchedule = intervals[scheduleIndex + 1]

            if (schedule[1] > nextSchedule[0]) {
                return 0
            }
        }

        return 1

    }

}
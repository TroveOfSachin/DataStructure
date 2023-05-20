package backbase

import java.util.*
import kotlin.collections.ArrayDeque


data class Student(val id: Int, val name: String, val subscribedCourses: List<Course>)
data class Course(val id: Int, val name: String, val isPaid: Boolean)

class Test {


    fun getPaidCoursesWithTheNumbersOfSubscribedStudents(
        coursesCount: Int,
        repository: Iterable<Student>
    ): Map<Course, Int> {


        // declaring result for output
        val result = mutableMapOf<Course, Int>()

        // iterating all the students to get their registered courses.
        repository.forEach { student ->

            // iterating all the courses respect to student and checking if that cource is paid or not
            // if it is paid adding it to the list and increment the counter of number of student
            student.subscribedCourses.forEach {
                if (it.isPaid) {
                    result[it] = result.getOrDefault(it, 0) + 1
                }
            }

        }
        // sorting map by descending order by number of students.
        // Values represent the number of students not the key.
        // if it was key then we can use the sorted Map but now we have to explictly sort the values


        result.entries.removeIf { it.value == 0 }

        val sortedCourse = result.entries.sortedByDescending {
            it.value
        }

        val limitedCourse = sortedCourse.take(coursesCount)



        return limitedCourse.associate {
            it.toPair()
        }


    }


}


object Main {

    @JvmStatic
    fun main(args: Array<String>) {
        linkedList()
    }

    fun linkedList() {
        val fifo = LinkedList<Int>()
        for (i in 1..5) {
            fifo.add(i)
        }
        println("FIFO : ")
        while (!fifo.isEmpty()) {
            print("${fifo.pop()}, ")
        }
        // it prints
        // 1, 2, 3, 4, 5 as FIFO

        val lifo = LinkedList<Int>()
        for (i in 1..5) {
            lifo.push(i)
        }
        println("\nLIFO : ")
        while (!lifo.isEmpty()) {
            print("${lifo.pop()}, ")
        }
        // it prints
        // 5, 4, 3, 2, 1 as LIFO
    }


    fun stack() {
        val fifo = Stack<Int>()
        for (i in 1..5) {
            fifo.add(i)
        }
        println("FIFO : ")
        while (!fifo.isEmpty()) {
            print("${fifo.pop()}, ")
        }
        // it prints
        // 1, 2, 3, 4, 5 as FIFO

        val lifo = Stack<Int>()
        for (i in 1..5) {
            lifo.push(i)
        }
        println("\nLIFO : ")
        while (!lifo.isEmpty()) {
            print("${lifo.pop()}, ")
        }
        // it prints
        // 5, 4, 3, 2, 1 as LIFO
    }
}


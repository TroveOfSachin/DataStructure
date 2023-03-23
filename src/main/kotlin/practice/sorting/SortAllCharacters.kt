package practice.sorting


import java.util.PriorityQueue


fun main() {

    val input = arrayListOf('a', 's', 'd', 'f', 'g', '*', '&', '!', 'z', 'y', '*')
    val output = SortAllCharacters().sortUsingAsciiLength(input)


    println(output)

}

class SortAllCharacters {

    fun sortWayWithHeap(input: ArrayList<Char>): ArrayList<Char> {
        val maxHeap = PriorityQueue<Char>()
        maxHeap.addAll(input)
        val output = arrayListOf<Char>()
        while (maxHeap.isNotEmpty()) {
            output.add(maxHeap.poll())
        }
        return output
    }


    fun sortWayWithHashMap(input: ArrayList<Char>): ArrayList<Char> {


        var bucketMap = mutableMapOf<Char, Int>()
        input.forEach {
            bucketMap[it] = bucketMap.getOrDefault(it, 0) + 1
        }

        val output = arrayListOf<Char>()

        bucketMap = bucketMap.toSortedMap { o1, o2 -> o1 - o2 }

        bucketMap.forEach { (key, value) ->
            repeat(value) { output.add(key) }
        }
        return output

    }

    fun sortUsingAsciiLength(input: ArrayList<Char>): ArrayList<Char> {

        val asciiCounter = IntArray(128)

        input.forEach {
            asciiCounter[it.code] = asciiCounter[it.code]+1
        }
        input.clear()
        asciiCounter.forEachIndexed { index, _ ->
            repeat(asciiCounter[index]) { input += index.toChar() }
        }
        return input


    }


}
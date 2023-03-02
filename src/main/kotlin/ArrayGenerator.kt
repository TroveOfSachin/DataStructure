import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import kotlin.math.abs
import kotlin.random.Random

fun main() {


    RandomArrayGenerator.generateLargeUniqueNumberArray(150)
}

object RandomArrayGenerator {
    private const val fileName = "src/generatedData/Arrays.txt"

    /**
     * @param numberOfElements Default value is [Int.MAX_VALUE]/1000.
     * All the arrays are stored at [src/generatedData/Arrays.txt](src/generatedData/Arrays.txt)
     */
    fun generateLargeUniqueNumberArray(numberOfElements: Int = Int.MAX_VALUE): Array<Int> {
        val random = Random(0)
        var set = mutableSetOf<Int>()
        val maxLimit = getRandomNumberLastLimit(numberOfElements)

        do {
            set.add(abs(random.nextInt(0, maxLimit)))
        } while (set.size < numberOfElements)



        println("Set Created with set Size = ${set.size} with Max Limit = $maxLimit")


        val arrayFile = File(fileName)

        arrayFile.createNewFile()

        arrayFile.bufferedWriter().use { out ->

            out.write(set.joinToString(",", "[", "]"))
        }


        println("Wrote to file")

        println("Random Array Generated Successfully.")
        return set.toTypedArray()
    }


    private fun getRandomNumberLastLimit(numberOfElements: Int, maxNumber: Int = Int.MAX_VALUE): Int {
        return if ((maxNumber / 2) <= numberOfElements) maxNumber
        else getRandomNumberLastLimit(numberOfElements, maxNumber / 2)
    }

    /**
     * @param numberOfElements
     */

    fun getArray(numberOfElements: Int = Int.MAX_VALUE): Array<Int> {

        val file = File(fileName)
        if (!file.exists()) {
            generateLargeUniqueNumberArray(numberOfElements)
        }

        val arrayFile = FileReader(fileName)


        val br = BufferedReader(arrayFile)

        var line = br.readText()
        line = line.replace("[", "").replace("]", "")
        val inputList = line.split(",")
        return if (inputList.size == numberOfElements)
            inputList.map { it.toInt() }.toTypedArray()
        else {
            File(fileName).delete()
            getArray(numberOfElements)
        }
    }
}
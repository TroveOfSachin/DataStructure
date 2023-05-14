package practice.leetcode


/**
 *
 * ## [6417. Frequency Tracker](https://leetcode.com/contest/weekly-contest-344/problems/frequency-tracker/)
 * Design a data structure that keeps track of the values in it and answers some queries regarding their frequencies.
 *
 * Implement the FrequencyTracker class.
 *
 * FrequencyTracker(): Initializes the FrequencyTracker object with an empty array initially.
 * void add(int number): Adds number to the data structure.
 * void deleteOne(int number): Deletes one occurence of number from the data structure. The data structure may not contain number, and in this case nothing is deleted.
 * bool hasFrequency(int frequency): Returns true if there is a number in the data structure that occurs frequency number of times, otherwise, it returns false.
 *
 *
 * Example 1:
 *
 * Input
 * ["FrequencyTracker", "add", "add", "hasFrequency"]
 * [[], [3], [3], [2]]
 * Output
 * [null, null, null, true]
 *
 * Explanation
 * FrequencyTracker frequencyTracker = new FrequencyTracker();
 * frequencyTracker.add(3); // The data structure now contains [3]
 * frequencyTracker.add(3); // The data structure now contains [3, 3]
 * frequencyTracker.hasFrequency(2); // Returns true, because 3 occurs twice
 *
 * Example 2:
 *
 * Input
 * ["FrequencyTracker", "add", "deleteOne", "hasFrequency"]
 * [[], [1], [1], [1]]
 * Output
 * [null, null, null, false]
 *
 * Explanation
 * FrequencyTracker frequencyTracker = new FrequencyTracker();
 * frequencyTracker.add(1); // The data structure now contains [1]
 * frequencyTracker.deleteOne(1); // The data structure becomes empty []
 * frequencyTracker.hasFrequency(1); // Returns false, because the data structure is empty
 *
 * Example 3:
 *
 * Input
 * ["FrequencyTracker", "hasFrequency", "add", "hasFrequency"]
 * [[], [2], [3], [1]]
 * Output
 * [null, false, null, true]
 *
 * Explanation
 * FrequencyTracker frequencyTracker = new FrequencyTracker();
 * frequencyTracker.hasFrequency(2); // Returns false, because the data structure is empty
 * frequencyTracker.add(3); // The data structure now contains [3]
 * frequencyTracker.hasFrequency(1); // Returns true, because 3 occurs once
 *
 *
 *
 * Constraints:
 *
 * 1 <= number <= 105
 * 1 <= frequency <= 105
 * At most, 2 * 105 calls will be made to add, deleteOne, and hasFrequency in total.
 */


fun main() {

//    ["FrequencyTracker","add","deleteOne","add","add","add","add","add","hasFrequency","deleteOne","hasFrequency","hasFrequency","deleteOne"]
//    [[],[10],[2],[2],[2],[2],[3],[9],[1],[4],[2],[1],[4]]
//    [null,null,null,null,null,null,null,null,true,null,false,true,null]
    val ft = FrequencyTracker()
    ft.add(10)
    ft.deleteOne(2)
    ft.add(2)
    ft.add(2)
    ft.add(2)
    ft.add(2)
    ft.add(3)
    ft.hasFrequency(9) // false
    ft.deleteOne(1)// false
    ft.hasFrequency(2) // false
    ft.hasFrequency(1) // true
    ft.deleteOne(4)//


}


class FrequencyTracker() {
    private val frequencies = mutableMapOf<Int, Int>()
    private val counter = mutableMapOf<Int, MutableMap<Int, Int>>()

    private var maxFreq = 0

    fun add(number: Int) {
        val existingFreq = frequencies.getOrDefault(number, 0)
        frequencies[number] = existingFreq + 1

        updateFrequency(number, existingFreq, true)
    }

    fun deleteOne(number: Int) {
        val frequency = frequencies.getOrDefault(number, 0)
        if (frequency > 0) {
            frequencies[number] = frequency - 1
            if (frequency - 1 <= 0) {
                frequencies.remove(number)
            }

            updateFrequency(number, frequency, false)
        }


    }

    fun hasFrequency(frequency: Int): Boolean {
        return (counter.getOrDefault(frequency, mutableMapOf())).isNotEmpty()
    }


    private fun updateFrequency(number: Int, existingFreq: Int, isAdd: Boolean) {


        fun add(freq: Int) {
            // updating new Frequency
            val updatedFreqCounter = counter[freq]
            updatedFreqCounter?.let {
                it[number] = it.getOrDefault(number, 0) + 1
            } ?: run {
                counter[freq] = mutableMapOf(number to freq)
            }
        }

        fun remove(freq: Int) {
            val existingFreqCounter = counter[freq]
            existingFreqCounter?.let {
                it[number] = it.getOrDefault(number, 0) - 1
                if (it[number]!! <= 0) {
                    it.remove(number)
                }
            }
        }

        if (isAdd) {
            add(existingFreq + 1)
            remove(existingFreq)
        } else {
            remove(existingFreq)
            add(existingFreq - 1)
        }


    }


}
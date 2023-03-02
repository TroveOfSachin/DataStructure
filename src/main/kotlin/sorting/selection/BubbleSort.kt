package sorting.selection

import RandomArrayGenerator


fun main() {
    val bubbleSort = BubbleSort()
    val sampleArray = RandomArrayGenerator.getArray(10)
    println("UnSorted Array")
    println(sampleArray.joinToString(",", "[", "]"))
    println("Sorted Array")
    bubbleSort.sort(sampleArray)
    println(sampleArray.joinToString(",", "[", "]"))
}


/**
 * First Simple SDA algorithm for Sorting is [BubbleSort]
 *
 * `` ``
 * ### Algorithm for [BubbleSort]
 * ````
 * 1. Take input of unsorted array
 * 2. Iterate through the array from 0 to (n-1)
 * 3. Set default minimum value with loop index value
 * 4. Set default swap value index  with loop index
 * 5. Iterate through the array from outer iteration index to (n-1)
 * 6. check if default minimum value is greater or not
 * 7. if yes then swap values
 * 8. return sorted array
 * ````
 *
 * ### Pseudocode for [BubbleSort]
 * ````
 * fun bubbleSort(array:IntArray){
 *     n = array.size
 *     for(outerIndex in n-1){
 *         smallestValue = array[outerIndex]
 *         swapIndex = outerIndex
 *         for(innerIndex in outerIndex in n-1)
 *             if(smallestValue > array[innerIndex]){
 *                  smallestValue = array[innerIndex]
 *                  swapIndex = innerIndex
 *             }
 *          }
 *          array[swapIndex] = array[outerIndex]
 *          array[outerIndex] = smallestValue
 *     }
 *
 * }
 *
 * ````
 *
 */
class BubbleSort {
    fun sort(sampleArray: Array<Int>) {

        // two loops will be iterated to route through all the elements

        for (outerIndex in sampleArray.indices) {

            // keeping track for smallest value to at outerIndex to compare with value in inner loop
            var smallestValue = sampleArray[outerIndex]
            // keeping track to the smallest value index found in the inner loop
            var smallestValueIndex = outerIndex

            for (innerIndex in (outerIndex + 1)..sampleArray.lastIndex) {

                // checking condition to check if there is any other smaller value
                // if smaller value found then assigning that value and its index for swapping outer-index to inner-index.

                // Note:
                // 1. smallestValueIndex used as temporary variable BUT we have used it for index not for actual value as index are always in Int whereas values can be anything like Long, Double, String or Object etc.
                // 2. Simple purpose to avoid utilizing the extra memory.
                // For Example,
                //      a: if we have to swap sentences then temporary variable utilize the memory equivalent to
                //         that sentence length.
                //

                if (smallestValue > sampleArray[innerIndex]) {
                    smallestValue = sampleArray[innerIndex]
                    smallestValueIndex = innerIndex
                }
            }
            // swapping values
            sampleArray[smallestValueIndex] = sampleArray[outerIndex]
            sampleArray[outerIndex] = smallestValue

        }
    }
    
}
import java.util.AbstractCollection

/**
 * Is an extension function for swapping elements into an array
 *
 * It will change swapped internally with
 *
 * `Time Complexity : O(1)`
 *
 * `Space Complexity : O(1)`
 *
 * @param elementIndex index of element to be swapped
 * @param targetIndex index of the swapping targeted element

 */
fun <T> Array<T>.swap(elementIndex: Int, targetIndex: Int) {
    if (elementIndex == targetIndex) return
    val temp = this[elementIndex]
    this[elementIndex] = this[targetIndex]
    this[targetIndex] = temp
}

fun <T> ArrayList<T>.swap(elementIndex: Int, targetIndex: Int) {
    if (elementIndex == targetIndex) return
    val temp = this[elementIndex]
    this[elementIndex] = this[targetIndex]
    this[targetIndex] = temp
}


fun <T> Array<T>.print(message: String) {
    println(message)
    println(this.contentToString())
}

fun <T> List<T>.print(message: String) {
    println(message)
    println(this.joinToString())
}
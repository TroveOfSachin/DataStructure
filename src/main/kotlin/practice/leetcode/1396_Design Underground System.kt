package practice.leetcode


fun main() {
    val us = UndergroundSystem()
//"checkIn","getAverageTime","checkOut","getAverageTime"]
//[10,"Leyton",24],["Leyton","Waterloo"],[10,"Waterloo",38],["Leyton","Waterloo"]]
    us.checkIn(45, "Leyton", 3)
    us.checkIn(32, "Paradise", 8)
    us.checkIn(27, "Leyton", 10)
    us.checkOut(45, "Waterloo", 15)
    us.checkOut(27, "Waterloo", 20)
    us.checkOut(32, "Cambridge", 22)
    us.getAverageTime("Paradise", "Cambridge")
    us.getAverageTime("Leyton", "Waterloo")
    us.checkIn(10, "Leyton", 24)
    us.getAverageTime("Leyton", "Waterloo")
    us.checkOut(10, "Waterloo", 38)
    us.getAverageTime("Leyton", "Waterloo")
}


class UndergroundSystem() {

    private val empMap = mutableMapOf<Int, Pair<String, Int>>()
    private val avgTime = mutableMapOf<Pair<String, String>, ArrayList<Int>>()

    fun checkIn(id: Int, ss: String, st: Int) {
        empMap[id] = Pair(ss, st)
    }

    fun checkOut(id: Int, es: String, et: Int) {
        val (ss, st) = empMap[id]!!
        val avPair = Pair(ss, es)
        if (avgTime.containsKey(avPair)) {
            avgTime[avPair]!!.add(et - st)
        } else {
            avgTime[avPair] = arrayListOf(et - st)
        }

    }

    fun getAverageTime(startStation: String, endStation: String): Double {

        val c = avgTime[Pair(startStation, endStation)]!!
        val res = c.sum().toDouble() / c.size
        println(res)
        return res
    }

}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * var obj = UndergroundSystem()
 * obj.checkIn(id,stationName,t)
 * obj.checkOut(id,stationName,t)
 * var param_3 = obj.getAverageTime(startStation,endStation)
 */
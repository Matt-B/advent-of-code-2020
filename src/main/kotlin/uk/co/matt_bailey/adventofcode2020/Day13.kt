package uk.co.matt_bailey.adventofcode2020

class Day13 {

    fun solvePart1(input: List<String>): Int {
        var time = input[0].toInt()
        var buses = input[1].split(",").filter { it != "x" }.map { it.toInt() }
        var times = mutableListOf<Int>()
        for(bus in buses) {
            times.add(time - time.rem(bus) + bus)
        }
        return buses[times.indexOf(times.minOrNull()!!)] * (times.minOrNull()!! - time)
    }

    fun solvePart2(input: List<String>): Long {
        var buses = input[1].split(",")
        var time = 0L

        var checkInterval = buses.first().toLong()
        for(index in 1 until buses.size) {
            if(buses[index] != "x") {
                while(((time + index) % buses[index].toLong()) != 0L) {
                    time += checkInterval
                }
                checkInterval *= buses[index].toLong()
            }
        }
        return time
    }
}
package uk.co.matt_bailey.adventofcode2020

class Day05 {

    fun solvePart1(input: List<String>): Int {
        var highestId = 0
        for(line in input) {
            var row = calculateRow(line)
            var column = calculateColumn(line)
            var seatId = row * 8 + column
            if(seatId > highestId) {
                highestId = seatId
            }
        }
        return highestId
    }

    private fun calculateRow(input: String): Int {
        var upperBound = 127
        var lowerBound = 0
        repeat(7) { index ->
            if(input[index] == 'F') {
                upperBound -= (((upperBound - lowerBound) / 2) + 1)
            } else {
                lowerBound += (((upperBound - lowerBound) / 2) + 1)
            }
        }
        return lowerBound
    }

    private fun calculateColumn(input: String): Int {
        var upperBound = 7
        var lowerBound = 0
        repeat(3) { index ->
            if(input[(input.length - 3) + index] == 'L') {
                upperBound -= (((upperBound - lowerBound) / 2) + 1)
            } else {
                lowerBound += (((upperBound - lowerBound) / 2) + 1)
            }
        }
        return lowerBound
    }

    fun solvePart2(input: List<String>): Int {
        var seatPlan = mutableMapOf<Int, MutableList<Int>>()
        for(line in input) {
            var row = calculateRow(line)
            var column = calculateColumn(line)
            if(seatPlan[row] == null) {
                seatPlan[row] = mutableListOf(column)
            } else {
                var rowPlan = seatPlan[row]
                if (rowPlan != null) {
                    rowPlan.add(column)
                    seatPlan[row] = rowPlan
                }
            }
        }
        seatPlan = seatPlan.toSortedMap()
        for((rowNumber, row) in seatPlan) {
            if((row.size < 8) and ((rowNumber != seatPlan.keys.first()) and (rowNumber != seatPlan.keys.last()))) {
                for (index in 0..7) {
                    if(!row.contains(index)) {
                        return rowNumber * 8 + index
                    }
                }
            }
        }
        return -1
    }
}
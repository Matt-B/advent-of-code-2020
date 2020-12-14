package uk.co.matt_bailey.adventofcode2020

class Day11 {

    lateinit var seatPlan: List<CharArray>

    fun solvePart1(input: List<String>): Int {
        seatPlan = input.map { it.toCharArray() }
        var changes = 1
        while(changes != 0) {
            changes = applyRules()
        }
        return countOccupiedSeats()
    }

    private fun applyRules(): Int {
        var changes = 0
        var newSeatPlan = mutableListOf<CharArray>()
        seatPlan.forEachIndexed { rowIndex, row ->
            var newRow = CharArray(seatPlan[rowIndex].size)
            row.forEachIndexed { seatIndex, seat ->
                var occupiedSeats = checkHowManyAdjoiningSeatsAreOccupied(rowIndex, seatIndex)
                when {
                    (seat == 'L') and (occupiedSeats == 0) -> {
                        newRow[seatIndex] = '#'
                        changes++
                    }
                    (seat == '#') and (occupiedSeats >= 4) -> {
                        newRow[seatIndex] = 'L'
                        changes++
                    }
                    else -> {
                        newRow[seatIndex] = seat
                    }
                }
            }
            newSeatPlan.add(newRow)
        }
        seatPlan = newSeatPlan
        return changes
    }

    private fun applyNewRules(): Int {
        var changes = 0
        var newSeatPlan = mutableListOf<CharArray>()
        seatPlan.forEachIndexed { rowIndex, row ->
            var newRow = CharArray(seatPlan[rowIndex].size)
            row.forEachIndexed { seatIndex, seat ->
                var visibleOccupiedSeats = checkHowManyOccupiedSeatsCanBeSeen(rowIndex, seatIndex)
                when {
                    (seat == 'L') and (visibleOccupiedSeats == 0) -> {
                        newRow[seatIndex] = '#'
                        changes++
                    }
                    (seat == '#') and (visibleOccupiedSeats >= 5) -> {
                        newRow[seatIndex] = 'L'
                        changes++
                    }
                    else -> {
                        newRow[seatIndex] = seat
                    }
                }
            }
            newSeatPlan.add(newRow)
        }
        seatPlan = newSeatPlan
        return changes
    }

    private fun checkHowManyAdjoiningSeatsAreOccupied(rowIndex: Int, seatIndex: Int): Int {
        var seatRange = (seatIndex - 1) until (seatIndex + 2)
        var rowRange = (rowIndex - 1) until (rowIndex + 2)
        var occupiedSeats = 0
        for(rIndex in rowRange) {
            if((rIndex >= 0) and (rIndex < seatPlan.size)) {
                for (sIndex in seatRange) {
                    if ((sIndex >= 0) and (sIndex < seatPlan[rowIndex].size)) {
                        if ((seatPlan[rIndex][sIndex] == '#') and ("$rIndex,$sIndex" != "$rowIndex,$seatIndex")) {
                            occupiedSeats++
                        }
                    }
                }
            }
        }
        return occupiedSeats
    }

    private fun checkHowManyOccupiedSeatsCanBeSeen(rowIndex: Int, seatIndex: Int): Int {
        var visibleOccupiedSeats = 0
        var directions = listOf(Pair(0, -1), Pair(0, 1), Pair(-1, 0), Pair(1, 0), Pair(1, 1), Pair(-1, -1), Pair(-1, 1), Pair(1, -1))
        for(direction in directions) {
            if(checkDirection(rowIndex, seatIndex, direction.first, direction.second)) { visibleOccupiedSeats++}
        }
        return visibleOccupiedSeats
    }

    private fun checkDirection(rowIndex: Int, seatIndex: Int, rowIncrement: Int, seatIncrement:Int): Boolean {
        var reachedSeat = false
        var reachedEnd = false
        var currentSeat = seatIndex
        var currentRow = rowIndex
        while(!reachedEnd) {
            currentSeat += seatIncrement
            currentRow += rowIncrement
            when (currentRow) {
                in 0 until (seatPlan.size) -> {
                    if(currentSeat in 0 until (seatPlan[currentRow].size)) {
                        if(seatPlan[currentRow][currentSeat] == '#') {
                            reachedSeat = true
                            reachedEnd = true
                        } else if(seatPlan[currentRow][currentSeat] == 'L') {
                            reachedEnd = true
                        }
                    } else {
                        reachedEnd = true
                    }
                }
                else -> {
                    reachedEnd = true
                }
            }
        }
        return reachedSeat
    }

    private fun countOccupiedSeats(): Int {
        var emptySeats = 0
        for(row in seatPlan) {
            var emptySeatsInRow = row.count { it == '#' }
            emptySeats += emptySeatsInRow
        }
        return emptySeats
    }

    fun solvePart2(input: List<String>): Int {
        seatPlan = input.map { it.toCharArray() }
        var changes = 1
        while(changes != 0) {
            changes = applyNewRules()
        }
        return countOccupiedSeats()
    }
}
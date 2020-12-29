package uk.co.matt_bailey.adventofcode2020

class Day15 {

    fun solvePart1(input: List<String>): Int {
        val startingNumbers = input[0].split(',').map { it.toInt() }
        return findNumberInPosition(2020, startingNumbers)
    }

    private fun findNumberInPosition(position: Int, startingNumbers: List<Int>): Int {
        var turn = 0
        var lastNumber = startingNumbers.last()
        val memory = mutableMapOf<Int, Int>()
        for(number in startingNumbers) {
            turn++
            memory[number] = turn
        }
        while(turn < position) {
            val previousTurn = memory[lastNumber]
            memory[lastNumber] = turn
            lastNumber = if (previousTurn == null) { 0 } else { turn - previousTurn }
            turn++
        }
        return lastNumber
    }

    fun solvePart2(input: List<String>): Int {
        val startingNumbers = input[0].split(',').map { it.toInt() }
        return findNumberInPosition(30000000, startingNumbers)
    }
}
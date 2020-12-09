package uk.co.matt_bailey.adventofcode2020

class Day09 {

    fun solvePart1(input: List<String>, preamble: Int): Long {
        var xmasData: List<Long> = input.map{ it.toLong() }
        var solutionFound = false
        var currentIndex = preamble
        while(!solutionFound) {
            if(isValidSequence(xmasData.slice((currentIndex - preamble) until (currentIndex)).sorted(), xmasData[currentIndex])) {
                currentIndex++
            } else {
                solutionFound = true
            }
        }
        return xmasData[currentIndex]
    }

    private fun isValidSequence(sequence: List<Long>, target: Long): Boolean {
        return sequence.any { target - it in sequence }
    }

    fun solvePart2(input: List<String>, targetNumber: Long): Long {
        var xmasData: List<Long> = input.map { it.toLong() }
        var sumSequenceBounds = findSumSequence(xmasData, targetNumber)
        var sumSequence = xmasData.slice(sumSequenceBounds!!.first until sumSequenceBounds.second)
        return sumSequence.minOrNull()!! + sumSequence.maxOrNull()!!
    }

    private fun findSumSequence(sequence: List<Long>, target: Long): Pair<Int, Int>? {
        sequence.forEachIndexed { index, _ ->
            for (endBound in (index + 2) until (sequence.size - 1)) {
                var numbers = sequence.slice(index + 1 until endBound)
                if (numbers.sum() == target) {
                    return Pair(index + 1, endBound)
                }
            }
        }
        return null
    }

}
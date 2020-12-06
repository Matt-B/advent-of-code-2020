package uk.co.matt_bailey.adventofcode2020

class Day06 {

    fun solvePart1(input: List<String>): Int {
        var groupAnswers = mutableListOf<Char>()
        var sum = 0

        for(line in input) {
            if(line.isEmpty()) {
                sum += groupAnswers.distinct().size
                groupAnswers.clear()
            } else {
                for(char in line) {
                    groupAnswers.add(char)
                }
            }
        }
        sum += groupAnswers.distinct().size
        return sum
    }

    fun solvePart2(input: List<String>): Int {
        var groupAnswers = mutableMapOf<Char, Int>()
        var groupSize = 0
        var sum = 0

        for(line in input) {
            if(line.isEmpty()) {
                for((_, answerCount) in groupAnswers) {
                    if(answerCount == groupSize) {
                        sum++
                    }
                }
                groupAnswers.clear()
                groupSize = 0
            } else {
                groupSize++
                for(char in line) {
                    var answersSoFar = groupAnswers[char]
                    if(answersSoFar != null) {
                        groupAnswers[char] = answersSoFar + 1
                    } else {
                        groupAnswers[char] = 1
                    }
                }
            }
        }
        for((_, answerCount) in groupAnswers) {
            if(answerCount == groupSize) {
                sum++
            }
        }
        return sum
    }
}
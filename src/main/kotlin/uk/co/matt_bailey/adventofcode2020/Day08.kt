package uk.co.matt_bailey.adventofcode2020

class Day08 {

    fun solvePart1(input: List<String>): Int {
        var accumulator = 0
        var currentIndex = 0
        var completedInstructions = mutableListOf<Int>()
        var instruction = input[currentIndex]
        while(!completedInstructions.contains(currentIndex)) {
            completedInstructions.add(currentIndex)
            var result = doInstruction(instruction, accumulator, currentIndex)
            currentIndex = result.first
            accumulator = result.second
            instruction = input[currentIndex]
        }
        return accumulator
    }

    fun solvePart2(input: List<String>): Int {
        var mutableInput = input.toMutableList()
        var accumulatorAtCompletion = 0
        mutableInput.forEachIndexed() { index, line ->
            if(line.contains("jmp")) {
                var modifiedInput = mutableInput.toMutableList()
                modifiedInput[index] = line.replace("jmp", "nop")
                var result = completeProgram(modifiedInput)
                if(result.first == mutableInput.size) {
                    accumulatorAtCompletion = result.second
                }
            } else if(line.contains("nop")) {
                var modifiedInput = mutableInput.toMutableList()
                modifiedInput[index] = line.replace("nop", "jmp")
                var result = completeProgram(modifiedInput)
                if(result.first == mutableInput.size) {
                    accumulatorAtCompletion = result.second
                }
            }
        }
        return accumulatorAtCompletion
    }

    private fun completeProgram(input: List<String>): Pair<Int, Int> {
        var accumulator = 0
        var currentIndex = 0
        var completedInstructions = mutableListOf<Int>()
        var instruction = input[currentIndex]
        while(!completedInstructions.contains(currentIndex)) {
            completedInstructions.add(currentIndex)
            var result = doInstruction(instruction, accumulator, currentIndex)
            currentIndex = result.first
            accumulator = result.second
            if(currentIndex == input.size) {
                completedInstructions.add(currentIndex)
            } else {
                instruction = input[currentIndex]
            }
        }
        return Pair(currentIndex, accumulator)
    }

    private fun doInstruction(instruction: String, accumulator: Int, index: Int): Pair<Int, Int> {
        var expandedInstruction = instruction.split(" ")
        var currentIndex = index
        var currentAccumulatorValue = accumulator
        when(expandedInstruction[0]) {
            "nop" -> {
                currentIndex++
            }
            "acc" -> {
                currentAccumulatorValue += expandedInstruction[1].toInt()
                currentIndex++
            }
            "jmp" -> {
                currentIndex += expandedInstruction[1].toInt()
            }
        }
        return Pair(currentIndex, currentAccumulatorValue)
    }
}
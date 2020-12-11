package uk.co.matt_bailey.adventofcode2020

import java.util.*

class Day10 {

    fun solvePart1(input: List<String>): Int {
        var joltAdapters = input.map { it.toInt() }.sorted()
        var joltJumps = mutableMapOf(1 to 1, 2 to 0, 3 to 1)
        for(index in 0 until (joltAdapters.size - 1)) {
            joltJumps[joltAdapters[index + 1] - joltAdapters[index]] = joltJumps[joltAdapters[index + 1] - joltAdapters[index]]!! + 1
        }
        return joltJumps[1]!! * joltJumps[3]!!
    }

    fun solvePart2(input: List<String>): Long {
        var joltAdapters = input.map { it.toInt() }.sorted()
        var finishedPathMap = joltAdapters.fold(TreeMap(mapOf(Pair(0, 1L)))) { pathMap, joltAdapter ->
            pathMap[joltAdapter] = 0
            for (jolts in joltAdapter - 3 until joltAdapter) {
                pathMap[joltAdapter] = (pathMap[jolts] ?: 0) + pathMap[joltAdapter]!!
            }
            pathMap
        }
        return finishedPathMap.lastEntry().value
    }
}
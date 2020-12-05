package uk.co.matt_bailey.adventofcode2020

import org.junit.Test
import java.io.File

class Day05Test {

    @Test
    fun `Part 1 - Can solve provided example`() {

        val inputs = listOf(
            "FBFBBFFRLR",
            "BFFFBBFRRR",
            "FFFBBBFRRR",
            "BBFFBBFRLL"
        )

        val answer = Day05().solvePart1(inputs)

        assert(answer == 820)
    }

    @Test
    fun `Part 1 - Can solve full exercise`() {

        val inputs = File("src/test/resources/day5.txt").readLines()

        val answer = Day05().solvePart1(inputs)

        assert(answer == 991)
    }

    @Test
    fun `Part 2 - Can solve full exercise`() {

        val inputs = File("src/test/resources/day5.txt").readLines()

        val answer = Day05().solvePart2(inputs)

        assert(answer == 534)
    }
}
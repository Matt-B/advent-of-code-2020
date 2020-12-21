package uk.co.matt_bailey.adventofcode2020

import org.junit.Test
import java.io.File

class Day13Test {

    @Test
    fun `Part 1 - Can solve provided example`() {

        val inputs = listOf(
            "939",
            "7,13,x,x,59,x,31,19"
        )

        val answer = Day13().solvePart1(inputs)

        assert(answer == 295)
    }

    @Test
    fun `Part 1 - Can solve full exercise`() {

        val inputs = File("src/test/resources/day13.txt").readLines()

        val answer = Day13().solvePart1(inputs)

        assert(answer == 156)
    }

    @Test
    fun `Part 2 - Can solve provided example`() {

        val inputs = listOf(
            "939",
            "7,13,x,x,59,x,31,19"
        )

        val answer = Day13().solvePart2(inputs)

        assert(answer == 1068781L)
    }

    @Test
    fun `Part 2 - Can solve full exercise`() {

        val inputs = File("src/test/resources/day13.txt").readLines()

        val answer = Day13().solvePart2(inputs)

        assert(answer == 404517869995362L)
    }
}
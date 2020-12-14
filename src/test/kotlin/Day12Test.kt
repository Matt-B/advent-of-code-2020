package uk.co.matt_bailey.adventofcode2020

import org.junit.Test
import java.io.File

class Day12Test {

    @Test
    fun `Part 1 - Can solve provided example`() {

        val inputs = listOf(
            "F10",
            "N3",
            "F7",
            "R90",
            "F11"
        )

        val answer = Day12().solvePart1(inputs)

        println("Answer is $answer")

        assert(answer == 25)
    }

    @Test
    fun `Part 1 - Can solve full exercise`() {

        val inputs = File("src/test/resources/day12.txt").readLines()

        val answer = Day12().solvePart1(inputs)

        assert(answer == 2458)
    }

    @Test
    fun `Part 2 - Can solve provided example`() {

        val inputs = listOf(
            "F10",
            "N3",
            "F7",
            "R90",
            "F11"
        )

        val answer = Day12().solvePart2(inputs)

        println("Answer is $answer")

        assert(answer == 286)
    }

    @Test
    fun `Part 2 - Can solve full exercise`() {

        val inputs = File("src/test/resources/day12.txt").readLines()

        val answer = Day12().solvePart2(inputs)

        println("Answer is $answer")
    }
}
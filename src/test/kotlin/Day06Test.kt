package uk.co.matt_bailey.adventofcode2020

import org.junit.Test
import java.io.File

class Day06Test {

    @Test
    fun `Part 1 - Can solve provided example`() {

        val inputs = listOf(
            "abc",
            "",
            "a",
            "b",
            "c",
            "",
            "ab",
            "ac",
            "",
            "a",
            "a",
            "a",
            "a",
            "",
            "b"
        )

        val answer = Day06().solvePart1(inputs)

        assert(answer == 11)
    }

    @Test
    fun `Part 1 - Can solve full exercise`() {

        val inputs = File("src/test/resources/day6.txt").readLines()

        val answer = Day06().solvePart1(inputs)

        assert(answer == 6549)
    }

    @Test
    fun `Part 2 - Can solve provided example`() {

        val inputs = listOf(
            "abc",
            "",
            "a",
            "b",
            "c",
            "",
            "ab",
            "ac",
            "",
            "a",
            "a",
            "a",
            "a",
            "",
            "b"
        )

        val answer = Day06().solvePart2(inputs)

        assert(answer == 6)
    }

    @Test
    fun `Part 2 - Can solve full exercise`() {

        val inputs = File("src/test/resources/day6.txt").readLines()

        val answer = Day06().solvePart2(inputs)

        println("Answer is $answer")
    }
}
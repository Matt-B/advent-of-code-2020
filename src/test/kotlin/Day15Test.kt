package uk.co.matt_bailey.adventofcode2020

import org.junit.Test
import java.io.File

class Day15Test {

    @Test
    fun `Part 1 - Can solve first provided example`() {

        val inputs = listOf(
            "0,3,6"
        )

        val answer = Day15().solvePart1(inputs)

        assert(answer == 436)
    }

    @Test
    fun `Part 1 - Can solve second provided example`() {

        val inputs = listOf(
            "1,3,2"
        )

        val answer = Day15().solvePart1(inputs)

        assert(answer == 1)
    }

    @Test
    fun `Part 1 - Can solve full exercise`() {

        val inputs = File("src/test/resources/day15.txt").readLines()

        val answer = Day15().solvePart1(inputs)

        assert(answer == 447)
    }

    @Test
    fun `Part 2 - Can solve first provided example`() {

        val inputs = listOf(
            "0,3,6"
        )

        val answer = Day15().solvePart2(inputs)

        assert(answer == 175594)
    }

    @Test
    fun `Part 2 - Can solve second provided example`() {

        val inputs = listOf(
            "1,3,2"
        )

        val answer = Day15().solvePart2(inputs)

        assert(answer == 2578)
    }

    @Test
    fun `Part 2 - Can solve full exercise`() {

        val inputs = File("src/test/resources/day15.txt").readLines()

        val answer = Day15().solvePart2(inputs)

        assert(answer == 11721679)
    }
}
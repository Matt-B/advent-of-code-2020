package uk.co.matt_bailey.adventofcode2020

import java.io.File
import kotlin.test.Test

class Day01Test {

    @Test
    fun `Part 1 - Can solve provided example`() {

        val inputs = listOf("1721","979","366","299","675","1456")

        val answer = Day01().solvePart1(inputs)

        assert(answer == 514579)
    }

    @Test
    fun `Part 1 - Can solve full exercise`() {

        val inputs = File("src/test/resources/day1.txt").readLines()

        val answer = Day01().solvePart1(inputs)

        assert(answer == 326211)
    }

    @Test
    fun `Part 2 - Can solve provided example`() {

        val inputs = listOf("1721","979","366","299","675","1456")

        val answer = Day01().solvePart2(inputs)

        assert(answer == 241861950)
    }

    @Test
    fun `Part 2 - Can solve full exercise`() {

        val inputs = File("src/test/resources/day1.txt").readLines()

        val answer = Day01().solvePart2(inputs)

        assert(answer == 131347190)
    }
}
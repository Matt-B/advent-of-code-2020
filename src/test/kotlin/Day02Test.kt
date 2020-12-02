package uk.co.matt_bailey.adventofcode2020

import org.junit.Test
import java.io.File

class Day02Test {

    @Test
    fun `Part 1 - Can solve provided example`() {

        val inputs = listOf("1-3 a: abcde", "1-3 b: cdefg", "2-9 c: ccccccccc")

        val answer = Day02().solvePart1(inputs)

        assert(answer == 2)
    }

    @Test
    fun `Part 1 - Can solve full exercise`() {

        val inputs = File("src/test/resources/day2.txt").readLines()

        val answer = Day02().solvePart1(inputs)

        assert(answer == 645)
    }

    @Test
    fun `Part 2 - Can solve provided example`() {

        val inputs = listOf("1-3 a: abcde", "1-3 b: cdefg", "2-9 c: ccccccccc")

        val answer = Day02().solvePart2(inputs)

        assert(answer == 1)
    }

    @Test
    fun `Part 2 - Can solve full exercise`() {

        val inputs = File("src/test/resources/day2.txt").readLines()

        val answer = Day02().solvePart2(inputs)

        assert(answer == 737)
    }
}
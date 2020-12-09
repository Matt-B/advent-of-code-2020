package uk.co.matt_bailey.adventofcode2020

import org.junit.Test
import java.io.File

class Day09Test {

    @Test
    fun `Part 1 - Can solve provided example`() {

        val inputs = listOf(
            "35",
            "20",
            "15",
            "25",
            "47",
            "40",
            "62",
            "55",
            "65",
            "95",
            "102",
            "117",
            "150",
            "182",
            "127",
            "219",
            "299",
            "277",
            "309",
            "576"
        )

        val answer = Day09().solvePart1(inputs, 5)

        assert(answer == 127L)
    }

    @Test
    fun `Part 1 - Can solve full exercise`() {

        val inputs = File("src/test/resources/day9.txt").readLines()

        val answer = Day09().solvePart1(inputs, 25)

        assert(answer == 104054607L)
    }

    @Test
    fun `Part 2 - Can solve provided example`() {

        val inputs = listOf(
            "35",
            "20",
            "15",
            "25",
            "47",
            "40",
            "62",
            "55",
            "65",
            "95",
            "102",
            "117",
            "150",
            "182",
            "127",
            "219",
            "299",
            "277",
            "309",
            "576"
        )

        val answer = Day09().solvePart2(inputs, 127L)

        assert(answer == 62L)
    }

    @Test
    fun `Part 2 - Can solve full exercise`() {

        val inputs = File("src/test/resources/day9.txt").readLines()

        val answer = Day09().solvePart2(inputs, 104054607L)

        assert(answer == 13935797L)
    }
}
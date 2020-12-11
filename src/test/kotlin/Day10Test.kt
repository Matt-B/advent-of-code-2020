package uk.co.matt_bailey.adventofcode2020

import org.junit.Test
import java.io.File

class Day10Test {

    @Test
    fun `Part 1 - Can solve provided example`() {

        val inputs = listOf(
            "16",
            "10",
            "15",
            "5",
            "1",
            "11",
            "7",
            "19",
            "6",
            "12",
            "4"
        )

        val answer = Day10().solvePart1(inputs)

        assert(answer == 35)
    }

    @Test
    fun `Part 1 - Can solve full exercise`() {

        val inputs = File("src/test/resources/day10.txt").readLines()

        val answer = Day10().solvePart1(inputs)

        assert(answer == 1836)
    }

    @Test
    fun `Part 2 - Can solve first provided example`() {

        val inputs = listOf(
            "16",
            "10",
            "15",
            "5",
            "1",
            "11",
            "7",
            "19",
            "6",
            "12",
            "4"
        )

        val answer = Day10().solvePart2(inputs)

        assert(answer == 8L)
    }

    @Test
    fun `Part 2 - Can solve second provided example`() {

        val inputs = listOf(
            "28",
            "33",
            "18",
            "42",
            "31",
            "14",
            "46",
            "20",
            "48",
            "47",
            "24",
            "23",
            "49",
            "45",
            "19",
            "38",
            "39",
            "11",
            "1",
            "32",
            "25",
            "35",
            "8",
            "17",
            "7",
            "9",
            "4",
            "2",
            "34",
            "10",
            "3"
        )

        val answer = Day10().solvePart2(inputs)

        assert(answer == 19208L)
    }

    @Test
    fun `Part 2 - Can solve full exercise`() {

        val inputs = File("src/test/resources/day10.txt").readLines()

        val answer = Day10().solvePart2(inputs)

        assert(answer == 43406276662336L)
    }
}
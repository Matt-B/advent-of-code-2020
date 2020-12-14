package uk.co.matt_bailey.adventofcode2020

import org.junit.Test
import java.io.File

class Day11Test {

    @Test
    fun `Part 1 - Can solve provided example`() {

        val inputs = listOf(
            "L.LL.LL.LL",
            "LLLLLLL.LL",
            "L.L.L..L..",
            "LLLL.LL.LL",
            "L.LL.LL.LL",
            "L.LLLLL.LL",
            "..L.L.....",
            "LLLLLLLLLL",
            "L.LLLLLL.L",
            "L.LLLLL.LL"
        )

        val answer = Day11().solvePart1(inputs)

        assert(answer == 37)
    }

    @Test
    fun `Part 1 - Can solve full exercise`() {

        val inputs = File("src/test/resources/day11.txt").readLines()

        val answer = Day11().solvePart1(inputs)

        assert(answer == 2321)
    }

    @Test
    fun `Part 2 - Can solve provided example`() {

        val inputs = listOf(
            "L.LL.LL.LL",
            "LLLLLLL.LL",
            "L.L.L..L..",
            "LLLL.LL.LL",
            "L.LL.LL.LL",
            "L.LLLLL.LL",
            "..L.L.....",
            "LLLLLLLLLL",
            "L.LLLLLL.L",
            "L.LLLLL.LL"
        )

        val answer = Day11().solvePart2(inputs)

        assert(answer == 26)
    }

    @Test
    fun `Part 2 - Can solve full exercise`() {

        val inputs = File("src/test/resources/day11.txt").readLines()

        val answer = Day11().solvePart2(inputs)

        assert(answer == 2102)
    }
}
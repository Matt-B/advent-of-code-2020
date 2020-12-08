package uk.co.matt_bailey.adventofcode2020

import org.junit.Test
import java.io.File

class Day08Test {

    @Test
    fun `Part 1 - Can solve provided example`() {

        val inputs = listOf(
            "nop +0",
            "acc +1",
            "jmp +4",
            "acc +3",
            "jmp -3",
            "acc -99",
            "acc +1",
            "jmp -4",
            "acc +6"
        )

        val answer = Day08().solvePart1(inputs)

        assert(answer == 5)
    }

    @Test
    fun `Part 1 - Can solve full exercise`() {

        val inputs = File("src/test/resources/day8.txt").readLines()

        val answer = Day08().solvePart1(inputs)

        assert(answer == 1930)
    }

    @Test
    fun `Part 2 - Can solve provided example`() {

        val inputs = listOf(
            "nop +0",
            "acc +1",
            "jmp +4",
            "acc +3",
            "jmp -3",
            "acc -99",
            "acc +1",
            "jmp -4",
            "acc +6"
        )

        val answer = Day08().solvePart2(inputs)

        assert(answer == 8)
    }

    @Test
    fun `Part 2 - Can solve full exercise`() {

        val inputs = File("src/test/resources/day8.txt").readLines()

        val answer = Day08().solvePart2(inputs)

        assert(answer == 1688)
    }
}
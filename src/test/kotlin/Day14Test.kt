package uk.co.matt_bailey.adventofcode2020

import org.junit.Test
import java.io.File

class Day14Test {

    @Test
    fun `Part 1 - Can solve provided example`() {

        val inputs = listOf(
            "mask = XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X",
            "mem[8] = 11",
            "mem[7] = 101",
            "mem[8] = 0"
        )

        val answer = Day14().solvePart1(inputs)

        assert(answer == 165L)
    }

    @Test
    fun `Part 1 - Can solve full exercise`() {

        val inputs = File("src/test/resources/day14.txt").readLines()

        val answer = Day14().solvePart1(inputs)

        assert(answer == 15403588588538L)
    }

    @Test
    fun `Part 2 - Can solve provided example`() {

        val inputs = listOf(
            "mask = 000000000000000000000000000000X1001X",
            "mem[42] = 100",
            "mask = 00000000000000000000000000000000X0XX",
            "mem[26] = 1"
        )

        val answer = Day14().solvePart2(inputs)

        assert(answer == 208L)
    }

    @Test
    fun `Part 2 - Can solve full exercise`() {

        val inputs = File("src/test/resources/day14.txt").readLines()

        val answer = Day14().solvePart2(inputs)

        assert(answer == 3260587250457L)
    }
}
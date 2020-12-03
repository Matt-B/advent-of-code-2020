package uk.co.matt_bailey.adventofcode2020

import org.junit.Test
import java.io.File

class Day03Test {

    @Test
    fun `Part 1 - Can solve provided example`() {

        val inputs = listOf(
            "..##.......",
            "#...#...#..",
            ".#....#..#.",
            "..#.#...#.#",
            ".#...##..#.",
            "..#.##.....",
            ".#.#.#....#",
            ".#........#",
            "#.##...#...",
            "#...##....#",
            ".#..#...#.#"
        )

        val answer = Day03().solvePart1(inputs)

        assert(answer == 7)
    }

    @Test
    fun `Part 1 - Can solve full exercise`() {

        val inputs = File("src/test/resources/day3.txt").readLines()

        val answer = Day03().solvePart1(inputs)

        assert(answer == 169)
    }

    @Test
    fun `Part 2 - Can solve provided example`() {

        val inputs = listOf(
            "..##.......",
            "#...#...#..",
            ".#....#..#.",
            "..#.#...#.#",
            ".#...##..#.",
            "..#.##.....",
            ".#.#.#....#",
            ".#........#",
            "#.##...#...",
            "#...##....#",
            ".#..#...#.#"
        )

        val answer = Day03().solvePart2(inputs)

        assert(answer == 336L)
    }

    @Test
    fun `Part 2 - Can solve full exercise`() {

        val inputs = File("src/test/resources/day3.txt").readLines()

        val answer = Day03().solvePart2(inputs)

        assert(answer == 7560370818L)
    }
}
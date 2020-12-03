package uk.co.matt_bailey.adventofcode2020

class Day03 {

    fun solvePart1(input: List<String>): Int {
        val grid: List<CharArray> = input.map { it.toCharArray() }
        return traverseSlope(grid, 3, 1)
    }

    fun solvePart2(input: List<String>): Long {
        val grid: List<CharArray> = input.map { it.toCharArray() }
        val moves = listOf(Pair(1,1), Pair(3,1), Pair(5,1), Pair(7,1), Pair(1,2))
        var product = 1L
        for(move in moves) {
            var treesHit = traverseSlope(grid, move.first, move.second)
            product *= treesHit
        }
        return product
    }

    private fun traverseSlope(grid: List<CharArray>, moveRight: Int, moveDown: Int): Int {
        var positionX = 0
        var positionY = 0
        var treesHit = 0

        while(positionY < grid.size - 1) {
            positionX += moveRight
            if(positionX > grid[0].size - 1) {
                positionX -= grid[0].size
            }
            positionY += moveDown
            if(grid[positionY][positionX] == '#') {
                treesHit++
            }
        }

        return treesHit
    }
}
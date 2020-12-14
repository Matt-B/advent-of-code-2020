package uk.co.matt_bailey.adventofcode2020

import kotlin.math.abs

class Day12 {

    fun solvePart1(input: List<String>): Int {
        var currentPosition = Pair(0, 0)
        var currentDirection = 90
        for(line in input) {
            val command = line.filter { it.isLetter() }
            val quantity = line.filter { it.isDigit() }.toInt()
            when(command) {
                "N" -> {
                    currentPosition = move(currentPosition, 0, quantity)
                }
                "S" -> {
                    currentPosition = move(currentPosition, 180, quantity)
                }
                "E" -> {
                    currentPosition = move(currentPosition, 90, quantity)
                }
                "W" -> {
                    currentPosition = move(currentPosition, 270, quantity)
                }
                "L" -> {
                    currentDirection -= quantity
                    if(currentDirection >= 360) { currentDirection -= 360 }
                    if(currentDirection < 0) { currentDirection += 360 }
                }
                "R" -> {
                    currentDirection += quantity
                    if(currentDirection >= 360) { currentDirection -= 360 }
                    if(currentDirection < 0) { currentDirection += 360 }
                }
                "F" -> {
                    currentPosition = move(currentPosition, currentDirection, quantity)
                }
            }
        }

        return abs(currentPosition.first) + abs(currentPosition.second)
    }

    fun solvePart2(input: List<String>): Int {
        var currentShipPosition = Pair(0, 0)
        var currentWaypointPosition = Pair(1, 10)
        for(line in input) {
            val command = line.filter { it.isLetter() }
            val quantity = line.filter { it.isDigit() }.toInt()
            when(command) {
                "N" -> {
                    currentWaypointPosition = move(currentWaypointPosition, 0, quantity)
                }
                "S" -> {
                    currentWaypointPosition = move(currentWaypointPosition, 180, quantity)
                }
                "E" -> {
                    currentWaypointPosition = move(currentWaypointPosition, 90, quantity)
                }
                "W" -> {
                    currentWaypointPosition = move(currentWaypointPosition, 270, quantity)
                }
                "L" -> {
                    currentWaypointPosition = rotateWaypoint(currentShipPosition, currentWaypointPosition, 360 - quantity)
                }
                "R" -> {
                    currentWaypointPosition = rotateWaypoint(currentShipPosition, currentWaypointPosition, quantity)
                }
                "F" -> {
                    val moveToWaypoint = getWaypointOffset(currentShipPosition, currentWaypointPosition)
                    repeat(quantity) {
                        currentShipPosition = Pair(currentShipPosition.first + moveToWaypoint.first, currentShipPosition.second + moveToWaypoint.second)
                    }
                    currentWaypointPosition = Pair(currentShipPosition.first + moveToWaypoint.first, currentShipPosition.second + moveToWaypoint.second)
                }
            }
        }

        return abs(currentShipPosition.first) + abs(currentShipPosition.second)
    }

    private fun move(position: Pair<Int, Int>, direction: Int, quantity: Int): Pair<Int, Int> {
        when(direction) {
            0 -> {
                return Pair(position.first + quantity, position.second)
            }
            90 -> {
                return Pair(position.first, position.second + quantity)
            }
            180 -> {
                return Pair(position.first - quantity, position.second)
            }
            270 -> {
                return Pair(position.first, position.second - quantity)
            }
            else -> {
                return position
            }
        }
    }

    private fun getWaypointOffset(shipPosition: Pair<Int, Int>, waypointPosition: Pair<Int, Int>): Pair<Int, Int> {
        return Pair(waypointPosition.first - shipPosition.first, waypointPosition.second - shipPosition.second)
    }

    private fun rotateWaypoint(shipPosition: Pair<Int, Int>, waypointPosition: Pair<Int, Int>, degrees: Int): Pair<Int, Int> {
        val offset = getWaypointOffset(shipPosition, waypointPosition)
        return when(degrees) {
            90 -> {
                Pair(shipPosition.first - offset.second, shipPosition.second + offset.first)
            }
            180 -> {
                Pair(shipPosition.first - offset.first, shipPosition.second - offset.second)
            }
            270 -> {
                Pair(shipPosition.first + offset.second, shipPosition.second - offset.first)
            }
            else -> {
                waypointPosition
            }
        }
    }
}
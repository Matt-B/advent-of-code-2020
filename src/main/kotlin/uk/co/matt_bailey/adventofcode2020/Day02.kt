package uk.co.matt_bailey.adventofcode2020

class Day02 {

    fun solvePart1(input: List<String>) : Int {
        var validPasswords = 0

        input.forEach { line ->
            var policyAndPassword = getPolicyAndPassword(line)
            var numberOfOccurrences = policyAndPassword[3].length - policyAndPassword[3].replace(policyAndPassword[2], "").length
            if(numberOfOccurrences in policyAndPassword[0].toInt() until policyAndPassword[1].toInt() +1) {
                validPasswords++
            }
        }
        return validPasswords
    }

    fun solvePart2(input: List<String>) : Int {
        var validPasswords = 0

        input.forEach { line ->
            var policyAndPassword = getPolicyAndPassword(line)
            if ((policyAndPassword[3][policyAndPassword[0].toInt()] == policyAndPassword[2][0]) xor (policyAndPassword[3][policyAndPassword[1].toInt()] == policyAndPassword[2][0])) {
                validPasswords++
            }
        }
        return validPasswords
    }

    private fun getPolicyAndPassword(line: String) : List<String> {
        var splitLine = line.trim().split(":")
        var policy = splitLine[0]
        var password = splitLine[1]
        var splitPolicy = policy.split(" ")
        var firstPolicyDigit = splitPolicy[0].split("-")[0]
        var secondPolicyDigit = splitPolicy[0].split("-")[1]
        var character = splitPolicy[1]
        return listOf(firstPolicyDigit, secondPolicyDigit, character, password)
    }
}
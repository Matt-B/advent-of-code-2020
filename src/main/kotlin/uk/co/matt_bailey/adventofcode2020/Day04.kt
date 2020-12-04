package uk.co.matt_bailey.adventofcode2020

class Day04 {

    fun solvePart1(input: List<String>): Int {
        val passports = parsePassports(input)
        return removePassportsWithMissingFields(passports).size
    }

    fun solvePart2(input: List<String>): Int {
        var passports = parsePassports(input)
        removePassportsWithMissingFields(passports).also { passports = it }
        return removePassportsWithInvalidValues(passports).size
    }

    private fun parsePassports(input: List<String>): List<Map<String, String>> {
        var passports = mutableListOf<Map<String, String>>()
        var passport = mutableMapOf<String, String>()
        for(line in input) {
            if(line.isEmpty()) {
                passports.add(passport)
                passport = mutableMapOf()
            } else {
                var parts = line.split(" ")
                for(part in parts) {
                    passport[part.split(":")[0]] = part.split(":")[1]
                }
            }
        }
        passports.add(passport)
        return passports
    }

    private fun isValidHeight(height: String): Boolean {
        return when {
            height.contains("cm") -> {
                var number = height.replace("cm", "").toInt()
                number in 150..194
            }
            height.contains("in") -> {
                var number = height.replace("in", "").toInt()
                number in 59..77
            }
            else -> {
                false
            }
        }
    }

    private fun isValidHairColour(hcl: String): Boolean {
        val validationPattern = "#[0-9a-f]{6}".toRegex()
        return hcl?.matches(validationPattern) ?: false
    }

    private fun isValidPassportId(pid: String?): Boolean {
        val validationPattern = "[0-9]{9}".toRegex()
        return pid?.matches(validationPattern) ?: false
    }

    private fun isValidBirthYear(byr: String): Boolean {
        return byr.toInt() in 1920..2003
    }

    private fun isValidIssueYear(iyr: String): Boolean {
        return iyr.toInt() in 2010..2021
    }

    private fun isValidExpiryYear(eyr: String): Boolean {
        return eyr.toInt() in 2020..2031
    }

    private fun isValidEyeColour(ecl: String): Boolean {
        return ecl in listOf("amb", "blu", "brn", "gry", "grn", "hzl", "oth")
    }

    private fun removePassportsWithMissingFields(passports: List<Map<String, String>>): List<Map<String, String>> {
        return passports.filter { passport ->
            passport["byr"] != null &&
            passport["iyr"] != null &&
            passport["eyr"] != null &&
            passport["hgt"] != null &&
            passport["hcl"] != null &&
            passport["ecl"] != null &&
            passport["pid"] != null
        }
    }

    private fun removePassportsWithInvalidValues(passports: List<Map<String, String>>): List<Map<String, String>> {
        return passports.filter { passport ->
            isValidBirthYear(passport["byr"].toString()) and
            isValidIssueYear(passport["iyr"].toString()) and
            isValidExpiryYear(passport["eyr"].toString()) and
            isValidHeight(passport["hgt"].toString()) and
            isValidHairColour(passport["hcl"].toString()) and
            isValidEyeColour(passport["ecl"].toString()) and
            isValidPassportId(passport["pid"])
        }
    }
}
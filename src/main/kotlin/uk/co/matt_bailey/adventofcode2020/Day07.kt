package uk.co.matt_bailey.adventofcode2020

class Day07 {

    private var allBagRules = mutableMapOf<String, Map<String, Int>>()

    fun solvePart1(input: List<String>): Int {
        parseAndPopulateRules(input)

        return getNumberOfPossibleEnclosingBags("shiny gold").size
    }

    fun solvePart2(input: List<String>): Int {
        parseAndPopulateRules(input)

        return getTotalContents("shiny gold")
    }

    private fun parseAndPopulateRules(input: List<String>) {
        for(line in input) {
            var bagColour = "^[\\w]+ [\\w]+(?= bag)".toRegex().findAll(line).first().value
            var bagContents = "\\d [\\w]+ [\\w]+(?= bag)".toRegex().findAll(line)
            var bagRules = mutableMapOf<String, Int>()
            for(rule in bagContents) {
                var splitRule = rule.value.split(" ")
                bagRules[splitRule[1] + " " + splitRule[2]] = splitRule[0].toInt()
            }
            allBagRules[bagColour] = bagRules
        }
    }

    private fun getNumberOfPossibleEnclosingBags(bagColour: String): MutableSet<String> {
        var possibleEnclosingBagColours = mutableSetOf<String>()
        var possibleEnclosingBags = mutableListOf<String>()
        for ((bag, rules) in allBagRules) {
            for (rule in rules) {
                if (rule.key == bagColour) {
                    possibleEnclosingBags.add(bag)
                }
            }
        }
        if(possibleEnclosingBags.isNotEmpty()) {
            possibleEnclosingBagColours.addAll(possibleEnclosingBags)
            for(enclosingBag in possibleEnclosingBags) {
                possibleEnclosingBagColours.addAll(getNumberOfPossibleEnclosingBags(enclosingBag))
            }
        }
        return possibleEnclosingBagColours
    }

    private fun getTotalContents(bagColour: String): Int {
        var totalConstituentBags = 0
        var contents = allBagRules[bagColour]
        if(!contents.isNullOrEmpty()) {
            totalConstituentBags += contents.values.sum()
            for(colour in contents.keys) {
                totalConstituentBags += (getTotalContents(colour) * contents[colour]!!)
            }
        }
        return totalConstituentBags
    }
}
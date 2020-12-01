package uk.co.matt_bailey.adventofcode2020

class Day01() {

    fun solvePart1(input: List<String>): Int {
        var listOfExpenses: List<Int> = input.map { it.toInt() }
        listOfExpenses.forEach { expense ->
            for (otherExpense in listOfExpenses) {
                if(listOfExpenses.indexOf(expense) != listOfExpenses.indexOf(otherExpense)) {
                    if(expense + otherExpense == 2020) return (expense * otherExpense)
                }
            }
        }
        return -1
    }

    fun solvePart2(input: List<String>): Int {
        var listOfExpenses: List<Int> = input.map { it.toInt() }
        listOfExpenses.forEach { expense ->
            for (otherExpense in listOfExpenses) {
                if(listOfExpenses.indexOf(expense) != listOfExpenses.indexOf(otherExpense)) {
                    for (otherOtherExpense in listOfExpenses) {
                        if (listOfExpenses.indexOf(expense) !== listOfExpenses.indexOf(otherOtherExpense) && listOfExpenses.indexOf(otherExpense) !== listOfExpenses.indexOf(otherOtherExpense)) {
                            if (expense + otherExpense + otherOtherExpense == 2020) return (expense * otherExpense * otherOtherExpense)
                        }
                    }
                }
            }
        }
        return -1
    }

}
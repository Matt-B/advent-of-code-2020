package uk.co.matt_bailey.adventofcode2020

class Day14 {

    fun solvePart1(input: List<String>): Long {
        var mask = "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX"
        val memory = mutableMapOf<Long, Long>()

        for(line in input) {
            if(line.startsWith("mask")) {
                mask = line.substringAfter('=').trim()
            } else if(line.startsWith("mem")) {
                val address = line.substringAfter('[').substringBefore(']').trim().toLong()
                val value = line.substringAfter('=').trim().toLong()
                memory[address] = mask(mask, toBinary(value)).toLong(2)
            }
        }
        return memory.values.sum()
    }

    fun solvePart2(input: List<String>): Long {
        var mask = "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX"
        val memory = mutableMapOf<Long, Long>()

        for(line in input) {
            if(line.startsWith("mask")) {
                mask = line.substringAfter('=').trim()
            } else if(line.startsWith("mem")) {
                val value = line.substringAfter('=').trim().toLong()
                val addresses = generateMaskedAddresses(mask, toBinary(line.substringAfter('[').substringBefore(']').trim().toLong()))
                for(address in addresses) {
                    memory[address.toLong(2)] = value
                }
            }
        }
        return memory.values.sum()
    }

    private fun generateMaskedAddresses(mask: String, input: String): List<String> {
        val addresses = mutableListOf(input.toCharArray())
        mask.toCharArray().forEachIndexed{ index, character ->
            when(character) {
                '0' -> {
                    addresses.forEach{
                        it[index] = it[index]
                    }
                }
                '1' -> {
                    addresses.forEach{
                        it[index] = '1'
                    }
                }
                'X' -> {
                    addresses.forEach{
                        it[index] = '0'
                    }
                    addresses.addAll(addresses.map{
                        it.copyOf().apply {
                            it[index] = '1'
                        }
                    })
                }
            }
        }
        return addresses.map{ it.concatToString() }
    }

    private fun toBinary(input: Long): String {
        return input.toString(2).padStart(36, '0')
    }

    private fun mask(mask: String, input: String): String {
        val result = CharArray(input.toCharArray().size)
        input.toCharArray().forEachIndexed { index, char ->
            if(mask.toCharArray()[index] != 'X') {
                result[index] = mask.toCharArray()[index]
            } else {
                result[index] = char
            }
        }
        return result.concatToString()
    }
}
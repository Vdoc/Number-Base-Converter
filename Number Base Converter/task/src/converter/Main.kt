package converter

import java.util.*

fun main() {
    val convertor = Convertor()
    convertor.start()
}

class Convertor {
    val scanner = Scanner(System.`in`)
    var exit = false
    var base = 0

    var number = 0
    var nomber2 = ""
    var result = ""
    var result2 = 0
    val list: MutableList<Char> = mutableListOf<Char>()
    val list2: MutableList<Int> = mutableListOf<Int>()

    fun clear() {
        result = ""
        result2 = 0
        list.clear()
        list2.clear()
    }

    fun start() {
        while (!exit) {
            clear()
            readInput()
        }
    }

    fun readInput() {
        print("Do you want to convert /from decimal or /to decimal? (To quit type /exit) ")
        when (scanner.next()) {
            "/from" -> fromDecimal()
            "/to" -> toDecimal()
            else -> exit = true
        }
    }

    private fun toDecimal() {
        print("Enter source number: ")
        nomber2 = scanner.next().toLowerCase()
        print("Enter source base: ")
        base = scanner.nextInt()

        for (i in 0 until nomber2.length) {
            list2 += when {
                nomber2[i].isDigit() -> nomber2[i] - '1' + 1
                else -> {
                    nomber2[i] - 'a' + 10
                }
            }
        }

        for (i in 0 until list2.size) {
            result2 = result2 + list2.get(i) * Math.pow(base.toDouble(), (list2.size - 1 - i).toDouble()).toInt()
        }

        println("Conversion to decimal result: $result2\n")
    }

    private fun fromDecimal() {
        print("Enter number in decimal system: ")
        number = scanner.nextInt()
        print("Enter target base: ")
        base = scanner.nextInt()

        var r = 0
        while (number != 0) {
            r = number % base
            number /= base
            list += when (r) {
                in 0..9 -> '1' + r - 1
                else -> 'A' + r - 10
            }
        }

        for (i in list.size - 1 downTo 0) {
            result += "" + list.get(i)
        }

        print("Conversion result: $result\n\n")
    }
}
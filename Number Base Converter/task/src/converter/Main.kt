package converter

import java.util.*

fun main() {
    val convertor = Convertor()
    convertor.magic()
    convertor.printResult()
}

class Convertor {
    var number = 0
    var base = 0
//    var result = 0
    var result = ""
    val list: MutableList<Char> = mutableListOf<Char>()

    constructor() {
        readInput()
    }

    fun printResult() {
        print("Conversion result: $result")
    }

    fun magic() {
        var n = number
        var v = 0
        var r = 0
        while (n != 0) {
            r = n % base
            n /= base
            list += when (r) {
                in 0..9 -> '1' - 1 + r
                else -> 'A' - 10 + r
            }
//            println(list)
        }

        for (i in list.size - 1 downTo 0) {
//            println(list.get(i))
//            result += result * 10 + list.get(i)
            result += "" + list.get(i)
        }
    }

    fun readInput() {
        val sc = Scanner(System.`in`)
        print("Enter number in decimal system: ")
        number= sc.nextInt()
        print("Enter target base: ")
        base = sc.nextInt()
    }
}
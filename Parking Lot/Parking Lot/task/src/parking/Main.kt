package parking


var place: MutableList<String> = MutableList(0){""}

fun main() {
    while (true) {
        val request = readln().trim().split(" ")
        when (request[0]) {
            "exit" -> break
            "park" -> if (!park(request[1], request[2])) println("Sorry, the parking lot is full.")
            "leave" -> leave(request[1].toInt())
            "status" -> status()
            "create" -> create(request[1].toInt())
            "reg_by_color" -> regByColor(request[1])
            "spot_by_color" -> spotByColor(request[1])
            "spot_by_reg" -> spotByReg(request[1])
        }
    }
}

fun park(car: String, color: String): Boolean {
    if (place.size == 0) {
        println("Sorry, a parking lot has not been created.")
        return true
    }
    for (i in 0 until place.size) if (place[i] == "") {
        println("$color car parked in spot ${i + 1}.")
        place[i] = "$car $color"
        return true
    }
    return false
}

fun leave(num: Int) {
    if (place.size == 0) {
        println("Sorry, a parking lot has not been created.")
    }
    else {
        if (place[num - 1].isNotEmpty()) {
            println("Spot $num is free.")
            place[num - 1] = ""
        }
        else println("There is no car in spot $num.")
    }
}

fun create(size: Int) {
    place = MutableList(size){""}
    println("Created a parking lot with $size spots.")
}

fun status() {
    if (place.size == 0) println("Sorry, a parking lot has not been created.")
    else {
        var x = 1
        var count = 0
        for (car in place) {
            if (car != "") {
                println("$x $car")
            } else count++
            x++
        }
        if (count == place.size) println("Parking lot is empty.")
    }
}

fun regByColor(color: String) {
    if (place.size == 0) println("Sorry, a parking lot has not been created.")
    else {
        val list: MutableList<String> = MutableList(0) {""}
        for (car in place) {
            if (car != "") {
                val reg = car.split(" ")[0]
                val colorP = car.split(" ")[1]
                if (colorP.lowercase() == color.lowercase()) list.add(reg)
            }
        }
        if (list.size == 0) println("No cars with color $color were found.")
        else println(list.joinToString(", "))
    }
}

fun spotByColor(color: String) {
    if (place.size == 0) println("Sorry, a parking lot has not been created.")
    else {
        val list: MutableList<Int> = MutableList(0) { 0 }
        var count = 1
        for (car in place) {
            if (car != "") {
                val colorP = car.split(" ")[1]
                if (colorP.lowercase() == color.lowercase()) list.add(count)
            }
            count++
        }
        if (list.size == 0) println("No cars with color $color were found.")
        else println(list.joinToString(", "))
    }
}

fun spotByReg(reg: String) {
    if (place.size == 0) println("Sorry, a parking lot has not been created.")
    else {
        var count = 1
        var cars = 0
        for (car in place) {
            if (car != "") {
                val regP = car.split(" ")[0]
                if (regP == reg) {
                    println(count)
                    cars++
                    break
                }
            }
            count++
        }
        if (cars == 0) println("No cars with registration number $reg were found.")
    }
}

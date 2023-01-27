fun main() {
    println(getPINs("369").joinToString(", "))
}

fun getPINs(observed: String): List<String> {
    val list: MutableList<String> = mutableListOf()
    val set: MutableSet<String> = mutableSetOf()
    for (i in 0 until observed.length) {
        when (observed[i].toString()) {
            "1" -> set.addAll(listOf("1", "2", "4"))
            "2" -> set.addAll(listOf("2", "1", "3", "5"))
            "3" -> set.addAll(listOf("2", "3", "6"))
            "4" -> set.addAll(listOf("1", "4", "5", "7"))
            "5" -> set.addAll(listOf("2", "4", "5", "6", "8"))
            "6" -> set.addAll(listOf("3", "5", "6", "9"))
            "7" -> set.addAll(listOf("4", "7", "8"))
            "8" -> set.addAll(listOf("5", "7", "8", "9", "0"))
            "9" -> set.addAll(listOf("6", "8", "9"))
            "0" -> set.addAll(listOf("8", "0"))
            else -> {}
        }
    }
    return list.toSet().toList()
}

private fun range(set: Set<String>): Set<String> {
    var main: MutableSet<String> = mutableSetOf()
    f
        for (i in set) {
            for (j in set)
        }
    return main
}
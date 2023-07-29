fun compareVersions(version1: String, version2: String): Int {
    val v1 = version1.replace(".", "")
    val v2 = version2.replace(".", "")
    println("v1: "+v1 +"v2: "+v2)

    return v1.compareTo(v2)
}

fun main() {
    val version1 = "1.23.3-beta"
    val version2 = "1.22.4"

    val comparisonResult = compareVersions(version1, version2)

    when {
        comparisonResult < 0 -> println("$version1 é menor que $version2")
        comparisonResult > 0 -> println("$version1 é maior que $version2")
        else -> println("$version1 é igual a $version2")
    }
}
////////////////////////////////////////////////////
//using toIntOrNull()
fun compareVersions(version1: String, version2: String): Int {
    val v1 = version1.replace(".", "").toIntOrNull() ?: 0
    val v2 = version2.replace(".", "").toIntOrNull() ?: 0

    return v1.compareTo(v2)
}
///////////////////////////////////////////////////////////
//boolean func
fun isEvenNumber(): Boolean {
    val number = 10 // Poderia ser qualquer número
    return number % 2 == 0
}

fun main() {
    val result = isEvenNumber()
    if(isEvenNumber()) {
    println("O número é par? $result")
    }
}
//////////////////////////////////////////////////////////
//Com safe call e toIntOrNull()
fun compareVersions(version1: String, version2: String): Int {
    val v1 = version1?.replace(".", "")?.toIntOrNull() ?: 0
    val v2 = version2?.replace(".", "")?.toIntOrNull()
    println("v1: "+v1 +" v2: "+v2)

    return v1?.compareTo(v2 ?: 0) ?: 0
    //return v1.compareTo(v2)
}

fun main() {
    val version1 = "1.23.3a"
    val version2 = "1.22.4"

    val comparisonResult = compareVersions(version1, version2)

    when {
        comparisonResult < 0 -> println("$version1 é menor que $version2")
        comparisonResult > 0 -> println("$version1 é maior que $version2")
        else -> println("$version1 é igual a $version2")
    }
}


fun main() {
    val text = "Hello my name is kevin"
    val upperCase = text.howMany { char -> char.isUpperCase() }
    println(upperCase)
}

fun String.howMany(include: (Char) -> Boolean): Int{
    var count = 0
    for (character in this){
        if (include(character)){
            count += 1
        }
    }
    return count       
}

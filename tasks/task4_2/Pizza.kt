fun main() {
    println("PIZZA MENU\n")
    println("(a) Margherita")
    println("(b) Quattro Stagioni")
    println("(c) Seafood")
    println("(d) Hawaiian")
    println("\nChoose your pizza: (a-d)")
    var order = readln()

    when (order) {
        "a" -> println("Order Accepted")
        "b" -> println("Order Accepted")
        "c" -> println("Order Accepted")
        "d" -> println("Order Accepted")
        else -> println("Invalid Choice!")
    }
}
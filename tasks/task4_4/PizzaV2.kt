fun main() {
    println("PIZZA MENU\n")
    println("(a) Margherita")
    println("(b) Quattro Stagioni")
    println("(c) Seafood")
    println("(d) Hawaiian")

    var order: String?
    do {
        println("\nChoose your pizza: (a-d)")
        order = readln()
        when (order) {
            "a", "b", "c", "d" -> {
                println("Order Accepted")
                break
            }
            else -> println("Invalid Choice!")
        }
    } while (true)
}
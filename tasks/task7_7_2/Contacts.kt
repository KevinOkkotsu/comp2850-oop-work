// Task 7.7.2: contact database, using a map
fun main() {
    fun database() {
        
        var map = mutableMapOf<String,Int>() 

        println("Enter a contact name: ")
        var input = readln().trim()
        while (true) {
            if (input is String) {
                map.keys.add(input)
                enterNumber()
                break
            }
            if (input = null) {
                println("Try again. Enter a contact name: ")
            }
            if (map.containsKey(input)) {
                println("Name is already in dictionary.")
            }
        }
    }
}

fun enterNumber() {
    println("Enter a number: ")
    var input = readln().trim()
    if (input is Integer) {
        map.value.add(input)
        println("Contact added")
    }
    if (input = null) {
        println("Try again. Enter a number: ")
    }
    if (map.containsKey(input)){
        println("Phone number already in dictionary.")
    }
}
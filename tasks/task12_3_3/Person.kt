import java.time.LocalDate

class Person(var name: String, val birth: LocalDate) {
    var isMarried = false
    init { require(name.isNotBlank()) { "Name cannot be blank" } } // Throws an exception when the object is created not at the command line
    constructor(name: String, birthString: String) : this(name, LocalDate.parse(birthString))
}

fun main() {
    val person1 = Person(getName(), getDoB())
    val person2 = Person("", "1997-08-23")
    println("Created person: ${person1.name}, born ${person1.birth}")
}

fun getDoB(): String {
    while (true) {
        print("Enter date of birth (YYYY-MM-DD): ")
        val input = readln().trim()
        if (input.isNotBlank()) {
            // Validate it's a proper date
            try {
                LocalDate.parse(input)
                return input
            } catch (e: Exception) {
                println("Invalid date format. Use YYYY-MM-DD.")
            }
        } else {
            println("Date cannot be blank.")
        }
    }
}

fun getName(): String {
    while (true) {
        print("Enter name: ")
        val input = readln().trim()
        if (input.isNotBlank()) return input
    }
}
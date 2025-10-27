// Task 12.3.2: Person class, with a secondary constructor
import java.time.LocalDate

class Person(var name: String, val birth: LocalDate) {
    var isMarried = false
    
    constructor(name: String, birthString: String) : this(name, LocalDate.parse(birthString))
    constructor(birthString: String) : this("Uknown", birthString)
}

fun main() {
    val date = LocalDate.of(1997,8,23)
    val person1 = Person("Kevin",date)
    val person2 = Person("1997-08-23")
    println(person1.name)
    println(person2.birth)
}
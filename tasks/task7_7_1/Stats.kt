// Task 7.7.1: stats for a numeric dataset
fun main() {
    fun readData(): List<Double> = buildList<Double> {
        // Print a prompt for the user
        println("Enter a series of floating point numbers (type 'exit' to finish): ")
        while (true) {
            val input = readln().trim()
            if (input.equals("exit", ignoreCase = true)){
                break
            }
            val v = input.toDoubleOrNull()
            // does not break, so input is constantly read until exit is inputted
            if (v != null) {
                add(v)    
            }
            else {
                println("Not a number, try again: ")
            }
        }
    }
    val data = readData()
    println(data)
    println(median(data))
}

fun median(args: List<Double>):Double {
    Double min = args.min()
    Double max = args.max()
    Double median = (min+max)/2
    return median
}
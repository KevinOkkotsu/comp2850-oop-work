// Task 3.1: command line arguments
import kotlin.system.exitProcess

fun main(args: Array<String>) {
    if (args.size != 2) {
        println("Error: filename required as sole argument")
        exitProcess(1)
    }
    else {
        println("This is the first argument: ${args[0]}")
        println("This is the second argument: ${args[1]}")
    }
}
// Task 9.6: application to compute dataset variance

import kotlin.system.exitProcess
import java.io.File
import java.io.FileNotFoundException

fun main() {
    var intList: List<Double> = emptyList()
    
    while (true) {
        println("Enter a filename: (type exit to end)")
        val input = readln().trim()
        
        if (input == "exit") {
            if (intList.isNotEmpty()) {
                try {
                    println("Variance: ${variance(intList)}")
                } catch (e: Exception) {
                    println("Unable to calculate variance: ${e.message}")
                }
            } else {
                println("No data loaded")
            }
            break
        }
        
        try {
            intList = readData(input)
            println("Data points loaded: ${intList.size}")
            println("Data: $intList")
        } catch (e: FileNotFoundException) {
            println("File cannot be found: $input")
        } catch (e: NumberFormatException) {
            println("File contains invalid number format. ${e.message}")
        } catch (e: SecurityException) {
            println("Permission to access file not granted: ${e.message}")
        } catch (e: Exception) {
            println("Error occurred: ${e.message}")
        }
    }
}

fun variance(dataset: List<Double>): Double {
    require(dataset.size > 1) { "not enough data" }
    val mean = dataset.average()
    val difference = dataset.map { it - mean }.sumOf { it * it }
    val variance = difference / (dataset.size - 1)
    return variance
}    

fun readData(filename: String): List<Double> = buildList {
    File(filename).forEachLine {
        add(it.toDouble())
    }
}
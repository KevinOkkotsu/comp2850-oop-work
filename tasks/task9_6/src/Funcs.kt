// Task 9.6: functions for dataset variance calculation
//import java.io.File

// Add variance() function here
/*fun variance(dataset:List<Double>):Double {
    (require(dataset.size>1) { "not enough data" })
    val mean = dataset.average()
    val difference = dataset.map { it-mean }.sumOf { it * it } // computes sum of modified set, the squared numbers
    val variance = difference / (dataset.size - 1)
    return variance
}

// Add readData() function here
fun readData(filename: String) = buildList {
    File(filename).forEachLine {
        add(it.toDouble())
    }
}
*/

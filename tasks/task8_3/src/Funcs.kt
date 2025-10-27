// Task 8.3: functions for temperature analysis

typealias Record = Pair<String,Double>

fun fetchData(): List<Record> {
  // Create and return a simulated dataset here
  // Use the listOf() and to() functions to create the dataset
  return listOf(
      "2020" to 150.5,
      "2021" to 165.2,
      "2022" to 180.7,
      "2023" to 195.3,
      "2024" to 210.8
  ) .map { Record(it.first,it.second) }
}

// Challenge: compute average temperature with one line of code
// in main(), instead of using the function below!
fun main() {
  val dataSet = fetchData()
  println(dataSet)
  println(averageTemp(dataSet))
}


val averageTemp = { data: List<Record> -> data.map { it.second }.sum()/data.size }



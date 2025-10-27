// Task 8.3: weather station temperature analysis program

fun main() {
    // Add code here to:
    //   - Fetch data
    //   - Find records with lowest and and highest temperatures
    //   - Compute average temperature
    //   - Display all of these statistics

    val dataSet = fetchData()

    val lowest = dataSet.min { it.second }
    val highest = dataSet.max { it.second }

    println("${lowest?.first} has the lowest temperature: ${lowest?.second}")
    println("${highest?.first} has the highest temperature: ${highest?.second}")
}


fun fetchData():List<Pair<String,Double>> {
    return listOf(
        "London" to 15.5,
        "London" to 16.2,
        "London" to 17.1,
        "Paris" to 16.8,
        "Paris" to 17.5,
        "Paris" to 18.3,
        "Berlin" to 14.2,
        "Berlin" to 15.0,
        "Berlin" to 15.8
    )
}
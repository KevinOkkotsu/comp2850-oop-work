// Task 4.5: summing odd integers with a for loop
fun main() {
    var upperValue: String?

    do {
        print("Enter an upper limit (>=1): ")
        upperValue = readln()
        
        val upperInt = upperValue.toIntOrNull()
        
        if (upperInt == null || upperInt < 1) {
            println("Invalid input. Please enter an integer greater than or equal to 1.")
        } 
        else {
            var sum = 0
            for (n in 1..upperInt step 2) {
                sum += n
            }
            println("The sum of odd integers from 1 to $upperInt is $sum")
            break
        }    
    } while (true)
}
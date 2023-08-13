fun main()
{

    val number = 55566
    val sum = calculateSumOfFirstAndLastDigits(number)

    println("Summation of first and last digits in $number is $sum")
}

fun calculateSumOfFirstAndLastDigits(number: Int): Int {
    var n = if (number < 0) -number else number

    val lastDigit = n % 10
    var firstDigit = 0

    while (n != 0) {
        firstDigit = n % 10
        n /= 10
    }

    return firstDigit + lastDigit
}
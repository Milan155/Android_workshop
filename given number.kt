fun main()
{
    println("Enter a number:")

    val number = readLine()!!.toInt()

    val sum = calculateSum(number)

    println("Summation of digits in $number is $sum")

}

fun calculateSum(number: Int): Int
{
    var sum = 0
    var n = if (number < 0) -number else number

    while (n != 0) {
        sum += n % 10
        n /= 10
    }

    return if (number < 0) -sum else sum

}
fun main()
{
    println("Enter a number:")
    val number = readLine()!!.toInt()

    val maxDigit = findMaxDigit(number)

    println("Max digit in $number is $maxDigit")
}

fun findMaxDigit(number: Int): Int
{
    var maxDigit = Int.MIN_VALUE
    var n = number

    while (n != 0) {
        val digit = n % 10
        if (digit > maxDigit) {
            maxDigit = digit
        }
        n /= 10
    }

    return maxDigit
}
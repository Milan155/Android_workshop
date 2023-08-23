package `tops_&_task`

fun main()
{
    println("Enter a number:")
    val number = readLine()!!.toInt()

    println("Multiplication Table of $number:")

    for (i in 1..10)
    {
        val result = number * i
        println("$number * $i = $result")

    }

}
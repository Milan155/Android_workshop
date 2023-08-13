fun main()
{
    val number = 6

    var factorial = 1

    for (i in 1..number) {

        factorial *= i
    }

    println( "$factorial")

}
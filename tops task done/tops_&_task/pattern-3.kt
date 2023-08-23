package `tops_&_task`

fun main()
{
    for (i in 1..5)
    {
        var abc = i

        for (space in 0..(5 - i))
        {
            print(" ")
        }

        for (abc in 1..i)
        {
            print(" *")


        }

        println()
    }

}
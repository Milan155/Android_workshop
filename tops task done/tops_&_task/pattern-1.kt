package `tops_&_task`

fun main()
{
    for(i in 1..5)
    {
        var my = i

        for(space in 0..(5-i))
        {
            print(" ")
        }

        for(j in 1..i)
        {

            print ("$my")
            my = my - 1
        }


        println()

    }


}
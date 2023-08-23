package `tops_&_task`

fun main() {

    for(i in 1..5)

    {
        for(space in 0..(5-i))
        {
            print(" ")
        }

        for(mm in 1..i)
        {
            print("mm ")
        }
        println()
    }

}
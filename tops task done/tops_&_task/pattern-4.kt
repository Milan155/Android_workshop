package `tops_&_task`

fun main() {

    for(i in 1..5)

    {
        for(space in 0..(5-i))
        {
            print(" ")
        }

        for(a in 1..i)
        {
            print("a")
        }
        println()
    }

}
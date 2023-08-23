package `tops_&_task`

fun main() {
    var counter=1

    for(i in 1..5)
    {
        for(k in 1..i)
        {
            print("$counter ")
            counter=counter+1
        }
        println()
    }

}
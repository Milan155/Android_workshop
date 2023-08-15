fun main()
{
    for(i in 1..5)
    {
        for(space in 0..(5-i))
        {
            print(" ")
        }
        for(m in 1..i)
        {
            print("*")
        }
        println()
    }

}
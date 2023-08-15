fun main() {

    for(i in 1..5)

    {
        for(k in 1..i)

        {
            if ((i + k) % 2 == 0)
            {
                print(" 1")
            }
            else 
            {
                print(" 0")
            }

        }
        println()
    }

}
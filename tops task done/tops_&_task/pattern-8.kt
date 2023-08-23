package `tops_&_task`

fun main()
{
    for(i in 1..5)//row
    {
        for(ml in 1..i)//col
        {
            if(ml <= i)
                print(" " + i*i)

        }
        print("\n")
    }


}
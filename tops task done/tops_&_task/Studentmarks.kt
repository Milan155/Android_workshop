package `tops_&_task`

fun main()
{
    var Hindi=85
    var Science=89
    var Math=56
    var Socialscience=99
    var Computer=71

    var total=Hindi+Science+Math+Socialscience+Computer
    var per=total/5

    println(total)
    println(per)
    if(per>=70)
    {
        print("“Distinction”")
    }
    else if(per>=60)
    {
        print("Second class")
    }
    else if(per>=50)
    {
        print("Pass class")
    }
    else if(per>=40)
    {
        print("Fail")
    }
    else
    {
        print("Fail")
    }

}

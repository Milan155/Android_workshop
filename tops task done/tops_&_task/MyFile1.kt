package `tops_&_task`

import java.io.FileOutputStream

fun main()
{
    try
    {
        var data = "welcome to tops"
        var fout = FileOutputStream("d://tops.txt")
        fout.write(data.toByteArray())

    }
    catch (e: Exception)
    {
        println(e)
    }
    println("sucess")










}

fun main(){
    val num = 23
    var me = false
    for (i in 2..num / 2) {

        if (num % i == 0) {
            me = true
            break
        }
    }

    if (!me)
        println("$num is a prime number.")
    else
        println("$num is not a prime number.")
}


import kotlin.math.min

fun main(args: Array<String>){
    val x = 1
    val y = 2
    val z = 3
    val str = "hello"
    val prime = 23
    println("no. 2")
    println("Cuber(2) :" + cuber(2.0))
    println("****")

    println("no. 4")
    println("min3($x, $y, $z): " + min3(x,y,z))
    println("****")

    println("no. 6")
    println("thirds(\"$str\"): " + thirds(str))
    println("****")

    println("no. 8")
    println("sort3($z,$y,$x): " + sort3(z*1.0,y*1.0,x*1.0))
    println("****")

    println("no. 10")
    println("sqsum(3): "+sqsum(z))
    println("****")

    println("no. 12")
    println("pow($y,$z): " + pow(y*1.0,z))
    println("****")

    println("no. 14")
    println("isPrime($prime): " + isPrime(prime))
    println("****")
}

//no. 2
fun cuber(x : Double) : Double = x*x*x

//no. 4
fun min3(x: Int, y: Int, z: Int): Int{
    if ((x <= y) and (x <= z))
        return x
    else if ((y <= z) and (y <= x))
        return y
    else
        return z
}

//no. 6
fun thirds(str: String): Char{
    return str.get(2);
}

//no. 8
fun sort3(x: Double, y: Double, z:Double): List<Double>{
    return listOf(x,y,z).sorted();
}

//no. 10
fun sqsum(x: Int): Int{
    var n = 0
    var sum = 0
    while (n <= x){
        sum += n*n
        n++
    }
    return sum
}

//no. 12
fun pow(x: Double, y: Int): Double{
    var num = 1.0
    for (n in 1 ..y){
        num *= x
    }
    return num
}

//no. 14
fun  isPrime(x: Int): Boolean{
    for (n in 2 .. x-1)
        if (x%n == 0)
            return false
    return true
}
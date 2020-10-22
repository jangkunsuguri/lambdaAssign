fun main(args: Array<String>){
    println("fun less:")
    println(less("no", listOf("not", "yes", "a", "hello")))

    println("fun more:")
    println(more("no", listOf("not", "yes", "a", "hello")))

    println("fun compare (less):")
    println(compare("no", listOf("not", "yes", "a", "hello"), {x: String, y:String -> x.length < y.length}))

    println("fun compare (more):")
    println(compare("no", listOf("not", "yes", "a", "hello"), {x: String, y:String -> x.length > y.length}))

    println("Quicksort Ascending Order:")
    println(quicksort(listOf(2,5,3,1,4)))

/*    println("Quicksort Descending Order: ")
    println(quicksort(listOf(2,5,3,1,4)))*/
}
//1.a. less function
fun less(e: String, L: List<String>): List<String>{
    if (L.isEmpty())
        return listOf()
    if (L[0].length < e.length)
        return listOf(L[0]) + less(e, L.subList(1,L.size))
    else
        return (less(e, L.subList(1,L.size)))
}

//1.b. more function
fun more(e: String, L: List<String>): List<String>{
    if (L.isEmpty())
        return listOf()
    if (L[0].length > e.length)
        return listOf(L[0]) + more(e, L.subList(1,L.size))
    else
        return (more(e, L.subList(1,L.size)))
}

//1.c. compare function
fun compare(e: String, L: List<String>, comp: (String, String)-> Boolean): List<String>{
    if (L.isEmpty())
        return listOf()
    if (comp(L[0],e))
        return listOf(L[0]) + compare(e, L.subList(1,L.size), comp)
    else
        return compare(e, L.subList(1,L.size), comp)
}

//quicksort
fun quicksort(L: List<Int>): List<Int>{
    if (L.size<=1)
        return L
    else {
        val pivot = L[0]
        val left = partition(pivot, L.subList(1, L.size), {x:Int, y:Int-> x < y})
        val right = partition(pivot, L.subList(1, L.size), {x:Int, y:Int-> x > y})
        return quicksort(left) + pivot + quicksort(right)
    }
}

fun partition( e: Int, L: List<Int>, comp: (Int, Int) -> Boolean): List<Int>{
    if (L.isEmpty())
        return listOf()
    if (comp(L[0],e))
        return listOf(L[0]) + partition(e, L.subList(1,L.size), comp)
    else
        return partition(e, L.subList(1, L.size), comp)
}

/*
fun rightpartition(e: Int, L: List<Int>, comp: (Int, Int) -> Boolean): List<Int>{
    if (L.isEmpty())
        return listOf()
    if (!comp(L[0],e))
        return listOf(L[0]) + rightpartition(e, L.subList(1,L.size), comp)
    else
        return rightpartition(e, L.subList(1, L.size), comp)
}*/

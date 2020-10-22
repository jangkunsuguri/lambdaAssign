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
    println(quicksort(listOf(2,5,3,1,4), {x:Int, y:Int-> x < y}))

    println("Quicksort Descending Order: ")
    println(quicksort(listOf(2,5,3,1,4), {x:Int, y:Int-> x > y}))
}
//no. 1 less function
fun less(e: String, L: List<String>): List<String>{
    if (L.isEmpty())
        return listOf()
    if (L[0].length < e.length)
        return listOf(L[0]) + less(e, L.subList(1,L.size))
    else
        return (less(e, L.subList(1,L.size)))
}

//no. 2 more function
fun more(e: String, L: List<String>): List<String>{
    if (L.isEmpty())
        return listOf()
    if (L[0].length > e.length)
        return listOf(L[0]) + more(e, L.subList(1,L.size))
    else
        return (more(e, L.subList(1,L.size)))
}

//no. 3 compare function
fun compare(e: String, L: List<String>, comp: (String, String)-> Boolean): List<String>{
    if (L.isEmpty())
        return listOf()
    if (comp(L[0],e))
        return listOf(L[0]) + compare(e, L.subList(1,L.size), comp)
    else
        return compare(e, L.subList(1,L.size), comp)
}

//quicksort
fun quicksort(L: List<Int>, comp: (x:Int, y: Int) -> Boolean): List<Int>{
    if (L.size<=1)
        return L
    else {
        val pivot = L[0]
        val left = leftpartition(pivot, L.subList(1, L.size), comp)
        val right = rightpartition(pivot, L.subList(1, L.size), comp)
        return quicksort(left, comp) + pivot + quicksort(right, comp)
    }
}

fun leftpartition(e: Int, L: List<Int>, comp: (x: Int, y: Int) -> Boolean): List<Int>{
    if (L.isEmpty())
        return listOf()
    if (comp(L[0],e))
        return listOf(L[0]) + leftpartition(e, L.subList(1,L.size), comp)
    else
        return leftpartition(e, L.subList(1, L.size), comp)
}
fun rightpartition(e: Int, L: List<Int>, comp: (x: Int, y: Int) -> Boolean): List<Int>{
    if (L.isEmpty())
        return listOf()
    if (!comp(L[0],e))
        return listOf(L[0]) + rightpartition(e, L.subList(1,L.size), comp)
    else
        return rightpartition(e, L.subList(1, L.size), comp)
}
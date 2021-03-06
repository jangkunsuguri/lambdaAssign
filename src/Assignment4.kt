fun main(args: Array<String>){
    println("fun less:")
    println(less("no", listOf("not", "yes", "a", "hello")))

    println("fun more:")
    println(more("no", listOf("not", "yes", "a", "hello")))

    println("fun compare (less):")
    println(compare("no", listOf("not", "yes", "a", "hello")) { x: String, y:String -> x.length < y.length})

    println("fun compare (more):")
    println(compare("no", listOf("not", "yes", "a", "hello")) { x: String, y:String -> x.length > y.length})

    println("Quicksort Ascending Order:")
    println(quicksort(listOf(2,5,3,1,4)) { x:Int, y:Int-> x < y})

    println("Quicksort Descending Order:")
    println(quicksort(listOf(2,5,3,1,4)) { x:Int, y:Int-> x > y})
}
//1.a. less function
fun less(e: String, L: List<String>): List<String>{
    if (L.isEmpty())
        return listOf()
    return if (L[0].length < e.length)
        listOf(L[0]) + less(e, L.subList(1,L.size))
    else
        (less(e, L.subList(1,L.size)))
}

//1.b. more function
fun more(e: String, L: List<String>): List<String>{
    if (L.isEmpty())
        return listOf()
    return if (L[0].length > e.length)
        listOf(L[0]) + more(e, L.subList(1,L.size))
    else
        (more(e, L.subList(1,L.size)))
}

//1.c. compare function
fun compare(e: String, L: List<String>, comp: (String, String)-> Boolean): List<String>{
    if (L.isEmpty())
        return listOf()
    return if (comp(L[0],e))
        listOf(L[0]) + compare(e, L.subList(1,L.size), comp)
    else
        compare(e, L.subList(1,L.size), comp)
}

//quicksort
fun quicksort(L: List<Int>, comp:(Int, Int)-> Boolean): List<Int>{
    //base case for the recursive function
    return if (L.size<=1)
        L
    else {
        //sets the first element of the list as the pivot
        val pivot = L[0]
        //returns the list that for the left side of the pivot (elements less than pivot if x<y greater if x>y)
        val left = partition(pivot, L.subList(1, L.size), comp)
        //returns the list that for the right side of the pivot (elements greater than pivot if x<y less if x>y)
        val right = partition(pivot, L.subList(1, L.size)) { x, y-> !comp(x,y)}
        //recursive call after setting pivot into a correct index
        quicksort(left, comp) + pivot + quicksort(right, comp)
    }
}

//returns the list containing the elements that pass through the condition specified in lambda
fun partition( e: Int, L: List<Int>, comp: (Int, Int)->(Boolean)): List<Int>{
    //base case for the recursive function
    if (L.isEmpty())
        return listOf()
    //adds to the list if condition is met
    return if (comp(L[0],e))
        listOf(L[0]) + partition(e, L.subList(1,L.size), comp)
    //skips the element if condition is not met
    else
        partition(e, L.subList(1, L.size), comp)
}
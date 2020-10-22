//JangKun Suguri
//1021350
fun main(args: Array<String>){
    val shopping = mutableListOf("Tea","Eggs","Milk")
    if (shopping.size > 0) println(shopping.get(0))
    for (item in shopping) println (item)
    if (shopping.contains("Milk"))
        println(shopping.indexOf("Milk"))
    shopping[1] = "Sugar"
    println(shopping[1])
    println("****")
    // 1. what happens if we try to include the above two commented lines
    //element in shopping[1] will change from "Eggs" to "Sugar"     {"Tea", "Sugar", "Milk"}
    // 2. try creating shopping as array
    val shopping_arr = arrayOf("Tea", "Sugar", "Milk")
    for (item in shopping_arr) println(item)
    println("****")
    // 3. what happens if you create shopping as mutableList
    // this list is already a mutable list
    //now try the following lines of code with the three variations
    // the following lines of code can not be executed as the size of the array is set at its initalization
    shopping.add("Coffee")
    for (item in shopping) println (item)
    println("*****")
    shopping.add(1, "Cookies")
    for (item in shopping) println (item)
    println("*****")

    // More code that works with Mutable Lists
    val mShoppingList = mutableListOf("Tea", "Eggs", "Milk")
    println("mShoppingList original: $mShoppingList")
    val extraShopping = listOf("Cookies", "Sugar", "Eggs")
    mShoppingList.addAll(extraShopping)
    println("mShoppingList items added: $mShoppingList")

    if (mShoppingList.contains("Tea")){
        mShoppingList.set(mShoppingList.indexOf("Tea"), "Coffee")
    }
    mShoppingList.sort()
    println("mShoppingList sorted: $mShoppingList")
    mShoppingList.reverse()
    println("mShoppingList reversed: $mShoppingList")

    println("****")

    val shoppingCopy = mShoppingList.toList()
    println("shoppingCopy: $shoppingCopy")
    //try editing shopping copy as follows
    //shoppingCopy.removeAt(3)
    //println("shoppingCopy: $shoppingCopy")
    //shoppingCopy.clear()
    //println("shoppingCopy: $shoppingCopy")
    //the lines of code would have an error since they are not set as a mutable list on line 42
    val shoppingCopy2 = shoppingCopy.toMutableList()
    shoppingCopy2.removeAt(3)
    println("shoppingCopy2: $shoppingCopy2")
    shoppingCopy2.clear()
    println("shoppingCopy2: $shoppingCopy2")

}
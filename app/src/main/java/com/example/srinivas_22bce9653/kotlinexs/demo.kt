package com.example.srinivas_22bce9653.kotlinexs

fun main() {
    var name: String = "Srinivas"
    println(name.commaSeparated("Some other string"))

    println("Hello World!")

    val i: Int = 6
    println(i.toByte())

    // String operations in Kotlin.
    val s1 = "Hello World"
    val s2 = "Hello World!\n"
    val text = """
        var bikes = 50
    """.trimIndent()
    println(s1)
    println(s2)
    println(text)

    // String concatenation in Kotlin.
    val numberOfDogs: Int = 3
    val numberOfCats = 2
    println("I have $numberOfDogs dogs and $numberOfCats cats")

    // String Templates.
    val j = 10
    println("j = $j")

    // String Expressions $ simple indicates simple value. If it is inside the curly braces that is expression.
    val s = "abc"
    println("$s.length is ${s.length}")

    val numberOfShirts = 10
    val numberOfPants = 5
    println("I have ${numberOfShirts + numberOfPants} items of clothing")

    // Variables in kotlin.
    // var and val --> var means mutable(changeable) | val means immutable(unchangeable) like final keyword in java.
    var score = 10
    println(score)
    score = 15
    println(score)

    val myName = "Srinivas"
    println(myName)

    // Conditions and control flow in Kotlin.
    // When statements.
    val results = 15
    when (results) {
        0 -> println("No results")
        in 1..39 -> println("Good results")
        else -> println("That's a lot of results!")
    }

    // if/else statements.
    val numberOfCups = 30
    val numberOfPlates = 50
    if (numberOfCups > numberOfPlates) {
        println("Too many cups!")
    } else {
        println("Not enough cups!")
    }

    // if/else multiple cases.
    val guests = 30
    if (guests == 0) {
        println("No guests")
    } else if (guests < 20) {
        println("Small group of people")
    } else {
        println("Large group of people")
    }

    // Ranges in if/else statements.
    val numberOfStudents = 50
    if (numberOfStudents in 1..100) {
        println(numberOfStudents)
    }

    // for loop.
    val pets = arrayOf("dog", "cat", "canary")
    for (e in pets) {
        print(e + " ")
    }
    println()

    // elements with indexes in for loops.
    for ((i, e) in pets.withIndex()) {
        println("Items at $i is $e")
    }

    // for loops with ranges and step sizes.
    for (k in 1..5) {
        print(k) // in ascending order.
    }
    println()

    for (k in 5 downTo 1) {
        print(k) // in descending order.
    }
    println()

    for (k in 1..6 step 2) {
        print(k) // with step size 2.
    }
    println()

    for (k in 'd'..'k') {
        print(k) // print the alphabets from d to k.
    }
    println()

    // while loops.
    var bicycles = 0
    while (bicycles < 50) {
        bicycles++
    }
    println("$bicycles bicycles are in the bicycle rack\n")

    // do while loop.
    do {
        bicycles--
    } while (bicycles > 0)
    println("$bicycles bicycles are in the bicycle rack\n")

    // Repeat loops.
    repeat(2) {
        println("Hello!")
    }
}

fun String.commaSeparated(values: String): String {
    return "comma separated String -- $values"
}

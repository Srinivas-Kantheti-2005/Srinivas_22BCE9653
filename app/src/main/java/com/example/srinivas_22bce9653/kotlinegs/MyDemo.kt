package com.example.srinivas_22bce9653.kotlinegs

import kotlin.math.*

/*fun main() {
    var someLambda: (Int, Int) -> Int = { a, b -> a + b }
    println(someLambda(10, 20))

    var otherLambda: (Int, Int, String) -> Int = { a, b, msg ->
        println(msg + a * b)
        a * b
    }
    println(otherLambda(10, 20, "The result is: "))
}*/

var lambda : (Int) -> Int = { a -> a*a }

fun operation(): (Int) -> Int {
    return :: square
}

fun square(x: Int) = x * x

fun main() {
    val func = operation()
    println(func(2))
}
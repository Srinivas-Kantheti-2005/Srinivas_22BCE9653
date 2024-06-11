package com.example.srinivas_22bce9653.kotlinexs

class PrintImpl: IPrint {
    override fun printSomething() {
        println("Printing something from printimpl class")

//        // Life after lamda.
//        var iPrint:  () -> { println("Print some thing else from lambda") };
    }
}
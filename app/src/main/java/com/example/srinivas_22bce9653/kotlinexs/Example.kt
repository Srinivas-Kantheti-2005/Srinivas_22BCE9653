package com.example.srinivas_22bce9653.kotlinexs

fun main() {
    println("Hello World!");
    var myStudent: Student = Student("Srinivas", 20, "Thullur")
    println(myStudent.name)
    myStudent.name="Srinvias Kantheti"
    println(myStudent.name)

    var myEmployee: Employee = Employee("Titas", 23, "Kantheru")
    println(myEmployee.getName())
    println(myEmployee.name)
}
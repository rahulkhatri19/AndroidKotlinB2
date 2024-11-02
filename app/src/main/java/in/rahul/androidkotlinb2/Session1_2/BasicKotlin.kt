package `in`.rahul.androidkotlinb2.Session1_2

class BasicKotlin {
}

fun main(){

}

fun variablesNDataType(){
    var age = 25
    age = 30

    val name = "Alice"

//    Primitive data types:
//Int: Integer numbers
//Double: Floating-point numbers
//Float: Single-precision floating-point numbers
//Char: Single characters
//Boolean: Boolean values (true or false)
}

fun operators() {
//   Arithmetic operators: +, -, *, /, %
    var sum1 = 100 + 50
//  Assignment operators: +=, -=, *=, /=, %=
    var x = 10
    x += 5
//    Comparison operators: == (equal to), != (not equal to), < (less than), > (greater than), <= (less than or equal to), >= (greater than or equal to)
//Logical operators:
    x < 5 && x < 10
//&& (logical AND), || (logical OR), ! (logical NOT)
}

fun controlFlow(){
    val x= 5
    val y = 6
    if (x>y) {
        // code to execute if condition is true
    } else {
        // code to execute if condition is false
    }

    when (x) {
        in 1..10 -> println("x is in the range of 1 to 10")
        else -> { /* default code */ }
    }

    when {
        x > 10 -> println("x is greater than 10")
        x < 10 -> println("x is less than 10")
        else -> println("x is 10")
    }
}

fun function(name: String): String {
    return "Hello, $name!"
}

fun lambda(){
    val greetLambda: (String) -> String = { name -> "Hello, $name!" }
}

class Person {
    var name: String = ""
    var age: Int = 0
}

//      Creating Objects:
//Use the class keyword to define a class.
//Create instances of the class using the object keyword.
//      Object Expressions:
//Define and create an object in a single expression.
//Useful for creating simple objects without a class declaration.
//      Companion Objects:
//Associated with a class and can hold static-like members.
//Useful for defining utility functions or constants.

class MyClass {
    companion object {
        const val PI = 3.14159

        fun calculateArea(radius: Double): Double {
            return PI * radius * radius
        }
    }
}

//  Inheritance
open class Animal(val name: String) {
    open fun makeSound() {
        println("Generic animal sound")
    }
}

class Dog(name: String) : Animal(name) {
    override fun makeSound() {
        println("Woof!")
    }
}

// Interfaces
interface Shape {
    fun area(): Double
    fun perimeter(): Double
}

class Circle(val radius: Double) : Shape {
    override fun area(): Double = Math.PI * radius * radius
    override fun perimeter(): Double = 2 * Math.PI * radius
}

//  method Overloading
class Calculator {
    fun add(a: Int, b: Int): Int {
        return a + b
    }

    fun add(a: Double, b: Double): Double {
        return a + b
    }

    fun add(a: Int, b: Int, c: Int): Int {
        return a + b + c
    }
}

// Method Overriding
open class Animals {
    open fun makeSound() {
        println("Generic animal sound")
    }
}

class Tiger : Animals() {
    override fun makeSound() {
        println("Woof!")
    }
}

class Cat : Animals() {
    override fun makeSound() {
        println("Meow!")
    }
}

package com.example.project1.Clases

//class Variables {

fun main(){

    //Variables Númericas
    val edad:Int = 20;
    val long_number:Long = 987654321288998888;
    val temperature:Float = 27.123f;
    val weight:Double = 60.4;

    //Variables String
    val gender:Char = 'M';
    val name:String = "Daian Nieves";

    //Boolean
    var isGreater:Boolean = false;

    //Array
    val names = arrayOf("Daian", "Nataly", "Eduardo", "Gabriela");

    println(edad);
    println("Welcome $name, to your first Kotlin project");
    println(add())
    println(product(x=10,y=92))
    println(printArray(names))

    println(names.joinToString())

    val numbers = arrayOf(1,2,3,4,5,6,7,8,9);
    isEven(numbers)

    println (getDay(1))

    val person = Person(name = "Andrea", age = 22)

    println(person.name)
    println(person.age)

    person.displayInformation()
}

fun add():Int {
    val x = 5;
    val y = 10;

    return (x+y);
}

fun product(x:Int, y:Int):Int {
    return (x+y);
}

fun printArray(names:Array<String>){
    for (name in names){
        print("Hello $name")
    }
}

fun isEven(numbers:Array<Int>){
    for (number in numbers){
        if (number%2 == 0){
            println("El numero $number es Par")
        }else{
            println("El numero $number no es Par")
        }
    }
}

fun getDay(day:Int):String{
    var name = ""
    when(day){
        1 -> name = "Monday";
        2 -> name = "Tuesday";
        3 -> name = "Wednesday";
        4 -> name = "Thursday";
        5 -> name = "Friday";
        6 -> name = "Saturday";
        7 -> name = "Sunday";
        else -> name = "Incorrect value";
    }
    return name
}

class Person (val name:String, val age:Int){
    fun displayInformation(){
        println("Name: $name, Age: $age")
    }
}
//}
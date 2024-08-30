package com.example.prueba.clases

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
        val names = arrayOf("Daián", "Nataly", "Eduardo", "Gabriela");

        println(edad);
        println("Welcome $name, to your first Kotlin project");
        println(add())
        println(product(x=10,y=92))
       }

fun add():Int {
    val x = 5;
    val y = 10;

    return (x+y);
}

fun product(x:Int, y:Int):Int {

    return (x+y);

}
//}
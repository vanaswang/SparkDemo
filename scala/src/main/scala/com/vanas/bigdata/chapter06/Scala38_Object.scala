package com.vanas.bigdata.chapter06

/**
 * @author Vanas
 * @create 2020-05-26 9:55 上午 
 */
object Scala38_Object {
    def main(args: Array[String]): Unit = {
        println(Color.BLUE.id)
        println(Color.RED)


    }
}

object Color extends Enumeration {
    val RED = Value(1, "red")
    val YELLOW = Value(2, "yellow")
    val BLUE = Value(3, "blue")
}
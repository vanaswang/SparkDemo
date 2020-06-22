package com.vanas.bigdata.test2

/**
 *
 * @author Vanas
 * @create 2020-06-21 10:53 上午 
 */
object Test3 {
    implicit val aa = 100

    def main(args: Array[String]): Unit = {

        println(foo(10)(200)) //210
        println(foo(10)) //使用的是隐式值   110
        println(foo(10)()) //使用的是默认值  310


        val arr1 = Array(30, 50, 70, 60, 10, 20)


    }

    def foo(a: Int)(implicit b: Int = 300) = a + b

}

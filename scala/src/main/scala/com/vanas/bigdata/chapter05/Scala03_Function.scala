package com.vanas.bigdata.chapter05

/**
 * @author Vanas
 * @create 2020-05-20 11:09 上午 
 */
object Scala03_Function {

    def main(args: Array[String]): Unit = {
        //        scala函数式编程
        // 无参，无返回值
        def fun1(): Unit = {
            println("fun1...")
        }

        fun1()

        //无参，有返回值
        def fun2(): String = {
            return "zhangsan"
        }

        println(fun2())

        //有参，无返回值
        def fun3(s: String): Unit = {
            println("name=" + s)
        }

        fun3("zhangsan")

        //有参，有返回值
        def fun4(name: String): String = {
            return "name=" + name
        }

        print(fun4("zhangsan"))

        //多参，无返回值
        def fun5(name: String, age: Int): Unit = {
            println(
                s"""
                   |{"username":"$name","age":$age}
                   |""".stripMargin)
        }
        fun5("zhangsan",22)

        //多参，有返回值
        def  fun6(name: String, age: Int): String ={
            return s"name=$name,age=$age"
        }
        println(fun6("zhangsan",25))
    }

}

package com.vanas.bigdata.chapter06

/**
 * @author Vanas
 * @create 2020-05-23 2:08 下午 
 */
object Scala23_Method_Instance {
    def main(args: Array[String]): Unit = {
        // scala -面向对象-构造方法


        //先构造父类 再构造子类
        val user = new User("wangwu")
        //AAAA
        //CCCC
        //DDDD

    }

    class Person(name: String) {
        println("AAA")

        def this() = {
            this("zhangsan")
            println("BBBB")
        }

    }

    class User() extends Person("zhangsan") {
        println("CCCC")

        def this(name: String) = {
            this()
            println("DDDD")
        }
    }


}
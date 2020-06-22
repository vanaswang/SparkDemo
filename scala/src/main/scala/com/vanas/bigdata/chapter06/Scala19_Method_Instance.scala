package com.vanas.bigdata.chapter06

/**
 * @author Vanas
 * @create 2020-05-23 2:08 下午 
 */
object Scala19_Method_Instance {
    def main(args: Array[String]): Unit = {
        // scala -面向对象-构造方法
        //Scala构造方法只有一个吗？
        //不是，scala中提供了2种不同的构造方法
        //1.主构造方法：在类名后的构造方法，可以完成类的初始化
        //2.辅助构造方法：为了完成类初始化的辅助功能而提供的构造方法
        //              声明方式为：def this()
        //              在使用辅助构造方法时，必须直接或间接调用主构造方法
        //              辅助构造方法存在重载的概念
        //              辅助构造方法间接调用主构造函数时，需要保证调用的其他辅助构造函数已经声明过
        val user1 = new User()
        val user2 = new User("zzhangsan")
        val user3 = new User("lisi",30)
        println(user1)
        println(user2)
        println(user3)
    }

    class User() {

        println("xxxx")

        def this(name: String) = {
            this()
        }

        def this(name: String, age: Int) = {
            this(name)     //name的构造方法必须在前
        }
    }

}
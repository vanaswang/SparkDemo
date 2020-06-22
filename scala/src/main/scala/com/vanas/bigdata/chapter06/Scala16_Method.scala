package com.vanas.bigdata.chapter06

import java.util.Date

/**
 * @author Vanas
 * @create 2020-05-23 2:08 下午 
 */
object Scala16_Method {
    def main(args: Array[String]): Unit = {
        // scala -面向对象-方法-apply(应用）
        //apply主要作用用于构建对象
        //私有的构造方法
        //使用new ，等同于调用对象的构造方法构建对象
        val user = new User16()

        //apply方法一般用于object伴生对象中构建对象
        //伴生对象可以访问伴生类的私有属性和方法
        //Scala会自动识别apply方法，所以调用伴生对象的apply方法时，apply方法名可以省略
        //        val user1 = User16.apply()
        for (i <- Range(1, 5)) {

        }
        //如果不实用new来构建对象，那么等同于调用伴生对象的apply方法
        //如果将伴生对象不实用小括号操作，那么等同于将伴生对象赋值给变量，而不是调用apply方法
        //apply方法如果想要被编译器自动识别，那么不能省略小括号
        //apply方法主要用于构建对象，但是构建对象不一定是当前类的对象

        //apply方法可以重载
        val user1 = User16()
        println(user1)

        Range(1, 2)

        val user2 = User16("zhangsan")

    }

}

class User16 {

}

object User16 {
    def apply(): User16 = {
        //        new User16()
        new User16
    }

    //    def apply(): Date = {
    //        new java.util.Date()
    //    }

    def apply(name: String): User16 = {
        println("name" + name)
        new User16
    }
}


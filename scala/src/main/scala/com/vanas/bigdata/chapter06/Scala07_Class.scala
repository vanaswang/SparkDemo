package com.vanas.bigdata.chapter06

/**
 * @author Vanas
 * @create 2020-05-23 2:08 下午 
 */
object Scala07_Class {
    def main(args: Array[String]): Unit = {
        // scala -面向对象-Class

        //Thread sleep，wait方法的区别？
        //object 一般用于声明静态方法，通过类名直接访问
        //如果需要通过对象访问属性或方法，那么就使用class声明
        //如果需要通过类名就可以直接访问属性或方法，那么就使用object声明


        //构建对象
        //使用class来声明，那么需要new的方式
        //new对象时，由于构造方法无参的原因，小括号可以省略
        val user = new User07()
        val user3 = new User07
        println(user)
        println(user3)

        //使用object来声明，那么可以直接使用类名,但是获取的是伴生对象
        //不能使用new
        val user2 = User077
        println(user2)


        //调用方法
        //使用class声明的类无法通过类名直接访问方法或属性，必须构建对象
        //User07. //error
        //使用object声明的类可以通过类名直接访问属性或方法
        User077.test2()


    }

}

class User07 {
    def test1(): Unit = {
        println("user...")
    }
}

object User077 {
    def test2(): Unit = {
        println("object...")
    }

}

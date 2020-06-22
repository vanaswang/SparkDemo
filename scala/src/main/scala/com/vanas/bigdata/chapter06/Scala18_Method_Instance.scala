package com.vanas.bigdata.chapter06

/**
 * @author Vanas
 * @create 2020-05-23 2:08 下午 
 */
object Scala18_Method_Instance {
    def main(args: Array[String]): Unit = {
        // scala -面向对象-构造方法
        //使用new关键字创建的对象其实等荣誉调用类的构造方法
        //scala是一个完全面向对象的语言
        //scala还是一个完全面向函数的语言
        //scala中类其实也是一个函数，类名其实就是函数名,类名后面可以增加括号，表示函数参数列表
        //类名所代表的函数其实就是构造方法，构造函数
        //构造方法执行时，会完成类的主体内容的初始化
        val user = new User()


    }

    class User() {
        var name: String = _
        //类体 & 函数体
        println("User。。。。")

        //public User（）{}
        //普通方法
        def User() = {
            println("user...init")
        }

    }

}
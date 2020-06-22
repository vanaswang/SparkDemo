package com.vanas.bigdata.test2

/**
 *
 * @author Vanas
 * @create 2020-06-21 10:53 上午 
 */
object Test5 {
    implicit val aa = 100

    def main(args: Array[String]): Unit = {

        val user = new User
        user.apply(20)
        User(10)

        //def声明的是方法 ，其他是函数
    }

    object User {
        def apply(a: Int) = println(a) //调用就是执行apply方法

    }

    class User {
        def apply(a: Int) = println(a)
    }

}

package com.vanas.bigdata.chapter06

//import java.sql.{Date => _, Array => _, _} //前者 不起作用 后者起作用

import java.util.{Date => UtilDate}


/**
 * @author Vanas
 * @create 2020-05-23 2:08 下午 
 */
object Scala04_Import {
    def main(args: Array[String]): Unit = {
        // scala -面向对象-import
        //1.导类，不是导包
        //2. import static 静态导入类的静态属性和静态方法
        //java语法中import操作功能比较单一，但是不能舍弃
        //scala语言在java的语法基础上进行扩展

        //1。import可以声明在任意的位置  一目了然、清晰
        //        import java.util.Date
        //        val date = new Date()
        //2。 java中默认导入的类是java.lang包中的类
        //        Scala中默认导入的类
        //        2。1 java.lang包中所有的类
        //        2。2 scala包中的类
        //        2。3 Predef
        //        println("")
        //3.Scala中的import可以导包

        //        import java.sql
        //        val date1 = new sql.Date()
        //4.导入包中所有的类
        //scala 中使用下划线代替java中的星号* 因为*在scala中有歧义
        //import java.util.*
        //        import java.util._

        //5.可以在一行中导入同一个包的多个类
        //        import java.util.{ArrayList, HashMap}
        //        new ArrayList()
        //        new HashMap()

        //6. 使用import关键字将包中的类隐藏掉

        //        new Date()
        //        new ArrayList()
        //7. 使用import关键字将指定类起别名
        //        new UtilDate()
        //scala中没有字符串，直接使用java的字符串
        //        val s: String = "avc"
        //        type UtilDate = java.util.Date
        //        val a: UtilDate = new UtilDate

        //8. scala默认import 是按照包的相对路径进行导入的
        //双亲委派机制-没起作用
        //如果不想使用相对路径，可么可以采用特殊的路径访问（root）访问
        new java.util.HashMap()
        println(new _root_.java.util.HashMap()) //{}

    }


}

//package java{
//    package util{
//        class HashMap{
//            println("xxxxx")
//        }
//    }
//}

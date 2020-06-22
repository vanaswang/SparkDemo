package com.vanas.bigdata.chapter05

/**
 * @author Vanas
 * @create 2020-05-20 11:09 上午 
 */
object Scala02_Function {

    def main(args: Array[String]): Unit = {
        //        scala函数式编程
        //函数 & 方法 区别
        //芳芳的概念来自于Java
        //函数概念来自于scala
        //scala也是完全是函数式编程语言，所以方法其实就是函数
        //一般情况下，将类中封装的功能函数称之为方法
        //其他地方封装的功能就称之为函数了
        //函数可以声明在任意地方，也可以嵌套声明使用
        //类中的函数就是方法，符合java的语法规则：重写 & 重载
        //函数是没有重写和重载的概念

        def test(): Unit = {
            println("xxx")
        }
//        def test(s:String): Unit ={ //函数没有重载概念
//            println("xxx")
//        }

        test()
        println("zhangsan");
        println("zhangsan");
        println("zhangsan");

    }

    def test1(): Unit = {
        println("test1..")
    }

    def test1(s: String): Unit = {
        println("test1..")
    }

}

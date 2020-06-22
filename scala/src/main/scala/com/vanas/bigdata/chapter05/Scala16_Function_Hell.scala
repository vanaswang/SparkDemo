package com.vanas.bigdata.chapter05

/**
 * @author Vanas
 * @create 2020-05-20 11:09 上午 
 */
object Scala16_Function_Hell {

    def main(args: Array[String]): Unit = {
        //函数编程 -柯里化
        def test() ={
            def fun(): Unit ={
                println("xxxx")
            }
            fun _

        }

        test()()

        //使用函数柯里化的方式声明函数
        //所谓的柯里化，其实就是多个参数列表
        //好处 ：1.简化嵌套函数开发
//        2.将复杂的参数逻辑简单化,可以支持更多的语法
        def test1()(): Unit ={
            println("test....")
        }

        test1()()

        def test2(i:Int)(j:Int)(f:(Int, Int)=>Int)={
           f(i,j)
        }

        println(test2(1)(2)(_+_))

    }


}

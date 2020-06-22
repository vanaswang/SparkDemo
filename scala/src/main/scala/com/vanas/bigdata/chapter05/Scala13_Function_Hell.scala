package com.vanas.bigdata.chapter05

/**
 * @author Vanas
 * @create 2020-05-20 11:09 上午 
 */
object Scala13_Function_Hell {

    def main(args: Array[String]): Unit = {
        //函数编程 -地狱版
        //将函数作为返回值使用
        //将函数的执行结果返回
        def test(i: Int): Int = {
            i * 2
        }


        def fun() = {
            test _
        }

        //调用函数
        val a = fun() //当前fun函数的执行结果为函数，那么a此时就是函数
        println(a(10))

        println(fun()(10))

        //当函数作为返回值使用时，一般会使用嵌套函数
        def fun1() {
            def test(i: Int) = {
                i * 2
            }

            test _
        }

        println(fun()(10))

//如果不想使用下划线返回 返回对象 那么需要显示声明函数的返回值类型
        def fun2(): Int => Int = {
            def test2(i: Int): Int = {
                i * 2
            }
            test2
        }
    }


}

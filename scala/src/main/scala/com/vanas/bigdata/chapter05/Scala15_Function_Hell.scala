package com.vanas.bigdata.chapter05

/**
 * @author Vanas
 * @create 2020-05-20 11:09 上午 
 */
object Scala15_Function_Hell {

    def main(args: Array[String]): Unit = {
        //函数编程 -地狱版

        //1.函数使用外部变量
        //当前场合不叫闭包  a没有改变声明周期
        val a = 10

        def test(): Unit = {
            val b = a + 10
        }

        test()
    }


}

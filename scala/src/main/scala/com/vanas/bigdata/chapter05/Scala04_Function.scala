package com.vanas.bigdata.chapter05

/**
 * @author Vanas
 * @create 2020-05-20 11:09 上午 
 */
object Scala04_Function {

    def main(args: Array[String]): Unit = {
        //函数嵌套函数 方法里不可以嵌套方法
        def test(): Unit ={
            println("yyyy")
        }
        test  //yyyy 就近 看作用域范围

    }
    def test(): Unit ={
        println("asdf")
    }

}

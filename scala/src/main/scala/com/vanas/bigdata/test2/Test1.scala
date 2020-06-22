package com.vanas.bigdata.test2

/**
 * 可变参数
 *
 * @author Vanas
 * @create 2020-06-21 10:53 上午 
 */
object Test1 {
    def main(args: Array[String]): Unit = {
        foo(10)

        val arr = Array(30, 50, 70, 60, 10, 20)
        foo(100, arr(1), arr(2)) //拆开一个个传过去

        foo(100, arr: _*) //拆开一个个传过去
        val arr1: Array[Int] = map(arr, x => x * x)
        println(arr1.toList)

    }

    def foo(one: Int, others: Int*) = {

    }

    def map(arr: Array[Int], op: Int => Int): Array[Int] = {
        //for 推导
        for (elem <- arr) yield op(elem)
    }

}

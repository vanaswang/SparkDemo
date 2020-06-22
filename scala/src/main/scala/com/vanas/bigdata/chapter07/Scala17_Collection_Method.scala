package com.vanas.bigdata.chapter07

import scala.collection.mutable

/**
 * @author Vanas
 * @create 2020-05-26 3:56 下午 
 */
object Scala17_Collection_Method {
    def main(args: Array[String]): Unit = {

        //Scala-集合-常用方法
        var list = List(1, 2, 3, 4)
        //获取集合的长度  底层size就是length
        println(list.length)
        println(list.size)

        //遍历数据
        list.foreach(println)
        println(list.mkString(","))
        val iterator: Iterator[Int] = list.iterator

        //判断是否为空
        println(list.isEmpty)

        //简单运算
        println(list.sum)
        println(list.max)
        println(list.min)
        println(list.product) //乘积

    }

}

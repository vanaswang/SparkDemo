package com.vanas.bigdata.chapter07

import scala.collection.mutable.ArrayBuffer

/**
 * @author Vanas
 * @create 2020-05-26 3:56 下午 
 */
object Scala03_Collection_Array {
    def main(args: Array[String]): Unit = {

        //Scala-集合-数组-可变
        //类似于StringBuilder
        //可变数组在mutable包中
        val array = new ArrayBuffer[String]()

        //数据的操作
        //追加数据
        array.append("a")
        array.append("b")
        //遍历
        for (s <- array) {
            println("s=" + s)
        }
        println(array) //ArrayBuffer(a, b)
        println(array.mkString(","))

    }

}

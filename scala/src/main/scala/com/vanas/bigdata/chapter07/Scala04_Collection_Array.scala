package com.vanas.bigdata.chapter07

import scala.collection.mutable.ArrayBuffer

/**
 * @author Vanas
 * @create 2020-05-26 3:56 下午 
 */
object Scala04_Collection_Array {
    def main(args: Array[String]): Unit = {

        //Scala-集合-数组-可变
        //类似于StringBuilder
        //可变数组在mutable包中
        // val array = new ArrayBuffer[String]()
        val array = ArrayBuffer(1, 2, 3, 4)

        //数据的操作
        //追加数据,集合内部元素发生改变，所以可变数组
        array.append(5)
        //向指定位置（索引）插入数据
        array.insert(1, 7, 8, 9)

        //对指定的位置（索引）修改数据
//        array(1) = 5  ==>编译时，自动转换为update
        array.update(1,2)  //不要越界

        //删除数据
//        array.remove(2)
        array.remove(2,2) //不可以超出 否则IndexOutOfBoundsException


        //遍历
        println(array)
        println(array.mkString(","))

    }

}

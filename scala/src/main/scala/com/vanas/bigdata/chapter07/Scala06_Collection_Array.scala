package com.vanas.bigdata.chapter07

import scala.collection.mutable.ArrayBuffer

/**
 * @author Vanas
 * @create 2020-05-26 3:56 下午 
 */
object Scala06_Collection_Array {
    def main(args: Array[String]): Unit = {

        //foreach
        //循环遍历
        val array = Array(1, 2, 3, 4)
//        val array = TestArray(1,2,3,4)
        def fun(i: Int): Unit = {
            println(i)
        }
        array.foreach(fun)

        //至简原则  匿名函数
//        array.foreach((i:Int)=>{println(i)})
//        array.foreach(i=>println(i))
//        array.foreach(println(_))
        array.foreach(println)

        // 多维数组
        var myMatrix = Array.ofDim[Int](3,3)
        myMatrix.foreach(list=>list.foreach(println))

        // 合并数组
        val arr1 = Array(1,2,3,4)
        val arr2 = Array(5,6,7,8)
        val arr6: Array[Int] = Array.concat(arr1, arr2)
//        arr6.foreach(println)
        println(arr6.mkString(",")) //这种输出更直观

        // 创建指定范围的数组
        val arr7: Array[Int] = Array.range(0,2)
        //arr7.foreach(println)
        println(arr7.mkString(","))

        // 创建并填充指定数量的数组
        val arr8:Array[Int] = Array.fill[Int](5)(-1)
//        arr8.foreach(println)
        println(arr8.mkString(","))
    }
    class TestArray {
        val buffer = new ArrayBuffer[Int]()
        def foreach(f: Int => Unit): Unit = {
            for (i <- buffer) {
                f(i)
            }
        }
    }
    object TestArray {
        def apply(is: Int*) = {
            val array = new TestArray()
            for (i <- is) {
                array.buffer.append(i)
            }
            array
        }
    }
}

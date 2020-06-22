package com.vanas.bigdata.chapter07

/**
 * @author Vanas
 * @create 2020-05-26 3:56 下午 
 */
object Scala30_Collection_Method {
    def main(args: Array[String]): Unit = {
        //scala -集合-合并集合
        val list = List(1, 2, 3, 4)
        //fold方法直接获取最终的结果
        //scan类似于fold方法，但是会将中间的处理结果也保留下来
        //集合扫描
        //0，1，3，6，10
        println(list.scan(0)(_ + _))
        //集合扫描（左）
        println(list.scanLeft(0)(_ + _))
        //集合扫描（右）
        //List(10, 9, 7, 4, 0)
        println(list.scanRight(0)(_ + _))
    }
}

package com.vanas.bigdata.chapter07

/**
 * @author Vanas
 * @create 2020-05-26 3:56 下午 
 */
object Scala10_Collection_Set {
    def main(args: Array[String]): Unit = {

        //Scala -集合 -Set-集
        //默认集合是不可变集合

        //java:set 无序不可重复
        val set = Set(1, 2, 3, 4)
        val newSet: Set[Int] = set + 5
        println(set eq newSet)
        println(set)
        println(newSet)


        //Scala Set
        //无序：插入顺序
        //不可重复
        val set1 = Set(1, 2, 3, 4, 5, 6, 7, 8, 1)
        println(set1)


    }

}

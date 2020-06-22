package com.vanas.bigdata.chapter07

import scala.collection.mutable

/**
 * @author Vanas
 * @create 2020-05-26 3:56 下午 
 */
object Scala12_Collection_Map {
    def main(args: Array[String]): Unit = {

        //Scala -集合 -Map-映射
        //A=>B
        //K=>V
        //map集合用于存储kv对对象
        //构建键值对对象
        //A->B

        //构建对象
        //map:无序，key不能重复
//        val map: Map[String, Int] = Map("a" -> 1, "b" -> 2, "c" -> 3, "d" -> 4, "e" -> 5)
        //相同key第二次赋值会覆盖
        val map: Map[String, Int] = Map("a" -> 1, "b" -> 2, "c" -> 3, "a" -> 4, "e" -> 5)


        println(map)

    }

}

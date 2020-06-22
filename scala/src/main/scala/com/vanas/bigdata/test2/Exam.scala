package com.vanas.bigdata.test2

import scala.collection.mutable

/**
 * @author Vanas
 * @create 2020-06-01 8:07 下午 
 */
object Exam {
    def main(args: Array[String]): Unit = {
        val tokens = "one two three four two two three four".split(" ")
        val map = new mutable.HashMap[String,Int]
        for(key <- tokens)
        {
            map(key) = map.getOrElse(key, 0) + 1
        }
        println(map)

    }


}

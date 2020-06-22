package com.vanas.bigdata.chapter07

/**
 * @author Vanas
 * @create 2020-05-26 3:56 下午 
 */
object Scala21_Collection_WordCount {
    def main(args: Array[String]): Unit = {
        //scala-WordCount
        val dataList = List("hello spark scala hive")

        //简化
        val result: List[(String, Int)] = dataList
                .flatMap(_.split(" "))
                .groupBy(word => word)
                .map(kv => (kv._1, kv._2.size))
                .toList
                .sortBy(_._2)
                .take(3)

        println(result)


    }

}

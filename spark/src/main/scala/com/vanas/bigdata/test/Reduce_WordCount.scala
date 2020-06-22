package com.vanas.bigdata.test

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author Vanas
 * @create 2020-06-01 4:05 下午
 */
object Reduce_WordCount {
    def main(args: Array[String]): Unit = {
        //Spark _WordCount
        val sparkConf = new SparkConf().setMaster("local").setAppName("wordcount")
        val sc = new SparkContext(sparkConf)
        val rdd: RDD[String] = sc.makeRDD(List("a", "b", "c", "d"))
        //reduce (Map,Map)=>Map

        val mapRDD: RDD[Map[String, Int]] = rdd.map(word => Map[String, Int]((word, 1)))
        val result: Map[String, Int] = mapRDD.reduce(
            (map1, map2) => {
                map1.foldLeft(map2)(
                    (map, kv) => {
                        val word = kv._1
                        val count = kv._2
                        map.updated(kv._1, map.getOrElse(word, 0) + count)

                    }
                )
            }
        )

        result.foreach(println)

        sc.stop()
    }
}

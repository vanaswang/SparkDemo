package com.vanas.bigdata.test

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author Vanas
 * @create 2020-06-01 4:05 下午
 */
object Fold_WordCount {
    def main(args: Array[String]): Unit = {
        //Spark _WordCount
        //groupByKey
        val sparkConf = new SparkConf().setMaster("local").setAppName("wordcount")
        val sc = new SparkContext(sparkConf)
        val rdd: RDD[String] = sc.makeRDD(List("a", "b", "c", "d"))


        //1.groupBy
        //2.groupByKey
        //3.educeByKey
        //4.aggregateByKey
        //5.foldByKey
        //6.combineByKey
        //7.countByKey
        //8.countByValue
        //9.reduce,fold,aggregate


        //fold
        val mapRDD: RDD[Map[String, Int]] = rdd.map(word => Map[String, Int]((word, 1)))
        val result: Map[String, Int] = mapRDD.fold(Map[String, Int]())(
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


        //aggregate
        val map: Map[String, Int] = rdd.aggregate(Map[String, Int]())(
            (map, k) => {
                map.updated(k, map.getOrElse(k, 0) + 1)
            },
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
        map.foreach(println)

        sc.stop()
    }
}

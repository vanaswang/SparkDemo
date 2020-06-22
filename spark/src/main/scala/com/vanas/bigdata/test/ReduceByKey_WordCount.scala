package com.vanas.bigdata.test

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author Vanas
 * @create 2020-06-01 4:05 下午
 */
object ReduceByKey_WordCount {
    def main(args: Array[String]): Unit = {
        //Spark _WordCount
        //reduceByKey
        val sparkConf = new SparkConf().setMaster("local").setAppName("wordcount")
        val sc = new SparkContext(sparkConf)
        val fileRDD: RDD[String] = sc.textFile("input/word.txt")

        val result: RDD[(String, Int)] = fileRDD.flatMap(_.split(" ")).map(
            word => (word, 1)).reduceByKey(_ + _)
        println(result.collect().mkString(","))

        sc.stop()
    }
}

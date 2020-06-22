package com.vanas.bigdata.test

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author Vanas
 * @create 2020-06-01 4:05 下午
 */
object CountByValue_WordCount {
    def main(args: Array[String]): Unit = {
        //Spark _WordCount
        //reduceByKey
        val sparkConf = new SparkConf().setMaster("local").setAppName("wordcount")
        val sc = new SparkContext(sparkConf)
        val fileRDD: RDD[String] = sc.textFile("input/word.txt")

        val result: collection.Map[String, Long] = fileRDD.flatMap(_.split(" ")).countByValue()
        result.foreach(println)

        sc.stop()
    }
}

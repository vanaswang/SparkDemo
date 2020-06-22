package com.vanas.bigdata.test

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author Vanas
 * @create 2020-06-01 4:05 下午
 */
object GroupBy_Wordcount {
    def main(args: Array[String]): Unit = {
        //Spark _WordCount
        //groupBy

        val sparkConf = new SparkConf().setMaster("local").setAppName("wordcount")
        val sc = new SparkContext(sparkConf)
        val fileRDD: RDD[String] = sc.textFile("input/word.txt")
        val result: RDD[(String, Int)] = fileRDD.flatMap(_.split(" ")).groupBy(word => word).map {
            case (word, iter) => (word, iter.size)
        }
        println(result.collect().mkString(","))
        sc.stop()
    }
}

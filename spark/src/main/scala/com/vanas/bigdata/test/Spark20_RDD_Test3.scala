package com.vanas.bigdata.test

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author Vanas
 * @create 2020-06-02 4:04 下午 
 */
object Spark20_RDD_Test3 {
    def main(args: Array[String]): Unit = {


        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File-RDD")
        val sc = new SparkContext(sparkConf)
        //WordCount
        val fileRDD: RDD[String] = sc.textFile("input/word.txt")
        val dataRDD: RDD[(String, Iterable[String])] = fileRDD.flatMap(_.split(" ")).groupBy(word => word)

        val rdd: RDD[(String, Int)] = dataRDD.map(kv => (kv._1, kv._2.size))
        println(rdd.collect().mkString(","))

        sc.stop()
    }
}

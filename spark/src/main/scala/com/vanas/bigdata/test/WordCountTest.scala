package com.vanas.bigdata.test

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author Vanas
 * @create 2020-06-01 10:25 下午 
 */
object WordCountTest {
    def main(args: Array[String]): Unit = {
        //准备spark环境
        val sparkConf: SparkConf = new SparkConf().setMaster("local").setAppName("wordcount")
        //建立spark连接
        val sc = new SparkContext(sparkConf)

        //实现业务
        val fileRDD: RDD[String] = sc.textFile("input")
        //        val mapRDD: RDD[(String, Int)] = fileRDD.flatMap(_.split(" ")).map(word => (word, 1))
        //        val wordToSumRdd: RDD[(String, Int)] = mapRDD.reduceByKey(_ + _)
        //        println(wordToSumRdd.collect().mkString(","))

        println(fileRDD.flatMap(_.split(" ")).groupBy(word => word).map {
            case (word, iter) => {
                (word, iter.size)
            }
        }.collect().mkString(","))

        val value: RDD[(String, Iterable[String])] = fileRDD.flatMap(_.split(" ")).groupBy(word => word)

        //关闭资源
        sc.stop()
    }
}

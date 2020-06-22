package com.vanas.bigdata.test

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author Vanas
 * @create 2020-06-02 4:04 下午 
 */
object Spark20_RDD_Test2 {
    def main(args: Array[String]): Unit = {


        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File-RDD")
        val sc = new SparkContext(sparkConf)
        //从服务器日志数据apache.log中获取每个时间段访问量。
        val fileRDD: RDD[String] = sc.textFile("input/apache.log")

        val urlRDD: RDD[String] = fileRDD.map(
            line => {
                val datas: Array[String] = line.split(" ")
                val dates: Array[String] = datas(3).split(":")
                dates(1)
            }
        )

        val rdd: RDD[(String, Iterable[String])] = urlRDD.groupBy(data => data)
        println(rdd.map(kv => {
            (kv._1, kv._2.size)
        }).collect().mkString(","))

        sc.stop()
    }
}

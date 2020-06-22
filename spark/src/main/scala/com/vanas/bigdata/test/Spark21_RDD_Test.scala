package com.vanas.bigdata.test

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author Vanas
 * @create 2020-06-02 4:04 下午 
 */
object Spark21_RDD_Test {
    def main(args: Array[String]): Unit = {


        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File-RDD")
        val sc = new SparkContext(sparkConf)
        //从服务器日志数据apache.log中获取2015年5月17日的请求路径
        val fileRDD: RDD[String] = sc.textFile("input/apache.log")
        val dataRDD: RDD[(String, String)] = fileRDD.map(
            line => {
                val datas: Array[String] = line.split(" ")
                val date: Array[String] = datas(3).split(":")
                (date(0), datas(6))
            }
        )
        val rdd: RDD[(String, String)] = dataRDD.filter(
            kv => {
                kv._1.equals("17/05/2015")
            }
        )
        rdd.collect().foreach(println)
        sc.stop()
    }
}

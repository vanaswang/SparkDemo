package com.vanas.bigdata.spark.core.rdd.operator.transfer

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author Vanas
 * @create 2020-06-02 4:04 下午
 */
object Spark24_RDD_Test {
    def main(args: Array[String]): Unit = {

        //spark - RDD -算子（方法）

        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File-RDD")
        val sc = new SparkContext(sparkConf)

        val fileRDD: RDD[String] = sc.textFile("input/apache.log")
        val timeRDD: RDD[String] = fileRDD.map(
            log => {
                val datas: Array[String] = log.split(" ")
                datas(3)
            }
        )
        val hourRDD: RDD[(String, Iterable[String])] = timeRDD.groupBy(
            time => {
                time.substring(11, 13)
            }
        )
        val result: RDD[(String, Int)] = hourRDD.map(kv => ((kv._1, kv._2.size)))
        println(result.collect().mkString(","))

        sc.stop()

    }
}

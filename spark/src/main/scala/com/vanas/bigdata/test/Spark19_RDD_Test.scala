package com.vanas.bigdata.test

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author Vanas
 * @create 2020-06-02 4:04 下午 
 */
object Spark19_RDD_Test {
    def main(args: Array[String]): Unit = {

        //计算所有分区最大值求和（分区内取最大值，分区间最大值求和）


        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File-RDD")
        val sc = new SparkContext(sparkConf)
        //获取每个分区最大值以及分区号
        val dataRDD: RDD[Int] = sc.makeRDD(List(1, 2, 3, 4), 2)
        println(dataRDD.glom().map(_.max).sum())
        sc.stop()
    }
}

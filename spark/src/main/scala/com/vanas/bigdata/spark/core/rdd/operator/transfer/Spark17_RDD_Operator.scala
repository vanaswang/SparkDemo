package com.vanas.bigdata.spark.core.rdd.operator.transfer

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author Vanas
 * @create 2020-06-02 4:04 下午
 */
object Spark17_RDD_Operator {
    def main(args: Array[String]): Unit = {

        //spark - RDD -算子（方法）
        //mapPartitions


        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File-RDD")
        val sc = new SparkContext(sparkConf)
        //获取每个分区最大值以及分区号
        val datardd = sc.makeRDD(List(List(1, 2), List(3, 4)))

        //iter=>iter

        val rdd: RDD[Int] = datardd.flatMap(list => list)

        println(rdd.collect.mkString(","))

        sc.stop()
    }
}

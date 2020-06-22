package com.vanas.bigdata.spark.core.rdd.operator.transfer

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author Vanas
 * @create 2020-06-02 4:04 下午
 */
object Spark28_RDD_Operator {
    def main(args: Array[String]): Unit = {

        //spark - RDD -算子（方法）
        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File-RDD")
        val sc = new SparkContext(sparkConf)


        val rdd: RDD[Int] = sc.makeRDD(List(1, 2, 3, 1, 2, 4))
        val rdd1: RDD[Int] = rdd.distinct()
        //distinct可以改变分区的数量
        val rdd2: RDD[Int] = rdd.distinct(2)
        println(rdd1.collect().mkString(","))
        println(rdd2.collect().mkString(","))






        sc.stop()
    }
}

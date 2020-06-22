package com.vanas.bigdata.spark.core.rdd.operator.transfer

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author Vanas
 * @create 2020-06-02 4:04 下午
 */
object Spark15_RDD_Operator {
    def main(args: Array[String]): Unit = {

        //spark - RDD -算子（方法）
        //mapPartitions


        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File-RDD")
        val sc = new SparkContext(sparkConf)
        //获取每个分区最大值以及分区号
        val datardd: RDD[Int] = sc.makeRDD(List(1, 3, 6, 2, 5), 2)

        //iter=>iter
        val rdd: RDD[Int] = datardd.mapPartitionsWithIndex(
            (index, iter) => {
                List(index, iter.max).iterator
            }
        )

        println(rdd.collect.mkString(","))

        sc.stop()
    }
}

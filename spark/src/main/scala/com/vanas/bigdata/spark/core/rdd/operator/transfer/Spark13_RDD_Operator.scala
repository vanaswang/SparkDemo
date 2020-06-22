package com.vanas.bigdata.spark.core.rdd.operator.transfer

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.rdd.RDD

/**
 * @author Vanas
 * @create 2020-06-02 4:04 下午
 */
object Spark13_RDD_Operator {
    def main(args: Array[String]): Unit = {

        //spark - RDD -算子（方法）
        //mapPartitions
        //以分区单位进行计算，和map算子很像
        //区别就在于map算子是一个一个执行，而mapPartitions一个分区一个分区执行
        //类似于批处理

        //map方法是全量数据操作，不能丢失数据
        //mapPartitions 一次性获取分区的所有数据，那么可以执行迭代器集合的所有操作
        //              过滤，max，sum

        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File-RDD")
        val sc = new SparkContext(sparkConf)

        val datardd: RDD[Int] = sc.makeRDD(List(1, 2, 3, 4), 2)
        //3,4,1,2
        val rdd: RDD[Int] = datardd.mapPartitions(
            iter => {
                iter.map(_ * 2)
            }
        )
        println(rdd.collect.mkString(","))

        val rdd1: RDD[Int] = datardd.mapPartitions(
            iter => {
                iter.filter(_ % 2 == 0)
            }
        )
        println(rdd1.collect.mkString(","))

        sc.stop()
    }
}

package com.vanas.bigdata.spark.core.rdd.operator.transfer

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author Vanas
 * @create 2020-06-02 4:04 下午
 */
object Spark14_RDD_Test {
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

        val datardd: RDD[Int] = sc.makeRDD(List(1, 4, 3, 2, 5), 3)

        //获取每个数据分区的最大值
        //iter=>iter
        val rdd: RDD[Int] = datardd.mapPartitions(
            iter => {
                List(iter.max).iterator
            }
        )
        //4,6
        println(rdd.collect.mkString(","))

        sc.stop()
    }
}

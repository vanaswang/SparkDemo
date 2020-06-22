package com.vanas.bigdata.spark.core.rdd.operator.transfer

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author Vanas
 * @create 2020-06-02 4:04 下午
 */
object Spark29_RDD_Operator {
    def main(args: Array[String]): Unit = {

        //spark - RDD -算子（方法）
        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File-RDD")
        val sc = new SparkContext(sparkConf)


        val rdd: RDD[Int] = sc.makeRDD(List(1, 1, 1, 2, 2, 2), 6)
        //[1,1,1] [2,2,2]
        //[],[2,2,2]
        val filterRDD: RDD[Int] = rdd.filter(num => num % 2 == 0)
        //多=>少
        //当数据过滤后，发现数据不够均匀，那么可以缩减分区
        //val coalesceRDD: RDD[Int] = filterRDD.coalesce(1)
        //coalesceRDD.saveAsTextFile("output")
        //如果发现数据分区不合理，也可以缩减分区
        val coalesceRDD: RDD[Int] = rdd.coalesce(2)
        coalesceRDD.saveAsTextFile("output")

        sc.stop()
    }
}

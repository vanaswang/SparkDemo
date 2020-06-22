package com.vanas.bigdata.test

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}


/**
 * @author Vanas
 * @create 2020-06-02 4:04 下午
 */
object Spark28_RDD_Test {
    def main(args: Array[String]): Unit = {

        //spark - RDD -算子（方法）
        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File-RDD")
        val sc = new SparkContext(sparkConf)

        val rdd: RDD[Int] = sc.makeRDD(List(1, 2, 3, 1, 2, 4))

        //不用该算子，你有什么办法实现数据去重?
        val rdd1: RDD[(Int, Iterable[Int])] = rdd.groupBy(num => num)
        println(rdd1.map(_._1).collect().mkString(","))
        sc.stop()
    }
}

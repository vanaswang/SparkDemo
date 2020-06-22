package com.vanas.bigdata.spark.core.rdd.operator.transfer

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author Vanas
 * @create 2020-06-02 4:04 下午
 */
object Spark31_RDD_Operator {
    def main(args: Array[String]): Unit = {

        //spark - RDD -算子（方法）
        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File-RDD")
        val sc = new SparkContext(sparkConf)


        val rdd: RDD[Int] = sc.makeRDD(List(1, 1, 1, 2, 2, 2), 3)


        //缩减分区:coalesce
        rdd.coalesce(2)

        //扩大分区:repartition
        //从底层源码的角度，repartition其实就是coalesce，并且肯定进行shuffle操作
        rdd.repartition(6)


        sc.stop()
    }
}

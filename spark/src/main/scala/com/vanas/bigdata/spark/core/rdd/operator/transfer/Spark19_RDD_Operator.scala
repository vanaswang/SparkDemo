package com.vanas.bigdata.spark.core.rdd.operator.transfer

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author Vanas
 * @create 2020-06-02 4:04 下午
 */
object Spark19_RDD_Operator {
    def main(args: Array[String]): Unit = {

        //spark - RDD -算子（方法）
        //glom=>将每个分区的数据转换为数组


        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File-RDD")
        val sc = new SparkContext(sparkConf)
        //获取每个分区最大值以及分区号
        val dataRDD: RDD[Int] = sc.makeRDD(List(1, 2, 3, 4), 2)
        val rdd: RDD[Array[Int]] = dataRDD.glom()

        rdd.foreach(
            array => {
                println(array.mkString(","))
            }
        )

        sc.stop()
    }
}

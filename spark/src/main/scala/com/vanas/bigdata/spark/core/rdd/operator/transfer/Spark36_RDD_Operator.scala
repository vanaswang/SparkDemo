package com.vanas.bigdata.spark.core.rdd.operator.transfer

import org.apache.spark.rdd.RDD
import org.apache.spark.{HashPartitioner, SparkConf, SparkContext}

/**
 * @author Vanas
 * @create 2020-06-02 4:04 下午
 */
object Spark36_RDD_Operator {
    def main(args: Array[String]): Unit = {

        //spark - RDD -算子（方法）
        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File-RDD")
        val sc = new SparkContext(sparkConf)
        //自定义分区器-自己决定数据放置在哪个分区做处理
        //cba wnba nba
        val rdd: RDD[(String, String)] = sc.makeRDD(
            List(
                ("cba", "消息1"), ("cba", "消息2"), ("cba", "消息3"),
                ("nba", "消息4"), ("wnba", "消息5"), ("nba", "消息6")
            ), 1
        )


        //多次使用分区器 分区器一样，不进行处理，不会再重分区
        //
        val rdd1: RDD[(String, String)] = rdd.partitionBy(new HashPartitioner(3))
        val rdd2: RDD[(String, String)] = rdd1.partitionBy(new HashPartitioner(3))

        sc.stop()
    }

}

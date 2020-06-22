package com.vanas.bigdata.spark.core.rdd.operator.transfer

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author Vanas
 * @create 2020-06-02 4:04 下午
 */
object Spark37_RDD_Operator {
    def main(args: Array[String]): Unit = {

        //spark - RDD -算子（方法）
        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File-RDD")
        val sc = new SparkContext(sparkConf)
        //reduceByKey:根据数据的key进行分组，然后对value进行聚合
        val rdd: RDD[(String, Int)] = sc.makeRDD(
            List(
                ("hello", 1), ("scala", 1), ("hello", 1)
            )
        )
        //word=>(word,1)
        //reduceByKey第一个参数表示相同key的value的聚合方式
        //reduceByKey第二个参数表示聚合后的分区数量
        val rdd1: RDD[(String, Int)] = rdd.reduceByKey(_ + _, 2)
        println(rdd1.collect().mkString(","))

        sc.stop()
    }

}

package com.vanas.bigdata.spark.core.rdd.operator.transfer

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author Vanas
 * @create 2020-06-02 4:04 下午
 */
object Spark25_RDD_Test {
    def main(args: Array[String]): Unit = {

        //spark - RDD -算子（方法）
        //glom=>将每个分区的数据转换为数组

        //将List("Hello", "hive", "hbase", "Hadoop")根据单词首写字母进行分组。
        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File-RDD")
        val sc = new SparkContext(sparkConf)

        val dataRDD: RDD[String] = sc.makeRDD(List("hello scala", "hello"))
        dataRDD.flatMap(_.split(" ")).groupBy(word=>word).map(kv=>(kv._1,kv._2.size)).collect().mkString(",")

        sc.stop()
    }
}

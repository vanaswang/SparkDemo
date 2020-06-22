package com.vanas.bigdata.spark.core.rdd.operator.transfer

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author Vanas
 * @create 2020-06-02 4:04 下午
 */
object Spark23_RDD_Test {
    def main(args: Array[String]): Unit = {

        //spark - RDD -算子（方法）

        //将List("Hello", "hive", "hbase", "Hadoop")根据单词首写字母进行分组。
        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File-RDD")
        val sc = new SparkContext(sparkConf)

        val dataRDD = sc.makeRDD(List("Hello", "hive", "hbase", "Hadoop"))
        val result: RDD[(Char, Iterable[String])] = dataRDD.groupBy(word => {
            word.substring(0, 1)
            word.charAt(0)

            //String(0)=>StringOps 隐式转换
            word(0)
        })
        println(result.collect().mkString(","))

        sc.stop()


    }
}

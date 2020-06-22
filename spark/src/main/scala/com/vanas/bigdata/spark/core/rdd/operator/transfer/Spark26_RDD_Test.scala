package com.vanas.bigdata.spark.core.rdd.operator.transfer

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author Vanas
 * @create 2020-06-02 4:04 下午
 */
object Spark26_RDD_Test {
    def main(args: Array[String]): Unit = {

        //spark - RDD -算子（方法）
        //glom=>将每个分区的数据转换为数组

        //将List("Hello", "hive", "hbase", "Hadoop")根据单词首写字母进行分组。
        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File-RDD")
        val sc = new SparkContext(sparkConf)

        val fileRDD: RDD[String] = sc.textFile("input/apache.log")
        val timeRDD: RDD[String] = fileRDD.map(
            log => {
                val datas: Array[String] = log.split(" ")
                datas(3)
            }
        )

        val filterRDD: RDD[String] = timeRDD.filter(time => {
            val vmd = time.substring(0, 10)
            vmd == "17/05/2015"
        })
        filterRDD.collect().foreach(println)
        sc.stop()
    }
}

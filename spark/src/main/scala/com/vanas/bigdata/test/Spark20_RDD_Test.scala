package com.vanas.bigdata.test

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author Vanas
 * @create 2020-06-02 4:04 下午 
 */
object Spark20_RDD_Test {
    def main(args: Array[String]): Unit = {


        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File-RDD")
        val sc = new SparkContext(sparkConf)
        //将List("Hello", "hive", "hbase", "Hadoop")根据单词首写字母进行分组
        val dataRDD: RDD[String] = sc.makeRDD(List("Hello", "hive", "hbase", "Hadoop"))

        val rdd: RDD[(Char, Iterable[String])] = dataRDD.groupBy(_.charAt(0))
        //rdd.saveAsTextFile("output")
        rdd.collect().foreach {
            case (key, list) => {
                println("key：" + key + " list:" + list.mkString(","))
            }
        }
        sc.stop()
    }
}

package com.vanas.bigdata.spark.core.rdd.basic

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author Vanas
 * @create 2020-06-02 4:04 下午
 */
object Spark01_RDD_Memorry {
    def main(args: Array[String]): Unit = {

        val sparkConf = new SparkConf().setMaster("local").setAppName("wordcount")
        val sc = new SparkContext(sparkConf)
        // Spark -从内存中创建RDD
        //1.parallelize：并行
        val list = List(1, 2, 3, 4)
        val rdd: RDD[Int] = sc.parallelize(list)
        println(rdd.collect().mkString(","))

        //makeRDD的底层代码其实就是调用paralleliz
        val rdd1: RDD[Int] = sc.makeRDD(list)
        println(rdd1.collect().mkString(","))


        sc.stop()
    }

}

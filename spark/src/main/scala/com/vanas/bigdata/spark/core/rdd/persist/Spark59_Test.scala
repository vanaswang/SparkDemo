package com.vanas.bigdata.spark.core.rdd.persist

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author Vanas
 * @create 2020-06-08 10:40 上午 
 */
object Spark59_Test {

    def main(args: Array[String]): Unit = {
        val sparkConf = new SparkConf().setMaster("local").setAppName("wordcount")
        val sc = new SparkContext(sparkConf)
        sc.setCheckpointDir("cp")
        val rdd: RDD[Int] = sc.makeRDD(List(1, 2, 1, 2))
        val mapRDD: RDD[(Int, Int)] = rdd.map(
            num => {
                println("map...")
                (num, 1)
            })

        val reduceRDD: RDD[(Int, Int)] = mapRDD.reduceByKey(
            (x, y) => {
                println("reduce")
                x + y
            }
        )
        println(reduceRDD.collect().mkString(","))
        println("**********************")
        println(reduceRDD.collect().mkString(","))



        sc.stop()
    }

}

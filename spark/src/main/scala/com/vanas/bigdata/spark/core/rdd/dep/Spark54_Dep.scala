package com.vanas.bigdata.spark.core.rdd.dep

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author Vanas
 * @create 2020-06-06 3:44 下午 
 */
object Spark54_Dep {
    def main(args: Array[String]): Unit = {
        val sparkConf = new SparkConf().setMaster("local").setAppName("File-RDD")
        val sc = new SparkContext(sparkConf)

        //new ParallelCollectionRDD
        val rdd: RDD[String] = sc.makeRDD(List("hello scala", "hello spark"))
        println(rdd.toDebugString)
        println("---------------------------")

        //new MapPartitionsRDD ->new ParallelCollectionRDD
        val wordRDD: RDD[String] = rdd.flatMap(_.split(" "))
        println(wordRDD.toDebugString)
        println("---------------------------")

        //new MapPartitionsRDD ->new MapPartitionsRDD
        val mapRDD: RDD[(String, Int)] = wordRDD.map((_, 1))
        println(mapRDD.toDebugString)
        println("---------------------------")

        // new ShuffledRDD ->new MapPartitionsRDD
        //shuffle
        //如果Spark的计算的过程中某一个节点计算失败，那么框架会尝试重新计算
        //Spark既然想重新计算，那么需要知道数据的来源，并且还要知道数据经历了哪些计算
        //RDD不保存计算的数据，但是会保存元数据信息
        val result: RDD[(String, Int)] = mapRDD.reduceByKey(_ + _)
        println(result.toDebugString)

        println(result.collect().mkString(","))

        sc.stop()
    }

}

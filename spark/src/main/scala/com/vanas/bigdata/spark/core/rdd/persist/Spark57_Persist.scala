package com.vanas.bigdata.spark.core.rdd.persist

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author Vanas
 * @create 2020-06-08 10:40 上午 
 */
object Spark57_Persist {

    def main(args: Array[String]): Unit = {
        val sparkConf = new SparkConf().setMaster("local").setAppName("wordcount")
        val sc = new SparkContext(sparkConf)
        sc.setCheckpointDir("cp")
        val rdd: RDD[Int] = sc.makeRDD(List(1, 2, 3, 4))
        val mapRDD: RDD[(Int, Int)] = rdd.map(
            num => {
                println("map...")
                (num, 1)
            })

        //将比较耗时，比较重要的数据一般会保存到分布式文件系统中
        //val cacheRDD: mapRDD.type = mapRDD.persist(StorageLevel.DISK_ONLY_2)
        //println(cacheRDD.toDebugString)
        //println(cacheRDD.collect().mkString(","))
        //println(cacheRDD.toDebugString)

        //使用checkpoint方法将数据保存到文件中
        //SparkException: Checkpoint directory has not been set in the SparkContext
        //执行checkpoint方法前应该设定检查点的保存目录
        //检查点的操作中为了保证数据的准确性，执行时，会启动新的job
        //为了提高性能，检查点操作一般会和cache联合使用
        val cacheRDD: mapRDD.type = mapRDD.cache()
        cacheRDD.checkpoint()
        println(mapRDD.collect().mkString(","))
        println("*****************************")
        println(cacheRDD.collect().mkString("&"))
        println(cacheRDD.collect().mkString("*"))

        sc.stop()
    }

}

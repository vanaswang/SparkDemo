package com.vanas.bigdata.spark.core.rdd.persist

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author Vanas
 * @create 2020-06-08 10:40 上午 
 */
object Spark55_Persist {

    def main(args: Array[String]): Unit = {
        val sparkConf = new SparkConf().setMaster("local").setAppName("wordcount")
        val sc = new SparkContext(sparkConf)
        val rdd: RDD[Int] = sc.makeRDD(List(1, 2, 3, 4))
        val mapRDD: RDD[(Int, Int)] = rdd.map(
            num => {
                println("map...")
                (num, 1)
            })
        //将计算结果进行缓存，重复使用，提高效率
        //默认缓存是存储在Excutor端的内存中，数据量大的时候该如何处理？
        //缓存cache底层其实调用的persist方法
        //persist方法在持久化数据时会采用不同的存储级别对数据进行持久化操作
        //cache换粗的默认操作就是将数据将数据保存到内存
        //cache存储的数据在内存中，如果内存不够用，executor可以将内存的数据进行整理，然后可以丢弃数据
        //如果由于executor端整理内存导致缓存的数据丢失，那么数据操作依然要重头执行
        //如果cache后的数据重头执行数据操作的话，那么必须要尊序血缘关系所以chache操作不能删除血缘关系
        val cacheRDD: mapRDD.type = mapRDD.cache()
        println(cacheRDD.toDebugString)

        //collect
        println(cacheRDD.collect().mkString(","))
        println("***************************")
        //Save
        println(cacheRDD.collect().mkString("&"))
        //cacheRDD.saveAsTextFile("output")
        sc.stop()
    }

}

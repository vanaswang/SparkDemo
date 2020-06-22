package com.vanas.bigdata.spark.core.rdd.dep

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author Vanas
 * @create 2020-06-06 3:44 下午 
 */
object Spark55_Dep {
    def main(args: Array[String]): Unit = {
        val sparkConf = new SparkConf().setMaster("local").setAppName("File-RDD")
        val sc = new SparkContext(sparkConf)

        //OneToOneDependency
        //依赖关系中，现在的数据分区和依赖前的数据分区一一对应
        val rdd: RDD[String] = sc.makeRDD(List("hello scala", "hello spark"))
        println(rdd.dependencies)
        println("---------------------------")

        //OneToOneDependency
        val wordRDD: RDD[String] = rdd.flatMap(_.split(" "))
        println(wordRDD.dependencies)
        println("---------------------------")

        //OneToOneDependency
        val mapRDD: RDD[(String, Int)] = wordRDD.map((_, 1))
        println(mapRDD.dependencies)
        println("---------------------------")

        //ShuffleDependenc（N:N)
        val result: RDD[(String, Int)] = mapRDD.reduceByKey(_ + _)
        println(result.dependencies)

        println(result.collect().mkString(","))

        sc.stop()
    }

}

package com.vanas.bigdata.spark.core.rdd.operator.action

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author Vanas
 * @create 2020-06-06 11:34 上午 
 */
object Spark49_Operator_Action {
    def main(args: Array[String]): Unit = {
        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File-RDD")
        val sc = new SparkContext(sparkConf)
        //Spark 算子-行动算子
        val rdd: RDD[Int] = sc.makeRDD(List(2, 1, 3, 4), 2)

        //sum
        val d: Double = rdd.sum()
        println(d)

        //aggregate
        //aggragateByKey:初始值只参与到分区内计算
        //aggragate：初始值分区内计算会参与，同时分区间计算也会参与
        val i: Int = rdd.aggregate(10)(_ + _, _ + _)
        println(i) //40

        //fold
        val i1: Int = rdd.fold(10)(_ + _)
        println(i1)

        //countByKey
        val rdd1: RDD[(String, Int)] = sc.makeRDD(List(
            ("a", 1), ("a", 1), ("a", 1)
        ))
        val stringToLong: collection.Map[String, Long] = rdd1.countByKey()
        println(stringToLong)

        //
        val rdd2: RDD[String] = sc.makeRDD(List("a", "a", "a", "hello", "hello"))
        val wordToCount: collection.Map[String, Long] = rdd2.countByValue()
        println(wordToCount)

        sc.stop()
    }

}

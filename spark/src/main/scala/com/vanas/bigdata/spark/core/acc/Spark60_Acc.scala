package com.vanas.bigdata.spark.core.acc

import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author Vanas
 * @create 2020-06-08 11:52 上午 
 */
object Spark60_Acc {
    def main(args: Array[String]): Unit = {
        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("wordcount")
        val sc = new SparkContext(sparkConf)
        val rdd = sc.makeRDD(List(
            ("a", 1), ("a", 2), ("a", 3)
        ))
        //val sum: Int = rdd.reduce(_ + _)
        //println("sum = " + sum)

        var sum = 0
        rdd.foreach {
            case (word, count) => {
                sum = sum + count
                println(sum)
            }
        }
        println("(a," + sum + ")")
        sc.stop()
    }

}

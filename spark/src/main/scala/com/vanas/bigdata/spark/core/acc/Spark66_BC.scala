package com.vanas.bigdata.spark.core.acc

import org.apache.spark.broadcast.Broadcast
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author Vanas
 * @create 2020-06-08 11:52 上午 
 */
object Spark66_BC {
    def main(args: Array[String]): Unit = {
        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("wordcount")
        val sc = new SparkContext(sparkConf)
        //Spark 广播变量
        //广播变量：分布式共享只读变量

        val rdd1 = sc.makeRDD(List(("a", 1), ("b", 2), ("c", 3)))
        val list = List(("a", 4), ("b", 5), ("c", 6))
        //声明广播变量
        val bcList: Broadcast[List[(String, Int)]] = sc.broadcast(list)

        val rdd2 = rdd1.map {
            case (word, count1) => {
                var count2 = 0
                //使用广播变量
                for (kv <- bcList.value) {
                    val w = kv._1
                    val v = kv._2
                    if (w == word) {
                        count2 = v
                    }
                }
                (word, (count1, count2))
            }
        }
        println(rdd2.collect().mkString(","))
        sc.stop()
    }

}

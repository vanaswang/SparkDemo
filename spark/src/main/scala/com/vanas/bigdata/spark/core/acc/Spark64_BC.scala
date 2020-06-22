package com.vanas.bigdata.spark.core.acc

import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author Vanas
 * @create 2020-06-08 11:52 上午 
 */
object Spark64_BC {
    def main(args: Array[String]): Unit = {
        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("wordcount")
        val sc = new SparkContext(sparkConf)
        //Spark 广播变量
        //join会有笛卡尔乘积效果，数据量会急剧增多，如果有shuffle，那么性能会非常低
        val rdd1 = sc.makeRDD(List(("a", 1), ("b", 2), ("c", 3)))
        //val rdd2 = sc.makeRDD(List(("a", 1), ("b", 2), ("c", 3)))
        val list = List(("a", 4), ("b", 5), ("c", 6))
        //(a,(1,1)),(b,(2,2)),(c,(3,3))
        //


        //val joinRDD: RDD[(String, (Int, Int))] = rdd1.join(rdd2)
        //println(joinRDD.collect().mkString(","))


        val rdd2 = rdd1.map {
            case (word, count1) => {
                var count2 = 0
                for (kv <- list) {
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

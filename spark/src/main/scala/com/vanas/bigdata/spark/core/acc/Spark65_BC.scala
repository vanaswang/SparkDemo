package com.vanas.bigdata.spark.core.acc

import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author Vanas
 * @create 2020-06-08 11:52 上午 
 */
object Spark65_BC {
    def main(args: Array[String]): Unit = {
        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("wordcount")
        val sc = new SparkContext(sparkConf)
        //Spark 广播变量
        //join会有笛卡尔乘积效果，数据量会急剧增多，如果有shuffle，那么性能会非常低

        //为了解决join出现的性能问题，可以将数据独立出来，防止shuffle操作
        //这样的话，会导致数据每个task会复制一份，那么executor内存中会有大量冗余，性能会下降
        //所以可以采用广播变量，将数据保存到executor的内存中
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

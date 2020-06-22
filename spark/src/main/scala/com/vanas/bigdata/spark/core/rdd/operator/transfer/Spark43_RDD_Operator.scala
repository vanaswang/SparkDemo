package com.vanas.bigdata.spark.core.rdd.operator.transfer

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author Vanas
 * @create 2020-06-02 4:04 下午
 */
object Spark43_RDD_Operator {
    def main(args: Array[String]): Unit = {

        //spark - RDD -算子（方法）
        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File-RDD")
        val sc = new SparkContext(sparkConf)

        val rdd1: RDD[(String, Int)] = sc.makeRDD(
            List(("a", 1), ("b", 2), ("a", 6))
        )
        val rdd2: RDD[(String, Int)] = sc.makeRDD(
            List(("b", 6), ("a", 4), ("c", 5),("a",3))
        )
        //join方法可以将两个rdd中相同的key的value连接在一起
        val result: RDD[(String, (Int, Int))] = rdd1.join(rdd2)
        //也会有点笛卡尔乘积的意思 会与下面每个都匹配，存在shuffle，性能不高 ，能不用尽量不用
        println(result.collect().mkString(","))  //(a,(1,4)),(a,(1,3)),(a,(6,4)),(a,(6,3)),(b,(2,6))

        sc.stop()
    }

}

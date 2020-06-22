package com.vanas.bigdata.spark.core.rdd.operator.action

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author Vanas
 * @create 2020-06-06 11:34 上午 
 */
object Spark47_Operator_Action {
    def main(args: Array[String]): Unit = {
        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File-RDD")
        val sc = new SparkContext(sparkConf)
        //Spark 算子-行动算子
        val rdd: RDD[Int] = sc.makeRDD(List(1, 2, 3, 4))
        //reduce
        //简化，规约
        val i: Int = rdd.reduce(_ + _)
        println(i)

        //collect
        //采集数据
        //collect方法会将所有分区计算的结果拉取到当前节点Driver的内存中，可能会出现内存溢出
        val array: Array[Int] = rdd.collect()
        println(array.mkString(","))

        //count
        val cnt: Long = rdd.count()
        println(cnt)

        //first
        val f: Int = rdd.first()

        //take
        val subarray: Array[Int] = rdd.take(3)

        sc.stop()
    }

}

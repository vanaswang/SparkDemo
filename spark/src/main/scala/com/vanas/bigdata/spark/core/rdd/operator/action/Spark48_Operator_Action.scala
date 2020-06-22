package com.vanas.bigdata.spark.core.rdd.operator.action

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author Vanas
 * @create 2020-06-06 11:34 上午 
 */
object Spark48_Operator_Action {
    def main(args: Array[String]): Unit = {
        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File-RDD")
        val sc = new SparkContext(sparkConf)
        //Spark 算子-行动算子
        val rdd: RDD[Int] = sc.makeRDD(List(2, 1, 3, 4))

        //1,2,3,4=>1,2,3
        //2,1,4=>1,2,4
        val ints: Array[Int] = rdd.takeOrdered(3)
        println(ints.mkString(","))

        sc.stop()
    }

}

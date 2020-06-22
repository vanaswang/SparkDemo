package com.vanas.bigdata.spark.core.rdd.operator.transfer

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author Vanas
 * @create 2020-06-02 4:04 下午
 */
object Spark46_RDD_Operator_Test {
    def main(args: Array[String]): Unit = {

        //spark - RDD -算子（方法）
        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File-RDD")
        val sc = new SparkContext(sparkConf)

        val rdd: RDD[Int] = sc.makeRDD(List(1, 1, 2, 2), 2)
        rdd.mapPartitions(
            iter => {
                //迭代器
                //List((iter.next(),iter.length)).iterator
                iter
            }
        )

        val iter: Iterator[Int] = List(1, 2, 3, 4).iterator
        val len: Int = iter.length

        while (iter.hasNext) {
            println(iter.next())
        }
        sc.stop()
    }

}

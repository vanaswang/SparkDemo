package com.vanas.bigdata.spark.core.acc

import org.apache.spark.util.LongAccumulator
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author Vanas
 * @create 2020-06-08 11:52 上午 
 */
object Spark61_Acc {
    def main(args: Array[String]): Unit = {
        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("wordcount")
        val sc = new SparkContext(sparkConf)
        //使用累加器完成数据的累加
        val rdd = sc.makeRDD(List(1, 2, 3, 4))

        //声明累加器变量
        val sum: LongAccumulator = sc.longAccumulator("sum")
        rdd.foreach(
            num => {
                //使用累加器
                sum.add(num)
            }
        )
        //获取累加器的结果
        println("结果为=" + sum.value)
        sc.stop()
    }

}

package com.vanas.bigdata.spark.core.rdd.operator.transfer

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author Vanas
 * @create 2020-06-02 4:04 下午
 */
object Spark38_RDD_Operator {
    def main(args: Array[String]): Unit = {

        //spark - RDD -算子（方法）
        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File-RDD")
        val sc = new SparkContext(sparkConf)

        val rdd: RDD[(String, Int)] = sc.makeRDD(
            List(
                ("hello", 1), ("scala", 1), ("hello", 1)
            )
        )
        //groupByKey:根据数据的key进行分组
        //groupBy: 根据指定的规则对数据进行分组

        //调用groupByKey后，返回数组的类型为元组
        //元组的第一个元素表示的是用于分组的key
        //元组的第二个元素表示的是分组后，相同key的value的集合
        val groupRDD: RDD[(String, Iterable[Int])] = rdd.groupByKey()
        val wordToCount: RDD[(String, Int)] = groupRDD.map {
            case (word, iter) => {
                (word, iter.sum)
            }
        }
        println(wordToCount.collect().mkString(","))
        sc.stop()
    }

}

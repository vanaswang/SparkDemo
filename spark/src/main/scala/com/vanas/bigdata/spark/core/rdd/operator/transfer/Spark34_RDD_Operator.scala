package com.vanas.bigdata.spark.core.rdd.operator.transfer

import org.apache.spark.rdd.RDD
import org.apache.spark.{HashPartitioner, SparkConf, SparkContext}

/**
 * @author Vanas
 * @create 2020-06-02 4:04 下午
 */
object Spark34_RDD_Operator {
    def main(args: Array[String]): Unit = {

        //spark - RDD -算子（方法）
        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File-RDD")
        val sc = new SparkContext(sparkConf)
        //k-v 类型的数据操作
        //单值会报错 所以得是k-v
        val rdd: RDD[(String, Int)] = sc.makeRDD(List(("a", 1), ("b", 2), ("c", 3)))
        //Spqrk中很多的方法是基于Key进行操作的，所以数据格式为键值对（对偶元组）
        //如果数据类型为k-v类型，那么Spark会给RDD自动补充很多新的功能（扩展）
        //隐式转换(A=>B)
        //partitionBy方法来自于PairRDDFUnction类
        //RDD的伴生对象中提供了隐式函数，可以将RDD[k,v]转换为PairRDDFunctions类

        //partitionBy根据指定的规则对数据进行分区
        //groupBy=>coalesce
        //repartition=>shuffle
        //partitionBy参数为分区器对象
        //分区器对象：RangePartitioner &s HashPartitioner
        //HashPartitioner分区规则是将当前数据的key进行取余操作
        //HashPartitioner是spark默认的分区器
        val rdd1: RDD[(String, Int)] = rdd.partitionBy(new HashPartitioner(2))
        rdd1.saveAsTextFile("output")

        //sortBy 使用了RangePartitionner 用的不多 要求数据的key必须能排序

        sc.stop()
    }
}

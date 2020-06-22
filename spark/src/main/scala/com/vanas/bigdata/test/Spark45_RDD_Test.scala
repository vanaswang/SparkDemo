package com.vanas.bigdata.test

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author Vanas
 * @create 2020-06-02 4:04 下午
 */
object Spark45_RDD_Test {
    def main(args: Array[String]): Unit = {

        //spark - RDD -算子（方法）
        val sparkConf: SparkConf = new SparkConf().setMaster("local").setAppName("File-RDD")
        val sc = new SparkContext(sparkConf)

        //统计出每一个省份每个广告被点击数量排行的Top3
        //1.获取原始数据
        val fileRDD: RDD[String] = sc.textFile("input/agent.log")
        //2.将原始数据进行结构的转换，方便统计
        //((省份-广告）,1)
        val datasRDD: RDD[(String, Int)] = fileRDD.map(
            line => {
                val datas: Array[String] = line.split(" ")
                (datas(1) + "-" + datas(4), 1)
            }
        )
        //3.将相同key的数据进行分组聚合
        //(（省份-广告）,sum)
        val mapRDD: RDD[(String, Int)] = datasRDD.reduceByKey(_ + _)
        //4.将聚合后的结果进行结构的转换
        //(省份，（广告，sum）)
        val mapRDD1: RDD[(String, (String, Int))] = mapRDD.map(
            kv => {
                val keys: Array[String] = kv._1.split("-")
                (keys(0), (keys(1), kv._2))
            }
        )

        //5.将相同的省份的数据分在一个组中
        //（省份,Iterator[（广告1，sum1），（广告2，sum2）]）
        val groupRDD: RDD[(String, Iterable[(String, Int)])] = mapRDD1.groupByKey()

        //6.将分组后的数据进行排序(降序)，取前3 Top3
        //scala mapvalues
        val result: RDD[(String, List[(String, Int)])] = groupRDD.mapValues(
            iter => {
                iter.toList.sortWith(
                    (left, right) => {
                        left._2 > right._2
                    }
                ).take(3)
            }
        )

        //7.将数据采集到控制台打印
        result.collect().foreach(println)
        sc.stop()
    }
}

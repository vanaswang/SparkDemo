package com.vanas.bigdata.spark.core.acc

import org.apache.spark.rdd.RDD
import org.apache.spark.util.AccumulatorV2
import org.apache.spark.{SparkConf, SparkContext}

import scala.collection.mutable

/**
 * @author Vanas
 * @create 2020-06-08 11:52 上午 
 */
object Spark63_Acc {
    def main(args: Array[String]): Unit = {
        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("wordcount")
        val sc = new SparkContext(sparkConf)
        //累加器：wordcount

        val rdd: RDD[String] = sc.makeRDD(List("hello scala", "hello", "spark", "scala"))
        //1.创建累加器
        val acc = new MyWordCountAccumulator
        //2。注册累加器
        sc.register(acc)

        //3.使用累加器
        rdd.flatMap(_.split(" ")).foreach(
            word => {
                acc.add(word)
            }
        )
        //4.获取累加器的值
        println(acc.value)
        sc.stop()
    }

    //自定义累加器
    //1.继承AccumulatorV2,定义泛型[IN,OUT]
    //      IN:累加器输入的值的类型
    //      OUT:累加器返回结果的类型
    //2.重写方法（6）
    //3.copyAndReset must return a zero value copy
    class MyWordCountAccumulator extends AccumulatorV2[String, mutable.Map[String, Int]] {
        //存储wordcount的集合
        var wordCountMap = mutable.Map[String, Int]()

        //累加器是否初始化
        override def isZero: Boolean = {
            wordCountMap.isEmpty
        }

        //复制累加器
        override def copy(): AccumulatorV2[String, mutable.Map[String, Int]] = {
            new MyWordCountAccumulator
        }

        //重制累加器
        override def reset(): Unit = {
            wordCountMap.clear()
        }

        //向累加器中增加值  ???值得是未知
        override def add(word: String): Unit = {
            //word =>wordcount
            //wordCountMap(word) = wordCountMap.getOrElse(word, 0) + 1
            wordCountMap.update(word, wordCountMap.getOrElse(word, 0) + 1)

        }

        //合并当前累加器和其他累加器
        //合并累加器
        override def merge(other: AccumulatorV2[String, mutable.Map[String, Int]]): Unit = {
            val map1 = wordCountMap
            val map2 = other.value
            wordCountMap = map1.foldLeft(map2)(
                (map, kv) => {
                    map(kv._1) = map.getOrElse(kv._1, 0) + kv._2
                    map
                }
            )
        }

        //返回累加器的值（Out）
        override def value: mutable.Map[String, Int] = {
            wordCountMap
        }
    }

}

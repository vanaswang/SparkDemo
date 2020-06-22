package com.vanas.bigdata.spark.core.wordcount

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author Vanas
 * @create 2020-06-01 4:05 下午
 */
object Spark02_WordCount {
    def main(args: Array[String]): Unit = {
        //Spark _WordCount
        //Spark是一个计算框架
        //开发人员是使用Spark框架的API实现计算功能

        //1.准备Spark环境
        //setMaster:设定spqrk环境的位置
        val sparkConf = new SparkConf().setMaster("local").setAppName("wordcount")

        //2.应该建立和Spark的连接
        //jdbc:connection
        val sc = new SparkContext(sparkConf)

        //3.实现业务操作
        //3.1读取指定目录下的数据文件（多个）
        //参数path可以指向单一的文件也可以指向文件目录
        //RDD：更适合并行计算的数据模型
        val fileRDD: RDD[String] = sc.textFile("input")

        //3.2将读取的内容进行扁平化操作，切分单词
        val word: RDD[String] = fileRDD.flatMap(_.split(" "))

        //3.3将分词后的数据进行结构的转换
        //word=>（word,1）
        val mapRDD: RDD[(String, Int)] = word.map(word => (word, 1))

        //3.4将转换结构后的数据 根据单词进行分组聚合
        //reduceByKey方法的作用表示根据数据key进行分组，然后对value进行统计聚合
        val wordToSumRdd: RDD[(String, Int)] = mapRDD.reduceByKey(_+_)

        //3.5将聚合的结果采集后打印到控制台上
        val wordCountArray: Array[(String, Int)] = wordToSumRdd.collect()
        println(wordCountArray.mkString(","))

        //4.释放连接
        sc.stop()
    }
}

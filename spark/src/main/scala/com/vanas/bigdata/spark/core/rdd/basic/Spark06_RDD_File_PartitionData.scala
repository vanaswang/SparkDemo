package com.vanas.bigdata.spark.core.rdd.basic

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author Vanas
 * @create 2020-06-02 4:04 下午
 */
object Spark06_RDD_File_PartitionData {
    def main(args: Array[String]): Unit = {

        //math.min
        //math.max

        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("wordcount")
        val sc = new SparkContext(sparkConf)

        // Spark-从磁盘（File）中创建RDD

        //1.Spark读取文件采用的是Hadoop的读取规则
        //  文件切片规则：以字节方式来切片
        //  数据读取规则：以行为单位来读取

        //2.问题
        //文件到底切成几片（分区的数量）？
        //文件字节数（10），预计切片数量（2）
        //10/2 => 5byte
        //totalSize =11
        //goalSize = totalSiz /numSplits =11/2 =5...1 =>3
        //所谓的最小分区数 ，取决于总的字节数是否能整除分区数并且剩余的字节达到一个比率
        //实际产生的分区数量可能大于最小分区数

        //分区的数据如何存储的？
        //分区数据是以行为单位读取的，而不是字节

        //12,34
        val fileRDD1: RDD[String] = sc.textFile("input/w.txt",2)
        fileRDD1.saveAsTextFile("output")

        sc.stop()

    }
}

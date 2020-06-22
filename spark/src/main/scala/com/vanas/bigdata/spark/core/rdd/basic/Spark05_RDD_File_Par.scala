package com.vanas.bigdata.spark.core.rdd.basic

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author Vanas
 * @create 2020-06-02 4:04 下午
 */
object Spark05_RDD_File_Par {
    def main(args: Array[String]): Unit = {

        //math.min
        //math.max

        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("wordcount")
        val sc = new SparkContext(sparkConf)

        // Spark-从磁盘（File）中创建RDD
        //textFile 第一个参数表示读取文件的路径
        //textFile 第二个参数表示最小分区数
        //         默认值为：math.min(defaultParallelism, 2)
        //                  math.min(totalCores, 2)

        //12,34
        val fileRDD1: RDD[String] = sc.textFile("input/w.txt")
        fileRDD1.saveAsTextFile("output")

        val fileRDD2: RDD[String] = sc.textFile("input/w.txt",1)
        fileRDD2.saveAsTextFile("output")

        val fileRDD3: RDD[String] = sc.textFile("input/w.txt",4)
        fileRDD3.saveAsTextFile("output")

        val fileRDD4: RDD[String] = sc.textFile("input/w.txt",3)
        fileRDD4.saveAsTextFile("output")
        sc.stop()

    }
}

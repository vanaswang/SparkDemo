package com.vanas.bigdata.spark.core.rdd.basic

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author Vanas
 * @create 2020-06-02 4:04 下午
 */
object Spark08_RDD_File_PartitionData {
    def main(args: Array[String]): Unit = {

        //math.min
        //math.max

        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("wordcount")
        val sc = new SparkContext(sparkConf)

        // （0，0+2）
        //totalsize =6,num =2
        //6/2 = 3 byte
        //(0,0+3)=>(0,3)
        //(3,3+3)=>(3,6)

        //1@@=>123
        //234=>345

        //hadoop分区是以文件为单位进行划分的
        //读取数据不能跨越文件
        //12/2 =>6
        //12/3 =>4
        //1.txt =>(0,4)
        //      =>(4,6)
        //2.txt =>(0,4)
        //      =>(4,6)
        val fileRDD1: RDD[String] = sc.textFile("input/w.txt",3)
        fileRDD1.saveAsTextFile("output")

        sc.stop()

    }
}

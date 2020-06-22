package com.vanas.bigdata.spark.sql

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession


/**
 * @author Vanas
 * @create 2020-06-10 4:32 下午 
 */
object SparkSql12_Load_Hive {
    def main(args: Array[String]): Unit = {
        //创建环境对象
        val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("sparkSQL")

        //builder构建，创建
        //访问外置的hive
        val spark = SparkSession.builder().enableHiveSupport().config(sparkConf).getOrCreate()

        //可以使用基本的sql访问hive中的内容
        spark.sql("show databases").show()
        spark.stop()
    }
}

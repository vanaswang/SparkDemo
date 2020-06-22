package com.vanas.bigdata.spark.sql

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession


/**
 * @author Vanas
 * @create 2020-06-10 4:32 下午 
 */
object SparkSql07_LoadSave {
    def main(args: Array[String]): Unit = {
        //创建环境对象
        val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("sparkSQL")
        //builder构建，创建
        val spark = SparkSession.builder().config(sparkConf).getOrCreate()

        spark.sql("select * from json.`input/user.json`").show()
        spark.stop()
    }
}

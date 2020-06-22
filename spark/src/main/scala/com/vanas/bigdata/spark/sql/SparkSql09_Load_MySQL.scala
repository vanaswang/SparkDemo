package com.vanas.bigdata.spark.sql

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession


/**
 * @author Vanas
 * @create 2020-06-10 4:32 下午 
 */
object SparkSql09_Load_MySQL {
    def main(args: Array[String]): Unit = {
        //创建环境对象
        val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("sparkSQL")

        //builder构建，创建
        val spark = SparkSession.builder().config(sparkConf).getOrCreate()

        spark.read.format("jdbc")
                .option("url", "jdbc:mysql://hadoop130:3306/spark-sql")
                .option("driver", "com.mysql.jdbc.Driver")
                .option("user", "root")
                .option("password", "123456")
                .option("dbtable", "user")
                .load().show

        spark.stop()
    }
}

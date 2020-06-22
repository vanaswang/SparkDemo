package com.vanas.bigdata.spark.sql

import org.apache.spark.SparkConf
import org.apache.spark.sql.{DataFrame, SaveMode, SparkSession}


/**
 * @author Vanas
 * @create 2020-06-10 4:32 下午 
 */
object SparkSql10_Save_MySQL {
    def main(args: Array[String]): Unit = {
        //创建环境对象
        val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("sparkSQL")

        //builder构建，创建
        val spark = SparkSession.builder().config(sparkConf).getOrCreate()

        val frame: DataFrame = spark.read.format("jdbc")
                .option("url", "jdbc:mysql://hadoop130:3306/spark-sql")
                .option("driver", "com.mysql.jdbc.Driver")
                .option("user", "root")
                .option("password", "123456")
                .option("dbtable", "user")
                .load()
        frame.write.format("jdbc")
                .option("url", "jdbc:mysql://hadoop130:3306/spark-sql")
                .option("driver", "com.mysql.jdbc.Driver")
                .option("user", "root")
                .option("password", "123456")
                .option("dbtable", "user1")
                .mode(SaveMode.Append)
                .save()
        spark.stop()
    }
}

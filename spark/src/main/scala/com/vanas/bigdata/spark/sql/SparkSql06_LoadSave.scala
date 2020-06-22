package com.vanas.bigdata.spark.sql

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession


/**
 * @author Vanas
 * @create 2020-06-10 4:32 下午 
 */
object SparkSql06_LoadSave {
    def main(args: Array[String]): Unit = {
        //创建环境对象
        val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("sparkSQL")

        //builder构建，创建
        val spark = SparkSession.builder().config(sparkConf).getOrCreate()

        //sparkSQL通用的读取和保存

        //通用的保存
        val df = spark.read.format("json").load("input/user.json")
        //sparksql默认通用保存的文件格式为parquet
        //如果想要保存的格式是指定的格式，比如json，那么需要进行对应的格式化操作
        //如果路径已经存在，那么执行保存操作会发生错误
        df.write.format("json").save("output1")
        //如果非得想要路径已经存在的情况下，保存数据，那么可以使用保存模式
        //df.write.mode("overwrite").format("json").save("output")
        df.write.mode("append").format("json").save("output")

        spark.stop()
    }
}

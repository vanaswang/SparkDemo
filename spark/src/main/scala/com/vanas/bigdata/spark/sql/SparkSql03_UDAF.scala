package com.vanas.bigdata.spark.sql

import org.apache.spark.SparkConf
import org.apache.spark.sql.expressions.{MutableAggregationBuffer, UserDefinedAggregateFunction}
import org.apache.spark.sql.types.{DataType, LongType, StructField, StructType}
import org.apache.spark.sql.{Row, SparkSession}


/**
 * @author Vanas
 * @create 2020-06-10 4:32 下午 
 */
object SparkSql03_UDAF {
    def main(args: Array[String]): Unit = {
        //创建环境对象
        val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("sparkSQL")

        //builder构建，创建
        val spark = SparkSession.builder().config(sparkConf).getOrCreate()
        import spark.implicits._ //最好用不用上都加上

        val rdd = spark.sparkContext.makeRDD(List(
            (1, "zhangsan", 30L),
            (2, "lisi", 20L),
            (3, "wangwu", 40L),
        ))

        val df = rdd.toDF("id", "name", "age")
        df.createOrReplaceTempView("user")

        //创建UDAF函数
        val udaf = new MyAvgAgeUDAF
        //注册导SparkSQL中
        spark.udf.register("avgAge",udaf)
        //在SQL中使用聚合函数

        //定义用户的自定义函数
        spark.sql("select avgAge(age) from user").show

        spark.stop()
    }

    //自定义聚合函数
    //1.继承UserDefinedAggregateFunction
    //2.重写方法

    //totalage，count
    class MyAvgAgeUDAF extends UserDefinedAggregateFunction {
        //输入数据的结构信息:年龄信息
        override def inputSchema: StructType = {
            StructType(Array(StructField("age", LongType)))
        }

        //缓冲区的数据结构信息：年龄的总和，人的数量
        override def bufferSchema: StructType = {
            StructType(Array(
                StructField("totalage", LongType),
                StructField("count", LongType)
            ))

        }
        //聚合函数返回的结果类型
        override def dataType: DataType = LongType

        //函数稳定性
        override def deterministic: Boolean = true

        //函数缓冲区初始化
        override def initialize(buffer: MutableAggregationBuffer): Unit = {
            buffer(0) = 0L
            buffer(1) = 0L
        }

        //更新缓冲区数据，
        override def update(buffer: MutableAggregationBuffer, input: Row): Unit = {
            buffer(0) = buffer.getLong(0) + input.getLong(0)
            buffer(1) = buffer.getLong(1) + 1
        }

        //合并缓冲区
        override def merge(buffer1: MutableAggregationBuffer, buffer2: Row): Unit = {
            buffer1(0) = buffer1.getLong(0) + buffer2.getLong(0)
            buffer1(1) = buffer1.getLong(1) + buffer2.getLong(1)
        }

        //函数的计算
        override def evaluate(buffer: Row): Any = {
            buffer.getLong(0) / buffer.getLong(1)
        }
    }


}

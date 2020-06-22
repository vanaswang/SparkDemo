package com.vanas.bigdata.spark.sql

import org.apache.spark.SparkConf
import org.apache.spark.sql.expressions.Aggregator
import org.apache.spark.sql.{Dataset, Encoder, Encoders, SparkSession}


/**
 * @author Vanas
 * @create 2020-06-10 4:32 下午 
 */
object SparkSql04_UDAF_Class {
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
        val ds: Dataset[User] = df.as[User]
        //创建UDAF函数
        val udaf = new MyAvgAgeUDAFClass
        //在SQL中使用聚合函数

        //因为聚合函数是强类型，那么sql中没有类型的概念，所以无法使用
        //可以采用DSL语法进行访问
        //将聚合函数转换为查询的列让DataSet访问
        ds.select(udaf.toColumn).show
        spark.stop()
    }

    case class User(id: Int, name: String, age: Long)

    case class AvgBuffer(var totalage: Long, var count: Long)

    //自定义聚合函数 - 强类型
    //1.继承Aggregator,敌营泛型
    //IN：输入数据的类型User
    // BUF：缓冲区的数据类型 AvgBuffer
    //OUT：输出的数据类型Long
    //2.重写方法

    class MyAvgAgeUDAFClass extends Aggregator[User, AvgBuffer, Long] {
        //缓冲区的初始值
        override def zero: AvgBuffer = {
            AvgBuffer(0L, 0L)
        }

        //聚合数据
        override def reduce(buffer: AvgBuffer, user: User): AvgBuffer = {
            buffer.totalage = buffer.totalage + user.age
            buffer.count = buffer.count + 1
            buffer
        }

        //合并缓冲区
        override def merge(buffer1: AvgBuffer, buffer2: AvgBuffer): AvgBuffer = {
            buffer1.totalage = buffer1.totalage + buffer2.totalage
            buffer1.count = buffer1.count + buffer2.count
            buffer1
        }

        //计算函数结果
        override def finish(reduction: AvgBuffer): Long = {
            reduction.totalage / reduction.count
        }

        override def bufferEncoder: Encoder[AvgBuffer] = Encoders.product

        override def outputEncoder: Encoder[Long] = Encoders.scalaLong
    }


}

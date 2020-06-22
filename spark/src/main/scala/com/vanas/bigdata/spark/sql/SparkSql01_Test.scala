package com.vanas.bigdata.spark.sql

import org.apache.spark.SparkConf
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{DataFrame, Dataset, Row, SparkSession}


/**
 * @author Vanas
 * @create 2020-06-10 4:32 下午 
 */
object SparkSql01_Test {
    def main(args: Array[String]): Unit = {
        //创建环境对象
        val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("sparkSQL")

        //builder构建，创建
        val spark = SparkSession.builder().config(sparkConf).getOrCreate()
        //导入隐式转换,这里的spark其实是环境对象的名称
        //要求这个对象使用val声明
        import spark.implicits._ //最好用不用上都加上

        //逻辑操作
        val jsonDF: DataFrame = spark.read.json("input/user.json")

        //SQL
        //将df转换为临时视图
        jsonDF.createOrReplaceTempView("user")
        spark.sql("select * from user").show()

        //DSL
        //如果查询列名采用单引号，那么需要隐式转换
        jsonDF.select("name", "age").show
        jsonDF.select($"name", $"age").show
        jsonDF.select('name, 'age).show

        val rdd = spark.sparkContext.makeRDD(List(
            (1, "zhangsan", 30),
            (2, "lisi", 20),
            (3, "wangwu", 40),
        ))
        //RDD<=>DataFrame
        val df: DataFrame = rdd.toDF("id", "name", "age")
        val dfToRDD1: RDD[Row] = df.rdd
        dfToRDD1.foreach(
            row=>{
                println(row(0))
            })

        //RDD<=>DataSet
        val userRDD: RDD[User] = rdd.map {
            case (id, name, age) => {
                User(id, name, age)
            }
        }
        val userDS: Dataset[User] = userRDD.toDS()
        val dsToRDD: RDD[User] = userDS.rdd


        //DataFram <=>DataSet
        val dsToDS: Dataset[User] = df.as[User]
        //type DataFrame = Dataset[Row] Dataset就是特殊类型的DataFrame
        val dsToDF: DataFrame = dsToDS.toDF()

        rdd.foreach(println)
        df.show()
        userDS.show()

        //释放对象
        spark.stop()
    }

    case class User(id: Int, name: String, age: Int)

}

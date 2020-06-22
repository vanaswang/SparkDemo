package com.vanas.bigdata.spark.sql

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession


/**
 * @author Vanas
 * @create 2020-06-10 4:32 下午 
 */
object SparkSql02_Test {
    def main(args: Array[String]): Unit = {
        //创建环境对象
        val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("sparkSQL")

        //builder构建，创建
        val spark = SparkSession.builder().config(sparkConf).getOrCreate()
        //导入隐式转换,这里的spark其实是环境对象的名称
        //要求这个对象使用val声明
        import spark.implicits._ //最好用不用上都加上

        //逻辑操作
        val rdd = spark.sparkContext.makeRDD(List(
            (1, "zhangsan", 30),
            (2, "lisi", 20),
            (3, "wangwu", 40),
        ))

        //RDD<=>DataSet
//        val userRDD: RDD[User] = rdd.map {
//            case (id, name, age) => {
//                User(id, name, age)
//            }
//        }
        //val userDS: Dataset[User] = userRDD.toDS()
        //sparkSql封装的对象提供了大量的方法进行处理，类似于RDD的算子操作
        //userDS.join()

        //error
        //val df: DataFrame = rdd.toDF("id", "name", "age")
        //        val ds: Dataset[Row] = df.map(row => {
        //            val id: Any = row(0)
        //            val name: Any = row(1)
        //            val age: Any = row(3)
        //            Row(id, "name" + name, age)
        //        })


//        val userRDD: RDD[User] = rdd.map {
//            case (id, name, age) => {
//                User(id, name, age)
//            }
//        }
//        val userDS: Dataset[User] = userRDD.toDS()
//        val newDS: Dataset[User] = userDS.map(user => {
//            User(user.id, "name:" + user.name, user.age)
//        })
//        newDS.show()

        //使用自定义函数在SQL中完成数据的转换操作
        val df = rdd.toDF("id", "name", "age")
        df.createOrReplaceTempView("user")
        spark.udf.register("addName", (x: String) => "Name:" + x)
        spark.udf.register("changeAge", (x: Int) => 18)

        spark.sql("select addName(name),changeAge(age) from user").show

        spark.stop()
    }

    case class User(id: Int, name: String, age: Int)


}

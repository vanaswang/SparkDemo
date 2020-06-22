package com.vanas.bigdata.spark.sql

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession


/**
 * @author Vanas
 * @create 2020-06-10 4:32 下午 
 */
object SparkSql11_Load_Hive {
    def main(args: Array[String]): Unit = {
        //创建环境对象
        val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("sparkSQL")

        //builder构建，创建
        //默认情况下SparkSQL支持本地Hive操作的，执行前需要启用Hive的支持
        //调用enableHiveSupport方法
        val spark = SparkSession.builder().enableHiveSupport().config(sparkConf).getOrCreate()

        //可以使用基本的sql访问hive中的内容
        spark.sql("create table aa(id int)")
        spark.sql("show tables").show()

        spark.sql("load data local inpath'input/id.txt' into table aa")
        spark.sql("select * from aa").show

        spark.stop()
    }
}

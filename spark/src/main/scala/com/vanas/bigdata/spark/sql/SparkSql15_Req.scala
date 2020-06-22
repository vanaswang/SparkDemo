package com.vanas.bigdata.spark.sql

import org.apache.spark.SparkConf
import org.apache.spark.sql.expressions.{MutableAggregationBuffer, UserDefinedAggregateFunction}
import org.apache.spark.sql.types._
import org.apache.spark.sql.{Row, SparkSession}


/**
 * @author Vanas
 * @create 2020-06-10 4:32 下午 
 */
object SparkSql15_Req {
    def main(args: Array[String]): Unit = {
        System.setProperty("HADOOP_USER_NAME", "vanas")
        //创建环境对象
        val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("sparkSQL")

        //访问外置的Hive
        val spark = SparkSession.builder()
                .enableHiveSupport()
                .config(sparkConf).getOrCreate()
        spark.sql("use bigdata0213")

        //创建自定义聚合函数
        val udaf = new CityRemarkUDAF
        //注册聚合函数
        spark.udf.register("cityReamark", udaf)

        //从hive表中获取满足条件的数据
        //将数据根据区域进行分组，统计商品点击的数量
        spark.sql(
            """
              |select area ,product_name,count(click_product_id) sum_click,cityReamark(city_name)
              |from user_visit_action a
              |join city_info  c on a.city_id = c.city_id
              |join product_info p on p.product_id = a.click_product_id
              |where click_product_id  > -1
              |group by area ,product_name
              |""".stripMargin).createOrReplaceTempView("t1")

        //将统计结果数量进行排序（降序）
        spark.sql(
            """
              |select *,
              |rank() over(distribute by area order by sum_click desc) rank
              |from t1
              |""".stripMargin).createOrReplaceTempView("t2")

        //将组内排序后的结果取前三名
        spark.sql(
            """
              |select *
              |from t2
              |where rank <=3
              |""".stripMargin).show()

        spark.stop()
    }

    //北京，上海，北京，深圳
    //in:cityname:String
    //out:remark:String
    //buffer ：2结构，（total,map）
    //（商品点击总和，每个城市点击总和）
    //（商品点击总和，Map（城市，点击sum））
    //城市点击sum/商品点击总和%

    //自定义城市备注聚合函数
    class CityRemarkUDAF extends UserDefinedAggregateFunction {
        //输入的数据其实就是城市名称
        override def inputSchema: StructType = {
            StructType(Array(StructField("cityName", StringType)))
        }

        //缓冲区中的数据应该为：totalcnt，Map[cityname,cnt]
        override def bufferSchema: StructType = {
            StructType(Array(
                StructField("cityName", LongType),
                StructField("cityMap", MapType(StringType, LongType))
            ))
        }

        //返回城市备注的字符串
        override def dataType: DataType = StringType

        override def deterministic: Boolean = true

        //缓冲区的初始化
        override def initialize(buffer: MutableAggregationBuffer): Unit = {
            buffer(0) = 0L
            //buffer.update(0,0L)
            buffer(1) = Map[String, Long]()
        }

        //更新缓冲区
        override def update(buffer: MutableAggregationBuffer, input: Row): Unit = {
            val cityName: String = input.getString(0)
            //点击总和需要增加
            buffer(0) = buffer.getLong(0) + 1
            //城市点击增加
            val cityMap: Map[String, Long] = buffer.getAs[Map[String, Long]](1)
            val newClickCount = cityMap.getOrElse(cityName, 0L) + 1
            buffer(1) = cityMap.updated(cityName, newClickCount)
        }

        //合并缓冲区
        override def merge(buffer1: MutableAggregationBuffer, buffer2: Row): Unit = {
            //合并点击数量总和
            buffer1(0) = buffer1.getLong(0) + buffer2.getLong(0)

            //合并城市点击map
            val map1 = buffer1.getAs[Map[String, Long]](1)
            val map2 = buffer2.getAs[Map[String, Long]](1)

            buffer1(1) = map1.foldLeft(map2) {
                case (map, (k, v)) => {
                    map.updated(k, map.getOrElse(k, 0L) + v)
                }
            }
        }

        //对缓冲区进行计算并返回备注信息
        override def evaluate(buffer: Row): Any = {
            val totalcnt: Long = buffer.getLong(0)
            val citymap: collection.Map[String, Long] = buffer.getMap[String, Long](1)
            val cityToCountList: List[(String, Long)] = citymap.toList.sortWith(
                (left, right) => left._2 > right._2
            ).take(2)

            //val hasRest = citymap.size > 2
            var rest = 0L
            val s = new StringBuilder
            cityToCountList.foreach {
                case (city, cnt) => {
                    val r = (cnt * 100 / totalcnt)
                    s.append(city + " " + r + "%,")
                    rest = rest + r
                }
            }
            s.toString() + "其他" + (100 - rest) + "%"

            //            if (hasRest) {
            //                s.toString() + "其他" + (100 - rest) + "%"
            //            } else {
            //                toString
            //            }
        }
    }
}

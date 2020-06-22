package com.vanas.bigdata.spark.sql

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession


/**
 * @author Vanas
 * @create 2020-06-10 4:32 下午 
 */
object SparkSql14_Req {
    def main(args: Array[String]): Unit = {
        System.setProperty("HADOOP_USER_NAME", "vanas")
        //创建环境对象
        val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("sparkSQL")

        //访问外置的Hive
        val spark = SparkSession.builder()
                .enableHiveSupport()
                .config(sparkConf).getOrCreate()
        spark.sql("use bigdata0213")
//        spark.sql(
//            """
//              |select
//              |   *
//              |from (
//              |    select
//              |        *,
//              |        rank() over( partition by area order by clickCount desc ) as rank
//              |    from (
//              |        select
//              |            area,
//              |            product_name,
//              |            count(*) as clickCount
//              |        from (
//              |            select
//              |               a.*,
//              |               c.area,
//              |               p.product_name
//              |            from user_visit_action a
//              |            join city_info c on c.city_id = a.city_id
//              |            join product_info p on p.product_id = a.click_product_id
//              |            where a.click_product_id > -1
//              |        ) t1 group by area, product_name
//              |    ) t2
//              |) t3
//              |where rank <= 3
//            """.stripMargin).show
        spark.sql(
            """
              |select *
              |from(
              |select *,
              |rank() over(distribute by area order by sum_click desc) rank
              |from(
              |select area ,product_name,count(click_product_id) sum_click
              |from user_visit_action a
              |join city_info  c on a.city_id = c.city_id
              |join product_info p on p.product_id = a.click_product_id
              |where click_product_id  > -1
              |group by area ,product_name
              |)t1
              |)t2
              |where rank <=3
              |""".stripMargin).show()


        spark.stop()

    }
}

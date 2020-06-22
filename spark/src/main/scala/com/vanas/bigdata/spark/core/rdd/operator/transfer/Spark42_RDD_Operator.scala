package com.vanas.bigdata.spark.core.rdd.operator.transfer

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author Vanas
 * @create 2020-06-02 4:04 下午
 */
object Spark42_RDD_Operator {
    def main(args: Array[String]): Unit = {

        //spark - RDD -算子（方法）
        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File-RDD")
        val sc = new SparkContext(sparkConf)

        val rdd: RDD[(String, Int)] = sc.makeRDD(
            List(("a", 1), ("c", 3), ("b", 2))
        )
        val rdd1: RDD[(User, Int)] = sc.makeRDD(
            List(
                (new User(), 1),
                (new User(), 2),
                (new User(), 3)
            )
        )

        //其实就是sortBy
        //val sortRDD: RDD[(String, Int)] = rdd.sortByKey(true)
        val sortRDD: RDD[(User, Int)] = rdd1.sortByKey()
        println(sortRDD.collect().mkString(","))
        sc.stop()
    }

    //如果自定义key排序，需要将key换入特质Ordered
    class User extends Ordered[User] with Serializable {
        override def compare(that: User): Int = {
            1
        }
    }

}

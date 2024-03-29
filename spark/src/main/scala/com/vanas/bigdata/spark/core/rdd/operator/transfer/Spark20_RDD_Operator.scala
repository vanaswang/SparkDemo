package com.vanas.bigdata.spark.core.rdd.operator.transfer

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author Vanas
 * @create 2020-06-02 4:04 下午
 */
object Spark20_RDD_Operator {
    def main(args: Array[String]): Unit = {

        //spark - RDD -算子（方法）
        //glom=>将每个分区的数据转换为数组


        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File-RDD")
        val sc = new SparkContext(sparkConf)
        //获取每个分区最大值以及分区号
        val dataRDD: RDD[Int] = sc.makeRDD(List(1, 2, 3, 4, 5, 6), 3)

        //分组
        //groupBy方法可以根据指定的规则进行分组，指定的规则的返回值就是分组的key
        //groupBy方法的返回值为元组
        //      元组中的第一个元素，表示分组的key
        //      元组中的第二个元素，表示相同key的数据形成的可迭代的集合
        //groupBy方法执行完毕后，会将数据进行分组操作，但是分区是不会改变的
        //       不同的组的数据会打乱在不同的分区中
        //groupBy方法会导致数据不均匀，产生shuffle操作，如果想改变分区，可以传递参数
        val rdd: RDD[(Int, Iterable[Int])] = dataRDD.groupBy(
            num => {
                num % 2
            },2
        )

        rdd.saveAsTextFile("output")

        //glom=>分区转换为array
        println("分组后的数据分区的数量" + rdd.glom().collect().length) //3

        rdd.collect().foreach {
            case (key, list) => {
                println("key:" + key + " list:" + list.mkString(","))
            }
        }
        //key:0 list:2,4,6
        //key:1 list:1,3,5
        sc.stop()
    }
}

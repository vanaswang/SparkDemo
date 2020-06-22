package com.vanas.bigdata.spark.core.rdd.operator.transfer

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author Vanas
 * @create 2020-06-02 4:04 下午
 */
object Spark41_RDD_Operator {
    def main(args: Array[String]): Unit = {

        //spark - RDD -算子（方法）
        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File-RDD")
        val sc = new SparkContext(sparkConf)


        //combineByKey
        //每个key的平均值:相同key的总和/相同key的数量
        //0=>("a", 88), ("b", 95), ("a", 91)
        //1=>("b", 93), ("a", 95), ("b", 98)
        val rdd: RDD[(String, Int)] = sc.makeRDD(
            List(("a", 88), ("b", 95), ("a", 91), ("b", 93), ("a", 95), ("b", 98)), 2
        )
        //rdd.reduceByKey(_ + _)  //88,91 没有把2保存起来
        //rdd.aggregateByKey(0)(_+_,_+_) 也不行
        //88=>（88，1）+91=>(172,2)+95=>(274,3)
        //计算时需要将val的格式发生改变，只需要第一个v发生改变结构即可
        //如果计算时发现相同key的value不符合计算规格的格式的话，那么选择combineByKey

        //combineByKey方法可以传递3个参数
        //第一个参数表示的是将计算的第一个值转换结构
        //第二个参数表示的是分区内的计算规则
        //第三个参数表示的是分区间的计算规则
        val result: RDD[(String, (Int, Int))] = rdd.combineByKey(
            v => (v, 1),
            (t: (Int, Int), v) => {
                (t._1 + v, t._2 + 1)
            },
            (t1: (Int, Int), t2: (Int, Int)) => {
                (t1._1 + t2._1, t1._2 + t2._2)
            }
        )
        result.map {
            case (key, (total, cnt)) => {
                (key, total / cnt)
            }
        }.collect().foreach(println)
        sc.stop()
    }

}

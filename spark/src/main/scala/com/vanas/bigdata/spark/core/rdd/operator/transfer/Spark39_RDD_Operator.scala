package com.vanas.bigdata.spark.core.rdd.operator.transfer

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * @author Vanas
 * @create 2020-06-02 4:04 下午
 */
object Spark39_RDD_Operator {
    def main(args: Array[String]): Unit = {

        //spark - RDD -算子（方法）
        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("File-RDD")
        val sc = new SparkContext(sparkConf)

        //将分区内相同key取最大值，分区间相同的key求和
        //分区内和分区间计算规则不一样
        //reduceByKey ：分区内和分区间计算规则相同
        //0=>[(a,2),(c,3)]
        //1=>[(b,4),(c,6)]
        //                  =>[(a,2),(b,4),(c,9)]
        val rdd: RDD[(String, Int)] = sc.makeRDD(
            List(
                ("a", 1), ("a", 2), ("c", 3),
                ("b", 4), ("c", 5), ("c", 6)
            ), 2
        )

        //aggregateByKey:根据key进行数据聚合
        //Scala语法：函数柯里化
        //方法有两个参数列表需要传递参数
        //第一个参数列表中传递的参数为 zeroValue: 计算初始值
        //      用于分区内进行计算时，当作初始值使用
        //第二个参数列表中传递的参数为
        //     seqOp:分区内的计算规则 相同key的value计算
        //     combOp：分区间的计算规则 相同key的value的计算

        val result: RDD[(String, Int)] = rdd.aggregateByKey(0)(
            (x, y) => math.max(x, y),
            (x, y) => x + y
        )
        println(result.collect().mkString(","))
        sc.stop()
    }

}

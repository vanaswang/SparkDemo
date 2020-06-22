package com.vanas.bigdata.spark.streaming.oper

import org.apache.spark.SparkConf
import org.apache.spark.rdd.RDD
import org.apache.spark.streaming.dstream.InputDStream
import org.apache.spark.streaming.{Seconds, StreamingContext}

import scala.collection.mutable

/**
 * @author Vanas
 * @create 2020-06-13 11:39 上午
 */
object SparkStreaming03_Queue {
    def main(args: Array[String]): Unit = {
        //spark 环境
        //微批次的准实时框架
        val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("streaming")
        //val ssc = new StreamingContext(sparkConf, Duration(3000))
        val ssc = new StreamingContext(sparkConf, Seconds(3))

        //执行逻辑
        val queue = new mutable.Queue[RDD[String]]()
        val queueDS: InputDStream[String] = ssc.queueStream(queue)
        queueDS.print()

        //启动采集器
        ssc.start()
        for (i <- 1 to 5) {
            val rdd = ssc.sparkContext.makeRDD(List(i.toString))
            queue.enqueue(rdd)
            Thread.sleep(1000)
        }
        //等待采集器的结束
        ssc.awaitTermination()
    }
}

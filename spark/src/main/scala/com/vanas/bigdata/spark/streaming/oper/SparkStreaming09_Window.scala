package com.vanas.bigdata.spark.streaming.oper

import org.apache.spark.SparkConf
import org.apache.spark.streaming.dstream.{DStream, ReceiverInputDStream}
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
 * @author Vanas
 * @create 2020-06-13 11:39 上午
 */
object SparkStreaming09_Window {
    def main(args: Array[String]): Unit = {
        //spark 环境
        val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("streaming")
        val ssc = new StreamingContext(sparkConf, Seconds(3))
        ssc.sparkContext.setCheckpointDir("cp")
        val ds: ReceiverInputDStream[String] = ssc.socketTextStream("localhost", 9999)

        //窗口
        //val ints: Array[Int] = Array(1, 2, 3, 4, 5, 6, 7, 8)
        //ints.sliding(3)
        val wordDS: DStream[String] = ds.flatMap(_.split(" "))
        val wordToOneDS: DStream[(String, Int)] = wordDS.map((_, 1))
        //将多个采集周期作为计算的整体
        //窗口的范围应该是采集周期的整数倍
        //默认滑动的幅度（步长）为一个采集周期
        //val windowDS: DStream[(String, Int)] = wordToOneDS.window(Seconds(9))
        //窗口的计算的周期等同于窗口的滑动的步长
        //窗口的范围大小和滑动的步长应该都是采集周期的整数倍
        val windowDS: DStream[(String, Int)] = wordToOneDS.window(Seconds(9), Seconds(6))
        val result: DStream[(String, Int)] = windowDS.reduceByKey(_ + _)
        result.print()
        //启动采集器
        ssc.start()
        //等待采集器的结束
        ssc.awaitTermination()
    }
}

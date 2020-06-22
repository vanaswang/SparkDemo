package com.vanas.bigdata.spark.streaming.oper

import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.streaming.dstream.ReceiverInputDStream

/**
 * @author Vanas
 * @create 2020-06-13 11:39 上午
 */
object SparkStreaming13_Continue {
    def main(args: Array[String]): Unit = {


        val ssc = StreamingContext.getActiveOrCreate("cp", getStreamingContext)

        ssc.start()
        ssc.awaitTermination()
    }
    def getStreamingContext() : StreamingContext = {
        // Spark环境
        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("streaming")
        val ssc = new StreamingContext(sparkConf, Seconds(3))
        // SparkStreaming中的检查点不仅仅保存中间处理数据，还保存逻辑
        ssc.checkpoint("cp")

        val ds: ReceiverInputDStream[String] = ssc.socketTextStream("localhost", 9999)
        ds.print()
        ssc
    }
}

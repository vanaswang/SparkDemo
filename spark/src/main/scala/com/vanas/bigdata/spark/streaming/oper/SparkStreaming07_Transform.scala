package com.vanas.bigdata.spark.streaming.oper

import org.apache.spark.SparkConf
import org.apache.spark.streaming.dstream.{DStream, ReceiverInputDStream}
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
 * @author Vanas
 * @create 2020-06-13 11:39 上午
 */
object SparkStreaming07_Transform {
    def main(args: Array[String]): Unit = {
        //spark 环境
        val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("streaming")
        val ssc = new StreamingContext(sparkConf, Seconds(3))

        val ds: ReceiverInputDStream[String] = ssc.socketTextStream("localhost", 9999)

        //转换
        //Code Driver(1)
        val newDS: DStream[String] = ds.transform(
            rdd => {
            //Code Driver(N)
            //rdd.map(_ * 2)
            rdd.map(
                data => {
                    //Code Executor(N)
                    data * 2
                }
            )
        })
//        val newDS: DStream[String] = ds.map(_ * 2)
        //Code:Driver(1)
//        val newDS: DStream[String] = ds.map(
//            data => {
        //Code:Executor(N)
//                data * 2
//            }
//        )
        newDS.print()

        //启动采集器
        ssc.start()
        //等待采集器的结束
        ssc.awaitTermination()


    }
}

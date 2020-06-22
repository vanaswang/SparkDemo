package com.vanas.bigdata.spark.streaming.oper

import org.apache.spark.SparkConf
import org.apache.spark.streaming.dstream.ReceiverInputDStream
import org.apache.spark.streaming.{Seconds, StreamingContext, StreamingContextState}

/**
 * @author Vanas
 * @create 2020-06-13 11:39 上午
 */
object SparkStreaming12_Stop {
    def main(args: Array[String]): Unit = {
        //spark 环境
        val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("streaming")
        val ssc = new StreamingContext(sparkConf, Seconds(3))
        ssc.sparkContext.setCheckpointDir("cp")
        val ds: ReceiverInputDStream[String] = ssc.socketTextStream("localhost", 9999)

        //窗口
        val wwordToOneDS = ds.map(num => ("key", num))

        //启动采集器
        ssc.start()

        //当业务升级的场合，或逻辑发生变化
        //stop方法一般不会放置在main线程完成
        //需要将stop方法使用新的线程完成调用
        new Thread(new Runnable {
            override def run(): Unit = {
                //stop方法的调用不应该是线程启动后马上调用
                //Stop方法调用的时机，这个时机不容易确定，需要周期性的判断时机是否出现
                while (true) {
                    Thread.sleep(3000)
                    //关闭时机的判断一般不会使用业务操作
                    //一般采用第三方的程序或存储进行判断
                    //HDFS=>/stopSpark
                    //zk
                    //mysql
                    //redis
                    //优雅的关闭
                    val state: StreamingContextState = ssc.getState()
                    if (state ==StreamingContextState.ACTIVE){
                        ssc.stop(true,true)
                        //SparkStreaming如果停止后，当前的线程也应该同时停止
                        System.exit(0)
                    }
                }
            }
        }).start()

        //线程
        //        val t = new Thread()
        //        t.start()
        //        t.stop() //数据安全

        //等待采集器的结束
        ssc.awaitTermination()
    }

}

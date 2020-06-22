package com.vanas.bigdata.spark.streaming.oper

import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.streaming.dstream.{DStream, ReceiverInputDStream}

/**
 * @author Vanas
 * @create 2020-06-13 11:39 上午
 */
object SparkStreaming11_Output {
    def main(args: Array[String]): Unit = {
        //spark 环境
        val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("streaming")
        val ssc = new StreamingContext(sparkConf, Seconds(3))
        ssc.sparkContext.setCheckpointDir("cp")
        val ds: ReceiverInputDStream[String] = ssc.socketTextStream("localhost", 9999)

        //窗口
        val wwordToOneDS = ds.map(num => ("key", num.toInt))

        //reduceByKeyAndWindow方法一般用于重复数据的范围比较大的场合，这样可以优化效率
        val result: DStream[(String, Int)] = wwordToOneDS.reduceByKeyAndWindow(
            (x, y) => {
                println(s"x=${x},y=${y}")
                x + y
            },
            (a, b) => {
                println(s"x=${a},y=${b}")
                a - b
            },
            Seconds(9)
        )
        //result.print()
        //result.saveAsObjectFiles()
        //transfrom:rdd =>rdd
        //foreachRDD:rdd=>Unit

        //rdd=>Map =>A=>B    //返回
        //rdd =>foreach=>A=>Unit   //不返回v
        //Code Driver(1)
        result.foreachRDD(rdd => {
            //Code Driver(M)
            rdd.foreach(
                data => {
                    //Code Executor(N)
                    println(data)
                })
        })


        //启动采集器
        ssc.start()
        //等待采集器的结束
        ssc.awaitTermination()
    }
}

package com.vanas.bigdata.spark.streaming.oper

import org.apache.spark.SparkConf
import org.apache.spark.streaming.dstream.ReceiverInputDStream
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
 * @author Vanas
 * @create 2020-06-13 11:39 上午
 */
object SparkStreaming08_State {
    def main(args: Array[String]): Unit = {
        //spark 环境
        val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("streaming")
        val ssc = new StreamingContext(sparkConf, Seconds(3))
        ssc.sparkContext.setCheckpointDir("cp")

        val ds: ReceiverInputDStream[String] = ssc.socketTextStream("localhost", 9999)
        //转换
        //数据的有状态的保存
        //将spark每个采集周期数据的处理结果保存起来，然后和后续的数据进行聚合
        //reduceByKey方法是无状态的，而我们需要的有状态的数据操作
        //有状态的目的其实就是将每一个采集周期数据的计算结果临时保存起来
        //然后再下一次数据的处理中可以继续使用
        ds
                .flatMap(_.split(" "))
                .map((_, 1L))
                //.reduceByKey(_+_)
                //updateStateByKey 是有状态计算方法
                //第一个参数表示 相同key的value的集合
                //第二个参数表示 相同key的缓冲区的数据,有可能为空
                //requirement failed : The checkpoint directory has not been set.
                //这里的计算中间结果需要保存到检查点的位置中，所以需要设定检查点路径
                .updateStateByKey[Long](
                    (seq: Seq[Long], buffer: Option[Long]) => { //option存储临时数据 可以理解成缓冲区
                        val newBufferValue = buffer.getOrElse(0L) + seq.sum
                        Option(newBufferValue)
                    }
                )
                .print()

        //启动采集器
        ssc.start()
        //等待采集器的结束
        ssc.awaitTermination()


    }
}

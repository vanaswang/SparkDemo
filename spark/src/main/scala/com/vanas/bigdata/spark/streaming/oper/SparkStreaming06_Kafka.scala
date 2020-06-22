package com.vanas.bigdata.spark.streaming.oper

import org.apache.kafka.clients.consumer.{ConsumerConfig, ConsumerRecord}
import org.apache.spark.SparkConf
import org.apache.spark.streaming.dstream.{DStream, InputDStream}
import org.apache.spark.streaming.kafka010.{ConsumerStrategies, KafkaUtils, LocationStrategies}
import org.apache.spark.streaming.{Seconds, StreamingContext}

/**
 * @author Vanas
 * @create 2020-06-13 11:39 上午
 */
object SparkStreaming06_Kafka {
    def main(args: Array[String]): Unit = {
        //spark 环境
        val sparkConf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("streaming")
        val ssc = new StreamingContext(sparkConf, Seconds(3))

        //使用SparkStreaming读取Kafaka的数据

        //kafka的配置信息
        val kafkaPara: Map[String, Object] = Map[String, Object](
            ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG -> "hadoop130:9092,hadoop133:9092,hadoop134:9092",
            ConsumerConfig.GROUP_ID_CONFIG -> "vanas", //kafka消费者组
            "key.deserializer" -> "org.apache.kafka.common.serialization.StringDeserializer", //反序列化
            "value.deserializer" -> "org.apache.kafka.common.serialization.StringDeserializer"
        )

        val kafkaDStream: InputDStream[ConsumerRecord[String, String]] =
            KafkaUtils.createDirectStream[String, String](
            ssc, //环境
            LocationStrategies.PreferConsistent, //分区分配逻辑
            ConsumerStrategies.Subscribe[String, String](Set("vanas"), kafkaPara)) //参数：topic和配置


        val valueDStream: DStream[String] = kafkaDStream.map(record => record.value())

        //6.计算WordCount
        valueDStream.flatMap(_.split(" "))
                .map((_, 1))
                .reduceByKey(_ + _)
                .print()

        //启动采集器
        ssc.start()
        //等待采集器的结束
        ssc.awaitTermination()
    }
}

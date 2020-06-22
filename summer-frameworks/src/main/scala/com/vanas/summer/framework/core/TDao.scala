package com.vanas.summer.framework.core

import java.util.Properties

import com.vanas.summer.framework.util.{EnvUtil, PropertiesUtil}
import org.apache.kafka.clients.consumer.{ConsumerConfig, ConsumerRecord}
import org.apache.kafka.clients.producer.{KafkaProducer, ProducerConfig, ProducerRecord}
import org.apache.spark.streaming.dstream.InputDStream
import org.apache.spark.streaming.kafka010.{ConsumerStrategies, KafkaUtils, LocationStrategies}

/**
 * @author Vanas
 * @create 2020-06-08 8:14 下午 
 */
trait TDao {
    def readFile(path: String) = {
        EnvUtil.getEnv().textFile(path)
    }

    /**
     * 从kafka中读取数据
     */
    def readKafka() = {
        val brokerList = PropertiesUtil.getValue("kafka.broker.list")
        val groupid = PropertiesUtil.getValue("kafka.group.id")
        val topic = PropertiesUtil.getValue("kafka.topic")
        //kafka的配置信息
        val kafkaPara: Map[String, Object] = Map[String, Object](
            ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG -> brokerList,
            ConsumerConfig.GROUP_ID_CONFIG -> groupid, //kafka消费者组
            "key.deserializer" -> "org.apache.kafka.common.serialization.StringDeserializer", //反序列化
            "value.deserializer" -> "org.apache.kafka.common.serialization.StringDeserializer"
        )

        val kafkaDStream: InputDStream[ConsumerRecord[String, String]] =
            KafkaUtils.createDirectStream[String, String](
                EnvUtil.getStreamingEnv(),
                LocationStrategies.PreferConsistent, //分区分配逻辑
                ConsumerStrategies.Subscribe[String, String](Set(topic), kafkaPara)) //参数：topic和配置

        kafkaDStream.map(record => record.value())
    }

    /**
     * 向kafka中发送数据
     */
    def writeToKafka(implicit datas: Seq[String]) = {
        // 获取配置文件config.properties中的Kafka配置参数
        val broker: String = PropertiesUtil.getValue("kafka.broker.list")
        val topic = PropertiesUtil.getValue("kafka.topic")

        // 创建配置对象
        val prop = new Properties()
        // 添加配置
        prop.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, broker)
        prop.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer")
        prop.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer")

        // 根据配置创建Kafka生产者
        // 创建Kafka消费者
        val kafkaProducer: KafkaProducer[String, String] = new KafkaProducer[String, String](prop)

        while (true) {
            // 随机产生实时数据并通过Kafka生产者发送到Kafka集群中
            for (line <- datas) {
                kafkaProducer.send(new ProducerRecord[String, String](topic, line)) //泛型第一个是key 默认是null
                println(line)
            }
            Thread.sleep(2000)
        }
    }
}

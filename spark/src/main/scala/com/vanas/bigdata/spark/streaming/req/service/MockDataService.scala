package com.vanas.bigdata.spark.streaming.req.service

import com.vanas.bigdata.spark.streaming.req.dao.MockDataDao
import com.vanas.summer.framework.core.TService

/**
 * @author Vanas
 * @create 2020-06-15 11:03 上午 
 */
class MockDataService extends TService {
    private val mockDataDao = new MockDataDao

    override def analysis() = {

        //生成模拟数据
        //import mockDataDao._
        val datas = mockDataDao.getMockData()
        //向Kafka中发送数据
        mockDataDao.writeToKafka(datas)
    }
}

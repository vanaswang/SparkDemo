package com.vanas.bigdata.spark.streaming.req.controller

import com.vanas.bigdata.spark.streaming.req.service.MockDataService
import com.vanas.summer.framework.core.TController

/**
 * @author Vanas
 * @create 2020-06-15 11:02 上午 
 */
class MockDataController extends TController {
    private val mockDataService = new MockDataService

    override def execute(): Unit = {
        val result = mockDataService.analysis()
    }
}

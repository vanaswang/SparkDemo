package com.vanas.bigdata.spark.streaming.req.application

import com.vanas.bigdata.spark.streaming.req.controller.{BlackListController, MockDataController}
import com.vanas.summer.framework.core.TApplication

/**
 * @author Vanas
 * @create 2020-06-15 11:57 上午 
 */
object BlackListApplication extends App with TApplication {
    private val controller = new MockDataController
    start("sparkStreaming") {
        val controller = new BlackListController
        controller.execute()
    }
}

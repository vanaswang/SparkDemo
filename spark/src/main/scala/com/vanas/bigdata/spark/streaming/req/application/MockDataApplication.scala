package com.vanas.bigdata.spark.streaming.req.application

import com.vanas.bigdata.spark.streaming.req.controller.MockDataController
import com.vanas.summer.framework.core.TApplication

/**
 * @author Vanas
 * @create 2020-06-15 10:53 上午 
 */
object MockDataApplication extends App with TApplication {
    start("spartStreaming") {
        val controller = new MockDataController
        controller.execute()
    }
}

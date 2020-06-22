package com.vanas.bigdata.spark.streaming.req.application

import com.vanas.bigdata.spark.streaming.req.controller.LastHourAdCountAnalysisController
import com.vanas.summer.framework.core.TApplication

/**
 * @author Vanas
 * @create 2020-06-16 9:28 上午 
 */
object LastHourAdCountAnalysisApplication extends App with TApplication{

    start("sparkStreaming"){
        val controller = new LastHourAdCountAnalysisController
        controller.execute()
    }
}

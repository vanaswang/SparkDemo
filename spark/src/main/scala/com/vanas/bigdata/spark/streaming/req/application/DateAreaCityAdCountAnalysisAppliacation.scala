package com.vanas.bigdata.spark.streaming.req.application

import com.vanas.bigdata.spark.streaming.req.controller.DateAreaCityAdCountAnalysisController
import com.vanas.summer.framework.core.TApplication

/**
 * @author Vanas
 * @create 2020-06-16 8:55 上午 
 */
object DateAreaCityAdCountAnalysisAppliacation extends App with TApplication {
    start("sparkStreaming") {
        val dateAreaCityAdCountAnalysisController = new DateAreaCityAdCountAnalysisController
        dateAreaCityAdCountAnalysisController.execute()
    }

}

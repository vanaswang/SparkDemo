package com.vanas.bigdata.spark.streaming.req.controller

import com.vanas.bigdata.spark.streaming.req.service.DateAreaCityAdCountAnalysisService
import com.vanas.summer.framework.core.TController

/**
 * @author Vanas
 * @create 2020-06-16 8:56 上午 
 */
class DateAreaCityAdCountAnalysisController extends TController {
    private val dateAreaCityAdCountAnalysisService = new DateAreaCityAdCountAnalysisService

    override def execute(): Unit = {
        dateAreaCityAdCountAnalysisService.analysis()

    }
}

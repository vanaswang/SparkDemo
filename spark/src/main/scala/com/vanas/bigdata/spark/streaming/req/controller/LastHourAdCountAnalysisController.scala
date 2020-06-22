package com.vanas.bigdata.spark.streaming.req.controller

import com.vanas.bigdata.spark.streaming.req.service.LastHourAdCountAnalysisService
import com.vanas.summer.framework.core.TController

/**
 * @author Vanas
 * @create 2020-06-16 9:28 上午 
 */
class LastHourAdCountAnalysisController extends TController {
    private val lastHourAdCountAnalysisService = new LastHourAdCountAnalysisService

    override def execute(): Unit = {
        lastHourAdCountAnalysisService.analysis()
    }
}

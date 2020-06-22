package com.vanas.bigdata.spark.streaming.req.controller

import com.vanas.bigdata.spark.streaming.req.service.BlackListService
import com.vanas.summer.framework.core.TController

/**
 * @author Vanas
 * @create 2020-06-15 11:57 上午 
 */
class BlackListController extends TController{
    private val blackListService = new BlackListService
    override def execute(): Unit = {
        val result = blackListService.analysis()
    }
}

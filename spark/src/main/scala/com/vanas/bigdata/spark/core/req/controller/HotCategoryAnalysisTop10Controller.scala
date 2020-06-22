package com.vanas.bigdata.spark.core.req.controller

import com.vanas.bigdata.spark.core.req.service.HotCategoryAnalysisTop10Service
import com.vanas.summer.framework.core.TController

/**
 * wordcount控制器
 *
 * @author Vanas
 * @create 2020-06-08 8:11 下午 
 */
class HotCategoryAnalysisTop10Controller extends TController {

    private val hotCategoryAnalysisTop10Service = new HotCategoryAnalysisTop10Service

    override def execute(): Unit = {
        val result = hotCategoryAnalysisTop10Service.analysis()
        result.foreach(println)
    }
}

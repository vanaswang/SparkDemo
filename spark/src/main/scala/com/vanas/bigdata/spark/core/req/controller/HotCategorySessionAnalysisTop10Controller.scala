package com.vanas.bigdata.spark.core.req.controller

import com.vanas.bigdata.spark.core.req.bean
import com.vanas.bigdata.spark.core.req.service.{HotCategoryAnalysisTop10Service, HotCategorySessionAnalysisTop10Service}
import com.vanas.summer.framework.core.TController

/**
 * wordcount控制器
 *
 * @author Vanas
 * @create 2020-06-08 8:11 下午 
 */
class HotCategorySessionAnalysisTop10Controller extends TController {

    private val hotCategoryAnalysisTop10Service = new HotCategoryAnalysisTop10Service
    private val hotCategorySessionAnalysisTop10Service = new HotCategorySessionAnalysisTop10Service

    override def execute(): Unit = {
        val categories: List[bean.HotCategory] = hotCategoryAnalysisTop10Service.analysis()
        val result = hotCategorySessionAnalysisTop10Service.analysis(categories)
        result.foreach(println)
    }
}

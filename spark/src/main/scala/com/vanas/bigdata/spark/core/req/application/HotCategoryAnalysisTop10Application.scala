package com.vanas.bigdata.spark.core.req.application

import com.vanas.bigdata.spark.core.req.controller.HotCategoryAnalysisTop10Controller
import com.vanas.summer.framework.core.TApplication

/**
 * @author Vanas
 * @create 2020-06-08 4:41 下午
 */
object HotCategoryAnalysisTop10Application extends App with TApplication {
    start("spark") {
        val controller = new HotCategoryAnalysisTop10Controller
        controller.execute()
    }
}

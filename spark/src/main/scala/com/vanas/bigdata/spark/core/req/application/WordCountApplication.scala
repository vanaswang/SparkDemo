package com.vanas.bigdata.spark.core.req.application

import com.vanas.bigdata.spark.core.req.controller.WordCountController
import com.vanas.summer.framework.core.TApplication

/**
 * @author Vanas
 * @create 2020-06-08 4:41 下午
 */
object WordCountApplication extends App with TApplication {
    start("spark") {
        val controller = new WordCountController
        controller.execute()
    }
}

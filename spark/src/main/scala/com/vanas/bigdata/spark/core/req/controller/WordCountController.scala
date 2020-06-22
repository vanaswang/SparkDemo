package com.vanas.bigdata.spark.core.req.controller

import com.vanas.bigdata.spark.core.req.service.WordCountService
import com.vanas.summer.framework.core.TController

/**
 * wordcount控制器
 *
 * @author Vanas
 * @create 2020-06-08 8:11 下午 
 */
class WordCountController extends TController {

    private val wordCountService = new WordCountService

    override def execute(): Unit = {
        val wordCountArray: Array[(String, Int)] = wordCountService.analysis()
        println(wordCountArray.mkString(","))
    }
}

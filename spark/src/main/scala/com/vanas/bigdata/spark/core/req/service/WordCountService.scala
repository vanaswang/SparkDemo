package com.vanas.bigdata.spark.core.req.service

import com.vanas.bigdata.spark.core.req.dao.WordCountDao
import com.vanas.summer.framework.core.TService
import org.apache.spark.rdd.RDD

/**
 * @author Vanas
 * @create 2020-06-08 8:13 下午 
 */
class WordCountService extends TService {
    private val wordCountDao = new WordCountDao

    /**
     * 数据分析
     */
    override def analysis() = {
        //val sc: SparkContext = envData.asInstanceOf[SparkContext]
        //val fileRDD: RDD[String] = sc.textFile("input/word.txt")
        //val fileRDD: RDD[String] = EnvUtil.getEnv().textFile("input/word.txt")
        val fileRDD: RDD[String] = wordCountDao.readFile("input/word.txt")
        val word: RDD[String] = fileRDD.flatMap(_.split(" "))
        val mapRDD: RDD[(String, Int)] = word.map(word => (word, 1))
        val wordToSumRdd: RDD[(String, Int)] = mapRDD.reduceByKey(_ + _)
        val wordCountArray: Array[(String, Int)] = wordToSumRdd.collect()
        wordCountArray
    }
}

package com.vanas.bigdata.spark.core.req.service

import com.vanas.bigdata.spark.core.req.bean
import com.vanas.bigdata.spark.core.req.bean.HotCategory
import com.vanas.bigdata.spark.core.req.dao.HotCategorySessionAnalysisTop10Dao
import com.vanas.summer.framework.core.TService
import com.vanas.summer.framework.util.EnvUtil
import org.apache.spark.rdd.RDD

/**
 * @author Vanas
 * @create 2020-06-13 12:07 上午 
 */
class HotCategorySessionAnalysisTop10Service extends TService {
    private val hotCategorySessionAnalysisTop10Dao = new HotCategorySessionAnalysisTop10Dao

    /**
     * 数据分析
     */
    override def analysis(data: Any) = {

        val top10: List[HotCategory] = data.asInstanceOf[List[bean.HotCategory]]
        val top10Ids: List[String] = top10.map(_.categoryId)
        val bcList = EnvUtil.getEnv().broadcast(top10Ids)

        val acctionRDD: RDD[bean.UserVisitAction] =
            hotCategorySessionAnalysisTop10Dao.getUserVisitAction("input/user_visit_action.txt")
        val fillterRDD: RDD[bean.UserVisitAction] = acctionRDD.filter(
            action => {
                if (action.click_category_id != -1) {

                    bcList.value.contains(action.click_category_id.toString)
                } else {
                    false
                }
            }
        )
        val rdd: RDD[(String, Int)] = fillterRDD.map(
            action => {
                (action.click_category_id + "_" + action.session_id, 1)
            }
        )
        val reduceRDD: RDD[(String, Int)] = rdd.reduceByKey(_ + _)
        val mapRDD: RDD[(String, (String, Int))] = reduceRDD.map {
            case (key, count) => {
                val ks: Array[String] = key.split("_")
                (ks(0), (ks(1), count))
            }
        }
        val groupRDD: RDD[(String, Iterable[(String, Int)])] = mapRDD.groupByKey()
        val resultRDD: RDD[(String, List[(String, Int)])] = groupRDD.mapValues(
            iter => {
                iter.toList.sortWith(
                    (left, right) => {
                        left._2 > right._2
                    }
                ).take(10)
            }
        )
        resultRDD.collect()
    }

    /**
     * 数据分析
     */
    def analysis1(data: Any) = {

        val top10: List[HotCategory] = data.asInstanceOf[List[bean.HotCategory]]
        val acctionRDD: RDD[bean.UserVisitAction] =
            hotCategorySessionAnalysisTop10Dao.getUserVisitAction("input/user_visit_action.txt")
        val fillterRDD: RDD[bean.UserVisitAction] = acctionRDD.filter(
            action => {
                if (action.click_category_id != -1) {
                    var flag = false
                    top10.foreach(
                        hc => {
                            if (hc.categoryId.toLong == action.click_category_id) {
                                flag = true
                            }
                        }
                    )
                    flag
                } else {
                    false
                }
            }
        )
        val rdd: RDD[(String, Int)] = fillterRDD.map(
            action => {
                (action.click_category_id + "_" + action.session_id, 1)
            }
        )
        val reduceRDD: RDD[(String, Int)] = rdd.reduceByKey(_ + _)
        val mapRDD: RDD[(String, (String, Int))] = reduceRDD.map {
            case (key, count) => {
                val ks: Array[String] = key.split("_")
                (ks(0), (ks(1), count))
            }
        }
        val groupRDD: RDD[(String, Iterable[(String, Int)])] = mapRDD.groupByKey()
        val resultRDD: RDD[(String, List[(String, Int)])] = groupRDD.mapValues(
            iter => {
                iter.toList.sortWith(
                    (left, right) => {
                        left._2 > right._2
                    }
                ).take(10)
            }
        )
        resultRDD.collect()
    }
}

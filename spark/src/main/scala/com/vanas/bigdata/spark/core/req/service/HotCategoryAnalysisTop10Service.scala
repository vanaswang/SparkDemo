package com.vanas.bigdata.spark.core.req.service

import com.vanas.bigdata.spark.core.req.bean.HotCategory
import com.vanas.bigdata.spark.core.req.dao.HotCategoryAnalysisTop10Dao
import com.vanas.bigdata.spark.core.req.helper.HotCategoryAccumulator
import com.vanas.summer.framework.core.TService
import com.vanas.summer.framework.util.EnvUtil
import org.apache.spark.rdd.RDD

import scala.collection.mutable

/**
 * @author Vanas
 * @create 2020-06-13 12:07 上午 
 */
class HotCategoryAnalysisTop10Service extends TService {
    private val hotCategoryAnalysisTop10Dao = new HotCategoryAnalysisTop10Dao


    /**
     * 数据分析
     */
    override def analysis() = {
        val actionRDD: RDD[String] = hotCategoryAnalysisTop10Dao.readFile("input/user_visit_action.txt")

        val acc = new HotCategoryAccumulator

        EnvUtil.getEnv().register(acc, "hotCategory")

        actionRDD.foreach(
            action => {
                val datas: Array[String] = action.split("_")
                if (datas(6) != "-1") {
                    //点击的场合
                    acc.add((datas(6), "click"))
                } else if (datas(8) != "null") {
                    val ids: Array[String] = datas(8).split(",")
                    ids.foreach(
                        id => {
                            acc.add((id, "order"))
                        }
                    )
                } else if (datas(10) != "null") {
                    val ids: Array[String] = datas(10).split(",")
                    ids.foreach(
                        id => {
                            acc.add((id, "pay"))
                        }
                    )
                } else {
                    Nil
                }
            }
        )

        val accValue: mutable.Map[String, HotCategory] = acc.value
        val categories: mutable.Iterable[HotCategory] = accValue.map(_._2)
        categories.toList.sortWith(
            (leftHC, rightHC) => {
                if (leftHC.clickCount > rightHC.clickCount) {
                    true
                } else if (leftHC.clickCount == rightHC.clickCount) {
                    if (leftHC.orderCount > rightHC.orderCount) {
                        true
                    } else if (leftHC.orderCount == rightHC.orderCount) {
                        leftHC.payCount > rightHC.payCount
                    } else {
                        false
                    }
                } else {
                    false
                }
            }
        ).take(10)
    }

    /**
     * 数据分析
     */
    def analysis4() = {
        val actionRDD: RDD[String] = hotCategoryAnalysisTop10Dao.readFile("input/user_visit_action.txt")

        val flatMapRDD = actionRDD.flatMap(
            action => {
                val datas = action.split("_")
                if (datas(6) != "-1") {
                    //点击的场合
                    List((datas(6), HotCategory(datas(6), 1, 0, 0)))
                } else if (datas(8) != "null") {
                    //下单的场合
                    val ids: Array[String] = datas(8).split(",")
                    ids.map(id => (id, HotCategory(id, 0, 1, 0)))
                } else if (datas(10) != "null") {
                    //支付的场合
                    val ids: Array[String] = datas(10).split(",")
                    ids.map(id => (id, HotCategory(id, 0, 0, 1)))
                } else {
                    Nil
                }
            }
        )
        val reduceRDD = flatMapRDD.reduceByKey(
            (c1, c2) => {
                c1.clickCount = c1.clickCount + c2.clickCount
                c1.orderCount = c1.orderCount + c2.orderCount
                c1.payCount = c1.payCount + c2.payCount
                c1
            }
        )
        reduceRDD.collect().sortWith(
            (left, right) => {
                val leftHC = left._2
                val rightHC = right._2
                if (leftHC.clickCount > rightHC.clickCount) {
                    true
                } else if (leftHC.clickCount == rightHC.clickCount) {
                    if (leftHC.orderCount > rightHC.orderCount) {
                        true
                    } else if (leftHC.orderCount == rightHC.orderCount) {
                        leftHC.payCount > rightHC.payCount
                    } else {
                        false
                    }
                } else {
                    false
                }
            }
        ).take(10)

    }

    /**
     * 数据分析
     */
    def analysis3() = {
        val actionRDD: RDD[String] = hotCategoryAnalysisTop10Dao.readFile("input/user_visit_action.txt")

        val flatMapRDD: RDD[(String, (Int, Int, Int))] = actionRDD.flatMap(
            action => {
                val datas = action.split("_")
                if (datas(6) != "-1") {
                    //点击的场合
                    List((datas(6), (1, 0, 0)))
                } else if (datas(8) != "null") {
                    //下单的场合
                    val ids: Array[String] = datas(8).split(",")
                    ids.map(id => (id, (0, 1, 0)))
                } else if (datas(10) != "null") {
                    //支付的场合
                    val ids: Array[String] = datas(10).split(",")
                    ids.map(id => (id, (0, 0, 1)))
                } else {
                    Nil
                }
            }
        )
        val reduceRDD: RDD[(String, (Int, Int, Int))] = flatMapRDD.reduceByKey(
            (t1, t2) => {
                (t1._1 + t2._1, t1._2 + t2._2, t1._3 + t2._3)
            }
        )
        val result: Array[(String, (Int, Int, Int))] = reduceRDD.sortBy(_._2).take(10)
        result

    }


    /**
     * 数据分析
     */
    def analysis2() = {
        val actionRDD: RDD[String] = hotCategoryAnalysisTop10Dao.readFile("input/user_visit_action.txt")

        actionRDD.cache()

        val clickRDD: RDD[(String, Int)] = actionRDD.map(
            action => {
                val datas: Array[String] = action.split("_")
                (datas(6), 1)
            }
        ).filter(_._1 != "-1")
        val categoryIdToClickCountRDD: RDD[(String, Int)] = clickRDD.reduceByKey(_ + _)

        val orderRDD: RDD[String] = actionRDD.map {
            action => {
                val datas = action.split("_")
                datas(8)
            }
        }.filter(_ != "null")
        val orderToOneRDD: RDD[(String, Int)] = orderRDD.flatMap {
            case (id) => {
                val ids: Array[String] = id.split(",")
                ids.map(id => (id, 1))
            }
        }
        val categoryIdToOrderCountRDD: RDD[(String, Int)] = orderToOneRDD.reduceByKey(_ + _)

        val payRDD: RDD[String] = actionRDD.map(
            action => {
                val datas: Array[String] = action.split("_")
                datas(10)
            }
        ).filter(_ != "null")
        val categoryIdToPayCountRDD: RDD[(String, Int)] = payRDD.flatMap {
            case (id) => {
                val ids: Array[String] = id.split(",")
                ids.map(id => (id, 1))
            }
        }
        val newClickCountRDD: RDD[(String, (Int, Int, Int))] = categoryIdToClickCountRDD.map {
            case (id, clickCount) => {
                (id, (clickCount, 0, 0))

            }
        }
        val newOrderCountRDD: RDD[(String, (Int, Int, Int))] = categoryIdToOrderCountRDD.map {
            case (id, orderCount) => {
                (id, (0, orderCount, 0))
            }
        }
        val newPayCountRDD: RDD[(String, (Int, Int, Int))] = categoryIdToPayCountRDD.map {
            case (id, payCount) => {
                (id, (0, 0, payCount))
            }
        }
        val countRDD: RDD[(String, (Int, Int, Int))] = newClickCountRDD.union(newOrderCountRDD).union(newPayCountRDD)
        val reduceRDD: RDD[(String, (Int, Int, Int))] = countRDD.reduceByKey {
            case (t1, t2) => {
                (t1._1 + t2._1, t1._2 + t2._2, t1._3 + t2._3)

            }
        }
        val sortRDD: RDD[(String, (Int, Int, Int))] = reduceRDD.sortBy(_._2, false)
        val result: Array[(String, (Int, Int, Int))] = sortRDD.take(10)
        result
    }

    /**
     * 数据分析
     */
    def analysis1() = {
        val actionRDD: RDD[String] = hotCategoryAnalysisTop10Dao.readFile("input/user_visit_action.txt")
        val clickRDD: RDD[(String, Int)] = actionRDD.map(
            action => {
                val datas: Array[String] = action.split("_")
                (datas(6), 1)
            }
        ).filter(_._1 != "-1")
        val categoryIdToClickCountRDD: RDD[(String, Int)] = clickRDD.reduceByKey(_ + _)

        val orderRDD: RDD[String] = actionRDD.map {
            action => {
                val datas = action.split("_")
                datas(8)
            }
        }.filter(_ != "null")
        val orderToOneRDD: RDD[(String, Int)] = orderRDD.flatMap {
            case (id) => {
                val ids: Array[String] = id.split(",")
                ids.map(id => (id, 1))
            }
        }
        val categoryIdToOrderCountRDD: RDD[(String, Int)] = orderToOneRDD.reduceByKey(_ + _)

        val payRDD: RDD[String] = actionRDD.map(
            action => {
                val datas: Array[String] = action.split("_")
                datas(10)
            }
        ).filter(_ != "null")
        val payToOneRDD: RDD[(String, Int)] = payRDD.flatMap {
            case (id) => {
                val ids: Array[String] = id.split(",")
                ids.map(id => (id, 1))
            }
        }
        val categoryIdToPayCountRDD: RDD[(String, Int)] = payToOneRDD.reduceByKey(_ + _)
        val joinRDD: RDD[(String, (Int, Int))] = categoryIdToPayCountRDD.join(categoryIdToOrderCountRDD)
        val joinRDD1: RDD[(String, ((Int, Int), Int))] = joinRDD.join(categoryIdToClickCountRDD)
        val mapRDD: RDD[(String, (Int, Int, Int))] = joinRDD1.mapValues {
            case ((clickCount, orderCount), payCount) => {
                (clickCount, orderCount, payCount)
            }
        }
        val sortRDD: RDD[(String, (Int, Int, Int))] = mapRDD.sortBy(_._2, false)
        val result: Array[(String, (Int, Int, Int))] = sortRDD.take(10)
        result
    }
}

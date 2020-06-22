package com.vanas.bigdata.spark.streaming.req.service

import java.sql.Connection
import java.text.SimpleDateFormat

import com.vanas.bigdata.spark.streaming.req.bean.Ad_Click_Log
import com.vanas.bigdata.spark.streaming.req.dao.DateAreaCityAdCountAnalysisDao
import com.vanas.summer.framework.core.TService
import com.vanas.summer.framework.util.JDBCUtil
import org.apache.spark.streaming.dstream.DStream

/**
 * @author Vanas
 * @create 2020-06-16 8:58 上午 
 */
class DateAreaCityAdCountAnalysisService extends TService {
    private val dateAreaCityAdCountAnalysisDao = new DateAreaCityAdCountAnalysisDao

    override def analysis() = {
        //读取Kafka的数据
        val messageDS: DStream[String] = dateAreaCityAdCountAnalysisDao.readKafka()
        //将数据转换为样例类来使用
        val logDS: DStream[Ad_Click_Log] = messageDS.map(
            data => {
                val datas: Array[String] = data.split(" ")
                Ad_Click_Log(datas(0), datas(1), datas(2), datas(3), datas(4))
            }
        )

        val sdf = new SimpleDateFormat("yyyy-MM-dd")
        val dayDS: DStream[((String, String, String, String), Int)] = logDS.map(
            log => {
                val ts: String = log.ts
                val day: String = sdf.format(new java.util.Date(ts.toLong))
                ((day, log.area, log.city, log.adid), 1)
            }
        )
        //将数据进行统计
        val resultDS: DStream[((String, String, String, String), Int)] = dayDS.reduceByKey(_ + _)

        //将统计的结果保存到MySql中
        resultDS.foreachRDD(
            rdd => {
                rdd.foreachPartition(
                    datas => {
                        //获取数据库的连接
                        val conn: Connection = JDBCUtil.getConnection()
                        val pstat = conn.prepareStatement(
                            """
                              |INSERT INTO area_city_ad_count (dt,area,city,adid,count)
                              |VALUES(?,?,?,?,?)
                              |ON DUPLICATE KEY
                              |update count = count+?
                              |""".stripMargin)
                        //操作数据库
                        datas.foreach{
                            case ((dt,area,city,adid),count)=>{
                                pstat.setString(1,dt)
                                pstat.setString(2,area)
                                pstat.setString(3,city)
                                pstat.setString(4,adid)
                                pstat.setLong(5,count)
                                pstat.setLong(6,count)
                                pstat.executeUpdate()
                            }
                        }
                        //关闭资源
                        pstat.close()
                        conn.close()
                    }
                )
            }
        )

    }

}

package com.vanas.summer.framework.core

import java.net.{ServerSocket, Socket}

import com.vanas.summer.framework.util.{EnvUtil, PropertiesUtil}
import org.apache.spark.streaming.StreamingContext

/**
 * @author Vanas
 * @create 2020-05-22 8:18 下午
 */
trait TApplication {


    var envData: Any = null //为了得到环境变量

    /**
     * 开发原则：OCP开发原则 OpenClose（开闭原则）
     * Open：开发的程序代码应该对功能拓展开放
     * Close：在扩展的同时不应该对原有的代码进行修改
     *
     *
     * 启动应用
     * 1.函数柯里化
     * 2.控制抽象
     *
     * t:参数类型：jdbc 、file、hive、kafka,soket,serverSocket
     */

    def start(t: String = "jdbc")(op: => Unit): Unit = {
        //def start(t: String = "jdbc")(op: => Unit)(implicit time: Duration = Seconds(5)): Unit = {

        //1.初始化
        if (t == "socket") {
            envData = new Socket(PropertiesUtil.getValue("server.host"),
                PropertiesUtil.getValue("server.port").toInt)
        } else if (t == "serverSocket") {
            envData = new ServerSocket(PropertiesUtil.getValue("server.port").toInt)
        } else if (t == "spark") {
            envData = EnvUtil.getEnv()
            //val sparkConf = new SparkConf().setMaster("local").setAppName("sparkApplication")
            //envData = new SparkContext(sparkConf)
        } else if (t == "sparkStreaming") {
            envData = EnvUtil.getStreamingEnv()
        }

        //2.业务逻辑
        try {
            op
        } catch {
            case ex: Exception => println("业务执行失败" + ex.getMessage)
        }

        //3.环境关闭
        if (t == "socket") {
            val socket = envData.asInstanceOf[Socket]
            if (socket.isClosed) {
                socket.close()
            }

        } else if (t == "serverSocket") {
            val server = envData.asInstanceOf[ServerSocket]
            if (server.isClosed) {
                server.close()
            }

        } else if (t == "spark") {
            EnvUtil.clear()
            //val sc: SparkContext = envData.asInstanceOf[SparkContext]
            //sc.stop()
        } else if (t == "sparkStreaming") {
            val ssc = envData.asInstanceOf[StreamingContext]
            ssc.start()
            ssc.awaitTermination()
        }
    }

    //    def startStreaming() = {
    //
    //    }

}

package com.vanas.bigdata.chapter13

import java.io.ObjectInputStream
import java.net.{ServerSocket, Socket}

/**
 * @author Vanas
 * @create 2020-06-01 11:00 上午
 */
object ResourceCenter {
    def main(args: Array[String]): Unit = {
        //连接资源 中心
        //1.创建服务,接收资源请求
        val reciver = new ServerSocket(9999)
        println("资源中心已经启动。。")
        while (true) {
            val driverRef: Socket = reciver.accept()
            new Thread(
                new Runnable {
                    override def run(): Unit = {
                        //接收Driver传递的数据
                        val driverRefIn = new ObjectInputStream(driverRef.getInputStream)
                        val message: Message = driverRefIn.readObject().asInstanceOf[Message]
                        //executorCount =$executorCount&driverHost=$myHost&driverPort=$myport
                        //分解字符串，应该同时使用 = ，&
                        //使用正则表达式分解字符串
                        val datas: Array[String] = message.content.split("=|&")
                        val executorCount = datas(1).toInt
                        val driverHost = datas(3)
                        val driverPort = datas(5).toInt
                        for (i <- 1 to executorCount) {
                            val executor = new Excutor(i,driverHost,driverPort)
                            executor.startup()
                        }
                    }
                }
            ).start()
        }
    }
}

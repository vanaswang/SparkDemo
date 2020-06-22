package com.vanas.bigdata.chapter13

import java.io.{ObjectInputStream, ObjectOutputStream}
import java.net.{ServerSocket, Socket}

/**
 * @author Vanas
 * @create 2020-06-01 11:00 上午
 */
object Driver {
    def main(args: Array[String]): Unit = {
        //数据准备
        val executorCount = 5
        val myHost = "localhost"
        val myPort = 1234

        //连接资源中心
        val resourceCenterRef = new Socket("localhost", 9999)
        println("资源中心已连接，数据准备中")
        val resourceCenterRefOut = new ObjectOutputStream(resourceCenterRef.getOutputStream)
        resourceCenterRefOut.writeObject(
            Message(s"executorCount=$executorCount&driverHost=$myHost&driverPort=$myPort"))
        resourceCenterRefOut.flush()
        //释放和资源中心的连接
        resourceCenterRef.close

        //接收Executor端的数据
        //线程安全问题
        //val sum =0
        val results: Array[Int] = Array.fill(executorCount)(-1)

        val receiver = new ServerSocket(myPort)

        new Thread(
            new Runnable {
                override def run(): Unit = {
                    //统计结果的线程
                    var flg = true
                    while (flg) {
                        if (results.contains(-1)) {
                            Thread.sleep(100)
                        } else {
                            //所有的线程都已经计算完毕
                            println("计算完毕,结果为：" + results.sum)
                            flg = false
                            System.exit(0)
                        }
                    }
                }
            }
        ).start()

        while (true) {
            val executorRef: Socket = receiver.accept()
            println("执行器已经连接..")
            new Thread(
                new Runnable {
                    override def run(): Unit = {
                        //向Excutor发送计算任务
                        val executorRefOut = new ObjectOutputStream(executorRef.getOutputStream)
                        val task = new Task()
                        task.logic = _* 2
                        executorRefOut.writeObject(task)
                        executorRefOut.flush()
                        executorRef.shutdownOutput()

                        //获取Excutor端计算结果
                        val executorRefIn = new ObjectInputStream(executorRef.getInputStream)
                        //val result: Int = excutorRefIn.readObject().asInstanceOf[Int]
                        //println("获取计算结果：" + result)
                        val m: Message = executorRefIn.readObject.asInstanceOf[Message]
                        val datas: Array[String] = m.content.split("=|&")
                        results(datas(1).toInt - 1) = datas(3).toInt
                    }
                }).start()
        }

    }
}

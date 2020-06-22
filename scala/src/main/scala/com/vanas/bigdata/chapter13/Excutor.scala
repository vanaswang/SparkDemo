package com.vanas.bigdata.chapter13

import java.io.{ObjectInputStream, ObjectOutputStream}
import java.net.Socket

/**
 * @author Vanas
 * @create 2020-06-01 11:00 上午
 */
case class Excutor(id: Int, driverHost: String, driverPort: Int) {
    //启动执行器
    def startup() {
        println(s"执行器$id 开始启动")

        println(s"执行器$id 开始连接驱动器")
        val dirverRef = new Socket(driverHost, driverPort)
        //接收Driver端发送的计算任务的数据
        val dirverRefIn = new ObjectInputStream(dirverRef.getInputStream)
        val task: Task = dirverRefIn.readObject().asInstanceOf[Task]
        dirverRef.shutdownInput()
        //执行计算
        val i: Int = task.logic(id)
        //将计算结果返回给Driver
        val driverRefOut = new ObjectOutputStream(dirverRef.getOutputStream)
        driverRefOut.writeObject(Message(s"executorId=${id}&result=$i"))
        driverRefOut.flush()
        dirverRef.close()
    }
}

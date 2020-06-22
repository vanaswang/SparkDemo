package com.vanas.bigdata.test

import java.io.{ObjectInputStream, ObjectOutputStream}
import java.net.ServerSocket

/**
 * @author Vanas
 * @create 2020-05-22 8:45 下午 
 */
object TestServer {
    def main(args: Array[String]): Unit = {
        val server = new ServerSocket(9999)
        val client = server.accept()
        val objInput = new ObjectInputStream(client.getInputStream())
        val task = objInput.readObject().asInstanceOf[Task]
        val data = task.data
        println("服务器读取的数据：" + data)

        val result = task.compute()
        val objOut = new ObjectOutputStream(client.getOutputStream)
        objOut.writeObject(result)

        client.close()


    }

}

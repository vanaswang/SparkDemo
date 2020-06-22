package com.vanas.bigdata.test

import java.io.{ObjectInputStream, ObjectOutput, ObjectOutputStream, PrintWriter}
import java.net.Socket

/**
 * @author Vanas
 * @create 2020-05-22 8:45 下午 
 */
object TestClient {
    def main(args: Array[String]): Unit = {
        val client = new Socket("localhost", 9999)
        val objOut = new ObjectOutputStream(client.getOutputStream)
        val task = new Task
        task.data = 2
        task.logic = _ * 2
        objOut.writeObject(task)
        println("客户端发送对象数据")

        val objInput = new ObjectInputStream(client.getInputStream)
        val result = objInput.readObject().asInstanceOf[Int]

        println(result)
        client.close()

    }


    def fun(x: Int) = x * 2

}

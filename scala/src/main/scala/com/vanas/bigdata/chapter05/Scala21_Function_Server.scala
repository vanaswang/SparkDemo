package com.vanas.bigdata.chapter05

import java.io.{ObjectInputStream, ObjectOutputStream}
import java.net.ServerSocket

import com.vanas.summer.framework.bean.Task
import com.vanas.summer.framework.core.TApplication

/**
 * @author Vanas
 * @create 2020-05-20 11:09 上午
 */
object Scala21_Function_Server extends TApplication {

    def main(args: Array[String]): Unit = {
        start("serverSocket") {

            val server = envData.asInstanceOf[ServerSocket]

            while (true) {
                var client = server.accept()
                new Thread(
                    new Runnable {
                        override def run(): Unit = {
                            //in
                            val inObject = new ObjectInputStream(client.getInputStream)
                            val task = inObject.readObject().asInstanceOf[Task]

                            //inObject.close()
                            //关闭socket的输入流，但同时输出流可用
                            client.shutdownInput()

                            //out
                            val outObject = new ObjectOutputStream(client.getOutputStream)
                            val result = task.compute()
                            //Out ->function ->对象
                            outObject.writeObject(result)
                            outObject.close()

                            if (!client.isClosed) {
                                client.close()
                            }
                            client = null

                        }
                    }
                ).start()

            }

        }

    }

}

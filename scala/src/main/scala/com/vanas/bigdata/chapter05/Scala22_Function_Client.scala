package com.vanas.bigdata.chapter05

import java.io.{ObjectInputStream, ObjectOutputStream}
import java.net.Socket

import com.vanas.summer.framework.bean.Task
import com.vanas.summer.framework.core.TApplication

/**
 * @author Vanas
 * @create 2020-05-20 11:09 上午
 */
object Scala22_Function_Client extends TApplication {

    def main(args: Array[String]): Unit = {
        start("socket") {

            val client = envData.asInstanceOf[Socket]
            val outObject = new ObjectOutputStream(client.getOutputStream)
            //Out ->function ->对象
            //scala中的类默认都是已经序列化的
            //函数对象
            val task = new Task()
            task.data = 10
            task.logic = _ * 2

//            val fun = (x: Int) => {
//                x * 2
//            }
            outObject.writeObject(task)
            outObject.flush()
            //关闭socket输出流，但是输入流可用
            client.shutdownOutput()


            //In
            val inObject = new ObjectInputStream(client.getInputStream)
            val result = inObject.readObject().asInstanceOf[Int]
            println("结果：" + result)
//            client.shutdownInput()
            inObject.close()

        }

    }

}

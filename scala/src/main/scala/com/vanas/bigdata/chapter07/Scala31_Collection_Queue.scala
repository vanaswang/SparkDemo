package com.vanas.bigdata.chapter07

import scala.collection.mutable

/**
 * @author Vanas
 * @create 2020-05-26 3:56 下午 
 */
object Scala31_Collection_Queue {
    def main(args: Array[String]): Unit = {

        //BlockingQueue(阻塞式队列)  节点通信用的较多
        // Deque（双端队列）
        //Kafka 如何保证数据有序
        val que = new mutable.Queue[String]()
        // 添加元素
        que.enqueue("a", "b", "c")
        val que1: mutable.Queue[String] = que += "d"
        println(que eq que1)
        // 获取元素
        println(que.dequeue())
        println(que.dequeue())
        println(que.dequeue())

    }
}

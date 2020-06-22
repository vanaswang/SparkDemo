package com.vanas.bigdata.chapter04

import scala.util.control.Breaks._

/**
 * @author Vanas
 * @create 2020-05-19 3:53 下午 
 */
object Scala14_Loop {
    def main(args: Array[String]): Unit = {
        //       scala 循环-中断

        //breakable 是一个方法，{}其实是参数列表
        //将一段代码作为参数传给一个方法

        breakable {
            for (i <- 1 to 5) {
                if (i == 3) {
                    //中断循环
                    break
                }
                println("i=" + i)
            }

        }

        println("yyyyyyy")
    }

}

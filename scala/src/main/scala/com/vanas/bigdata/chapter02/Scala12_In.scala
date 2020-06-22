package com.vanas.bigdata.chapter02

import scala.io.StdIn

/**
 * @author Vanas
 * @create 2020-05-18 3:38 下午 
 */
object Scala12_In {
  def main(args: Array[String]): Unit = {
    //  输入
    //    从控制台获取输入转换为int值
    val age: Int = StdIn.readInt()
    println("学生的年龄=" + age)


  }

}

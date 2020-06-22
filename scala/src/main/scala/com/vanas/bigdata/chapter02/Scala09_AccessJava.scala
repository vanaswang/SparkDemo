package com.vanas.bigdata.chapter02

import com.vanas.bigdata.java.chapter01.User01

/**
 * @author Vanas
 * @create 2020-05-18 3:38 下午 
 */
object Scala09_AccessJava {
  //  scala是基于java语言开发的，所以可以直接访问
  //  只是语法风格发生了改变
  def main(args: Array[String]): Unit = {
    val user0 = new User01
    User01.age

  }

}

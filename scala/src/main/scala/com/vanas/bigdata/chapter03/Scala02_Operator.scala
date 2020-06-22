package com.vanas.bigdata.chapter03

/**
 * @author Vanas
 * @create 2020-05-19 10:43 上午 
 */
object Scala02_Operator {
  def main(args: Array[String]): Unit = {

    val user1 = new User
    val user2 = new User
    println(user1==user2)
//    println(user1.equals(user2))
//    scala 中eq一般用于鳔胶对象的内存地址
//    而==比较内容，类似于equals，并且进行了非空判断

  }
}

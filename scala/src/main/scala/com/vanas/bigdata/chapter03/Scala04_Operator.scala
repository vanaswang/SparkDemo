package com.vanas.bigdata.chapter03

/**
 * @author Vanas
 * @create 2020-05-19 10:43 上午 
 */
object Scala04_Operator {
  def main(args: Array[String]): Unit = {
    //scala是一个完全面向对象的语言
    //    万物皆对象
    //   数字其实是数值类型的对象
    //    1.to(2)
    1 to 2
    //  +是一个方法
    val i = 1.+(1)
    println(i)
    val j = 2.-(2)
    println(j)
    //    字符串
    val str = "abc".*(2)
    println(str)

  }
}

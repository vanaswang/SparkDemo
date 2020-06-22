package com.vanas.bigdata.chapter01

/**
 * @author Vanas
 * @create 2020-05-18 10:43 上午 
 */
object Scala02_Test {
  //  声明方法def
  //  名称(参数列表)：类型
  //  参数名：参数类型
  //  方法赋值
  def main(ages: Array[String]): Unit = {
    //  方法体
    print("hello test")
    //    调用方法
    println(Scala02_Test.test())

  }

  def test(): String = {
    return "test"
  }



}

package com.vanas.bigdata.chapter04

/**
 * @author Vanas
 * @create 2020-05-19 3:53 下午 
 */
object Scala04_Flow {
  def main(args: Array[String]): Unit = {

    //    scala 没有三元运算符
    //    使用if else来代替
    //    如果大括号中代码逻辑只有一行，那么可以省略
    val age = 20
    val s: String = if (age < 20) {
      "zhangsan"
    } else {
      "lisi"
    }
    //    简化
    val ss = if (age < 20) "zhangsan" else "lisi"
    //    如果一行代码中只有一段逻辑，那么可以省略分号，若果有多段逻辑，分号不能省
    //    用分号和换行都能区分逻辑代码块
    println("zhangsan"); println("lisi")
  }
}

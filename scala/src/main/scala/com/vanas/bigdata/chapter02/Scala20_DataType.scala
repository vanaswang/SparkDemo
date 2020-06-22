package com.vanas.bigdata.chapter02

/**
 * @author Vanas
 * @create 2020-05-18 3:38 下午 
 */
object Scala20_DataType {
  def main(args: Array[String]): Unit = {
    //    Scala ——字符串
    val i: Int = 10
    //都有i.toString 但是 最好用拼接 不然会很奇怪
    "" + i
    val builder = new StringBuilder
    builder.toString()

  }
}

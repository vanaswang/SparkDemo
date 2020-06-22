package com.vanas.bigdata.chapter02


/**
 * @author Vanas
 * @create 2020-05-18 3:38 下午 
 */
object Scala15_DataType {
  def main(args: Array[String]): Unit = {


    //    数据类型-AnyVal

    val b: Byte = 10
    val s: Short = 10
    val i: Int = 10
    val l: Long = 10L
    val f: Float = 1.0f
    val d: Double = 1.0
    val ii = 20
    println(ii) //省略类型，整形默认是Int
    val dd = 2.0
    println(dd) //省略类型，浮点类型默认为Double

    val c: Char = 'A'
    val flg: Boolean = true
    //    unit 是一个类型，对象只有一个()
    val u: Unit = test()
    println(u) //()


  }

  def test(): Unit = {

  }
}

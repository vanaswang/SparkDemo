package com.vanas.bigdata.chapter02

/**
 * @author Vanas
 * @create 2020-05-18 3:38 下午 
 */
object Scala18_DataType {
  def main(args: Array[String]): Unit = {
    // scala - 自动转换 -隐式转换
    val b: Byte = 10
    val s: Short = b

    //byte类型和short类型没有任何关系，但是scala通过隐式转换的规则将byte类型自动变为short类型
    val i: Int = s
    //    如果将精度大的类型转为精度小的类型
    //    java：截取
    //    scala：方法转换 几乎所有都提供了方法
    val bb: Byte = i.toByte


  }
}

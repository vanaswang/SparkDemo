package com.vanas.bigdata.chapter03

/**
 * @author Vanas
 * @create 2020-05-19 10:43 上午 
 */
object Scala01_Operator {
  def main(args: Array[String]): Unit = {
    val a = new String("abc")
    val b = new String("abc")

//    scala 中的String的 ==其实就是equals
//    println(a == b) //true
//    println(a.equals(b)) //true
//    scala中eq用于比较啊字符串的内存
    println(a eq b) //false
  }
}

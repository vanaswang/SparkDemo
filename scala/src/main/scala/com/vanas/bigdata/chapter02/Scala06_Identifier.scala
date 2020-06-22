package com.vanas.bigdata.chapter02

/**
 * @author Vanas
 * @create 2020-05-18 3:38 下午 
 */
object Scala06_Identifier {
  def main(args: Array[String]): Unit = {
    //    默认情况下，scala标识符和java一致
    val name = "zhangsn"
    val na_me = "zhangsn"
    val na$me = "zhangsn"
    val name1 = "zhangsn"
    //    val 4name = "zhangsn" //error
    val _name = "zhangsn"
    val $name = "zhangsn"
    //    val class = "zhangsn" //error
    val Class = "zhangsn"


  }
}

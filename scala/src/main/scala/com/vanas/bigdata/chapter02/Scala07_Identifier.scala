package com.vanas.bigdata.chapter02

/**
 * @author Vanas
 * @create 2020-05-18 3:38 下午 
 */
object Scala07_Identifier {
  def main(args: Array[String]): Unit = {
    //    标识符 scala标识符可以使用符号
    //    scala 在起名的时候，随便起 ，报错就不用了
    //    常见用于语法操作的符号时不能用的
    //    ""，{},(),[],''
    val + = "zhangsn"
    val - = "zhangsn"
    val * = "zhangsn"
    val / = "zhangsn"
    //    val # = "zhangsn"  //error
    val ## = "zhangsn" //error
    val % = "zhangsn"
    val & = "zhangsn"
    val ~ = "zhangsn"
    val ^ = "zhangsa"
    //    val ( = "zhangsan" //error
    //    val (( = "zhangsan" //error
    val $ = "zhangsan"
    val @@ = "zhangsan"


  }
}

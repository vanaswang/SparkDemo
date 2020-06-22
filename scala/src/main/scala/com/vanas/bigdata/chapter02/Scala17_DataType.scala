package com.vanas.bigdata.chapter02

/**
 * @author Vanas
 * @create 2020-05-18 3:38 下午 
 */
object Scala17_DataType {
  def main(args: Array[String]): Unit = {
    //Unit（没有返回值）（void）=> Nothing（无值）（exception）
    //    Unit一般在函数中使用

    //    NUll
    val s = null
    //    scala将null作为一个特殊对象进行处理，类型就是NULL
    val ss: String = null
    //    anyVal类型是不能使用null赋值的
    //    val i: Int = null    error
    //    Nothing,没有值 Nil 空集合
    val nil: List[Nothing] = Nil


    //    any ，anyRef
    //    any 不确定数据类型 可以用any 像object但不是
    //    object 是引用类型的父类 基本类型与object无关
    //    any anyref anyval
    val a: Any = "123"
    val r: AnyRef = "123"
    val v: AnyVal = 1

  }

  // 没特殊含义 一般在异常和集合中使用
  def test(): Nothing = {
    throw new Exception
  }
}

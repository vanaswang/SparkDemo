package com.vanas.bigdata.chapter02

/**
 * @author Vanas
 * @create 2020-05-18 2:28 下午 
 */
object Scala02_Variable {
  def main(args: Array[String]): Unit = {
    //    scala -变量
    //    声明变量
    //    1。var 变量名称：变量类型= 变量值
    var name: String = "张三"
    //    如果可以通过语法推断出来变量类型，那么变量在声明时可以省略类型
    //    scala是静态类型语言，在编译时必须要确定类型的
    //    2。var变量名称=变量值
    var username = "zhangsan"

    println(name)
    println(username)
  }

}

package com.vanas.bigdata.chapter02

/**
 * @author Vanas
 * @create 2020-05-18 2:28 下午 
 */
object Scala03_Variable {
  def main(args: Array[String]): Unit = {
    //    final不能直接修饰变量
    //    scala为了让变量声明后不能发生修改，并且不能使用final关键字的场合
    //    产生了新的关键字（val）声明变量，声明后的变量无法修改
    val username = "zhangsan"
    //name="list"
    //  TODO  val比var使用的场景更多,更广
    val list = "list"
  }

}

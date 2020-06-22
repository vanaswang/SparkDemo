package com.vanas.bigdata.chapter02

import scala.io.{Source, StdIn}

/**
 * @author Vanas
 * @create 2020-05-18 3:38 下午 
 */
object Scala13_In {
  def main(args: Array[String]): Unit = {
    //  输入-文件
    //从相对路径中读取文件数据
    //idea中的相对路径 以Project的根（root）路径为基准
    //project + /input/word.txt
    val string: Iterator[String] = Source.fromFile("input/word.txt").getLines()
    while (string.hasNext) {
      println(string.next())
    }


  }

}

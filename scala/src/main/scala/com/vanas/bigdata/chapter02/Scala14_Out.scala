package com.vanas.bigdata.chapter02

import java.io.{FileWriter, PrintWriter}


/**
 * @author Vanas
 * @create 2020-05-18 3:38 下午 
 */
object Scala14_Out {
  def main(args: Array[String]): Unit = {
    //  输出
    val out = new PrintWriter(
      new FileWriter("output/text.txt")
    )
    out.println("zhangsan")
    out.flush()
    out.close()

  }

}

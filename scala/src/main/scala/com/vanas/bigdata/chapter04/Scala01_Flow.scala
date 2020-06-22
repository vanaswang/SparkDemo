package com.vanas.bigdata.chapter04

/**
 * @author Vanas
 * @create 2020-05-19 3:53 下午 
 */
object Scala01_Flow {
  def main(args: Array[String]): Unit = {

    //    scala -分支
    //    单分支
    val age = 20

    if (age < 30) {
      println(age)

    }

    println("age ...")
    //  双分支
    if (age < 20) {
      println("age<20")
    } else {
      println("age>=20")
    }

    //    多分支
    if (age < 18) {
      println("少年")
    } else if (age < 30) {
      println("青年")
    } else if (age < 55) {
      println("中年")
    } else {
      println("老年")
    }

  }
}

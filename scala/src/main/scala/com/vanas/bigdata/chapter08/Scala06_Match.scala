package com.vanas.bigdata.chapter08

/**
 * @author Vanas
 * @create 2020-05-30 9:13 上午 
 */
object Scala06_Match {
    def main(args: Array[String]): Unit = {
        //Scala-模式匹配-应用
        val Array(first, second, _*) = Array(1, 7, 2, 9)
        println(first)

        val Person(name, age) = Person("zhangsan", 16)
        println(name)


        val map = Map("A" -> 1, "B" -> 0, "C" -> 3)
        for (kv <- map) {
            println(kv._1 + "," + kv._2)
        }

        for ((k, v) <- map) {
            println(k + "," + v)
        }

        //模式匹配还可以过滤数据
        for ((k, 0) <- map) {
            println(k)   //B
        }

    }

    case class Person(name: String, age: Int)


}

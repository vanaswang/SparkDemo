package com.vanas.bigdata.chapter08

/**
 * @author Vanas
 * @create 2020-05-30 9:13 上午 
 */
object Scala03_Match {
    def main(args: Array[String]): Unit = {
        //Scala-模式匹配-规则

        //匹配元组
        for (tuple <- Array(
            (0, 1),
            (1, 0),
            (1, 1),
            (1, 0, 2))) {
            val result = tuple match {
                case (0, _) => "0 ..." //是第一个元素是0的元组
                case (y, 0) => "" + y + "0" // 匹配后一个元素是0的对偶元组
                case (a, b) => "" + a + " " + b
                case _ => "something else" //默认
            }
            println(result)
        }

    }
}

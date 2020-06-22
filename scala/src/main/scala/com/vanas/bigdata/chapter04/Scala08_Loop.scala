package com.vanas.bigdata.chapter04

/**
 * @author Vanas
 * @create 2020-05-19 3:53 下午 
 */
object Scala08_Loop {
    def main(args: Array[String]): Unit = {

        //一次循环 实现九层妖塔
        //step2
        //layer 9
        // 1,3,5,7,9
        val num = 9
        for (i <- 1 to 2 * num by 2; j = (18 - i) / 2) {

            println(" " * j + "*" * i)

        }


    }
}

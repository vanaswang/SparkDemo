package com.vanas.bigdata.chapter04

/**
 * @author Vanas
 * @create 2020-05-19 3:53 下午 
 */
object Scala07_Loop {
    def main(args: Array[String]): Unit = {

        //循环
        for (i <- Range(1, 5); j <- Range(1, 4)) {
            println("i = " + i + ",j = " + j)
        }

        for (i <- Range(1, 5)) {
            for (j <- Range(1, 4)) {
                println("i = " + i + ",j = " + j)
            }
        }

        //      用的少 因为 外部循环里也会写代码
        for (i <- Range(1, 5); j <- Range(1, 4)) {
            println("i+=" + i + ",j=" + j)

        }

        for (i <- Range(1, 5); j = i - 1) {
//          j=j -1 相当于放这里
            println("i+=" + i + ",j=" + j)
        }


    }
}

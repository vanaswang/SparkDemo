package com.vanas.bigdata.chapter04

/**
 * @author Vanas
 * @create 2020-05-19 3:53 下午 
 */
object Scala06_Loop {
    def main(args: Array[String]): Unit = {

        //循环守卫：条件 ;有没有都行
        for (i <- Range(1, 5); if i != 3) {

        }
        for (i <- Range(1, 5)) {
            if (i != 3) {
                println("i=" + i)
            }
        }


    }
}

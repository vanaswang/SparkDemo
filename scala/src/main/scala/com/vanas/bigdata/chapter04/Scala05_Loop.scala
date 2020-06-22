package com.vanas.bigdata.chapter04

/**
 * @author Vanas
 * @create 2020-05-19 3:53 下午 
 */
object Scala05_Loop {
    def main(args: Array[String]): Unit = {

        /*
        for(int 9 = 0;i<10;i++){
        循环体
        }

        for(Object obj :List){
        循环体
        }
         */
        //  1. =>  1 to 5   1.to(5) => [1、2、3、4、5]
        //  2. =>  <- 指向赋值
        //  3. i 没有声明类型，因为可以自动推断
        for (i <- 1 to 5) {
            println("i=" + i)
        }
        // 1. =>1 until 5 => 1.until(5) =>[1,2,3,4,5)
        for (i <- 1 until 5) {
            println("i=" + i)

        }
        //    Range(1,5) => 1 until 5
        for (i <- Range(1, 5)) {
            println("i=" + i)

        }
        // for循环默认情况下是一个一个循环
        //    Range可以传递三个参数：start、end（until），step
        for (i <- Range(1, 5, 2)) {
            println("i=" + i)

        }
        for (i <- 1 to 5 by 2) {
            println("i=" + i)

        }

    }
}

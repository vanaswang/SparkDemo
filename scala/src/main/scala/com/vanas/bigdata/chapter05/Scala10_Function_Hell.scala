package com.vanas.bigdata.chapter05

/**
 * @author Vanas
 * @create 2020-05-20 11:09 上午 
 */
object Scala10_Function_Hell {

    def main(args: Array[String]): Unit = {
        //函数编程 -地狱版
        def sum(x: Int, y: Int): Int = {
            x + y
        }

        def calcAnalysis(f: (Int, Int) => Int) = {
            val boyCnt = 20
            val girlCnt = 20
            f(boyCnt,girlCnt)
        }

        val f = sum _
        println(calcAnalysis(f))

        calcAnalysis( (x:Int,y:Int)=>{ x + y })
        // 一行 省略花括号 ，可以推断 省略int
//        calcAnalysis( (x,y)=> x + y ) 省略参数列表用_代替 类似于占位符
        calcAnalysis( _ + _ )
        println(calcAnalysis(_ + _))

    }


}

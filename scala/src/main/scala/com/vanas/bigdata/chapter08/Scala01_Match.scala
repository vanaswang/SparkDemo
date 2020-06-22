package com.vanas.bigdata.chapter08

/**
 * @author Vanas
 * @create 2020-05-30 9:13 上午 
 */
object Scala01_Match {
    def main(args: Array[String]): Unit = {
        //case _的分支一般写在所有分支的最后，模仿default语法
        //      如果所有的分支都不匹配，还没有case _分支，那么会发生错误
        var a: Int = 10
        var b: Int = 20
        var operator: Char = '+'
        var result = operator match {
                //放在前面的化反编译就不是 switch case
//            case _ => "illegal"
            case '+' => a + b
            case '-' => a - b
            case '/' => a / b
            case '*' => a * b
            case _ => "illegal"
        }
        println(result)

    }
}

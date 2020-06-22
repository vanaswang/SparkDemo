package com.vanas.bigdata.test2

/**
 * @author Vanas
 * @create 2020-06-21 2:32 下午 
 */
object MathDemo1 {
    def main(args: Array[String]): Unit = {
        val a: Any = 10
        a match {
            case b: Int =>
            case c => //更强大些
            case _ =>
        }
        val arr = Array(10, 20, 30, 40, 50)
        arr match {
            case Array(a, b, c) =>
            case Array(a, rest@_*) => //rest剩下的变量
                println("array....")
                println(rest)
        }

        val list = List(10, 20, 30, 40, 50)
        list match {
            case List(a, rest@_*) =>
                println(rest)
            case a :: b :: rest =>
                println(rest)

            //中置运算符 前置 后置 +1 ｜ a toString
            case a :: b :: c :: Nil =>
                println(a)
                println(b)
                println(c)

        }
    }
}

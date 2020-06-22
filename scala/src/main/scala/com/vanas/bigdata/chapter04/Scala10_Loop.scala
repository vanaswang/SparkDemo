package com.vanas.bigdata.chapter04

/**
 * @author Vanas
 * @create 2020-05-19 3:53 下午 
 */
object Scala10_Loop {
    def main(args: Array[String]): Unit = {
        //        for虚幻的表达式的返回值就是unit  （这是规则 不是条件）
        //        如果需要获取for循环表达式的具体值，使用yield关键字
        //        这种操作可以将一个集合转换为另外一个集合 (开发中不使用）
        val result = for (i <- 1 to 5) yield {
            //            i
            "*" * i
        }

        println("resulet= " + result)


    }
}

package com.vanas.bigdata.chapter04

/**
 * @author Vanas
 * @create 2020-05-19 3:53 下午 
 */
object Scala02_Flow {
    def main(args: Array[String]): Unit = {

        //    scala -分支
        //    单分支
        val age = 20

        //scala中表达式有返回值
        //    这个返回值取决于满足条件的最后一行代码的结果

        //    多分支
        val result = if (age < 18) {
            "少年"
        } else if (age < 30) {
            "青年"
        } else if (age < 55) {
            "中年"
        } else {
            "老年"
        }
        //    result =>"青年" 100  unit
        //    Unit=>()
        println("结果：" + result)

    }
}

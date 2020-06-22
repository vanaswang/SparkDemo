package com.vanas.bigdata.chapter04

/**
 * @author Vanas
 * @create 2020-05-19 3:53 下午 
 */
object Scala03_Flow {
    def main(args: Array[String]): Unit = {

        //    scala -分支
        //    单分支
        val age = 20

        //scala中表达式有返回值
        //这个返回值取决于满足条件的最后一行代码的结果

        //    多分支
        val result = if (age < 40) {
            20
        } else {
            //        throw new Exception //result 是int
            "abc" //resulet是 any
        }

        result
        //    没有else 满足 int 不满足 unit（）
        //    所以result是 anyval
        println("结果：" + result)

    }
}

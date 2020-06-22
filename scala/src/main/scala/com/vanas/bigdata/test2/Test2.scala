package com.vanas.bigdata.test2

/**
 *
 * @author Vanas
 * @create 2020-06-21 10:53 上午 
 */
object Test2 {
    def main(args: Array[String]): Unit = {

        val list1 = List(30, 50, 70, 60, 10, 20)
        list1.map(_ * 10)
        list1.foreach(println)
        list1.foreach(x => println(x + 10)) //如果省略就是 部分应用函数 不完整的

        //部分应用函数
        val f: Double => Double = math.pow(_, 2) //返回的是个函数， 闭包 可以用来构建新的函数
        println(f(10))
        println(f(20))

    }


}

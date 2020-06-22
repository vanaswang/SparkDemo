package com.vanas.bigdata.chapter06

/**
 * @author Vanas
 * @create 2020-05-26 9:55 上午 
 */
object Scala36_Interface {
    def main(args: Array[String]): Unit = {
        //Scala -特质-初始化顺序
        //如果混入特质，
        new User36
    }
}

trait Test36 {
    println("aaaa")
}

trait Test366 extends Test36 {
    println("bbbb")
}

trait Test3666 extends Test366 {
    println("cccc")
}

class User36 extends Test36 with Test366 with Test3666 {
    println("dddd")

}
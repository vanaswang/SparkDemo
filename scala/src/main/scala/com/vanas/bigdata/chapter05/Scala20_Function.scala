package com.vanas.bigdata.chapter05

/**
 * @author Vanas
 * @create 2020-05-20 11:09 上午 
 */
object Scala20_Function {

    def main(args: Array[String]): Unit = {
        //函数编程 -惰性(lazzy)函数 -延迟加载
        //lazy延迟加载功能是编译器在编译时产生大量的方法进行调用所实现的
        //用到数据的时候加载数据
        //10000 User 暂时没用上 却把内存占上了 长时间占用可能会出现问题 所以希望它 在用到的时候再占用
        def test() = {
            println("Xxxxxxxx")
            "zhangsan"
        }

        lazy val name = test()
        println("************") //1hour
        println("name=" + name)
    }

}

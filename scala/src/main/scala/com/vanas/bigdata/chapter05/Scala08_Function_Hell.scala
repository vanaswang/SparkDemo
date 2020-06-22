package com.vanas.bigdata.chapter05

/**
 * @author Vanas
 * @create 2020-05-20 11:09 上午 
 */
object Scala08_Function_Hell {

    def main(args: Array[String]): Unit = {
        //函数编程 -地狱版
        //函数也是对象
        //1.函数可以作为对象赋值给变量
        def test1() = {
            "zhangsan"
        }

        def test11(i: Int): Int = {
            i * 2
        }

        //将函数赋值给变量，那么这个变量其实就是函数，可以调用
        //函数如果没有参数列表，那么调用时可以是绿小括号
        //如果此时希望将函数不执行，而是当成一个整体赋值给变量，那么需要使用下划线
//        f1 => ()=>String
        val f1 = test1 _
        println(f1())
        //如果不想使用下划线明确将函数作为整体使用，那么也可以直接声明变量的类型作为函数
        //函数类型：参数列表=>返回值类型

        //变量：变量类型=变量值
        //变量：函数类型=函数
        //变量()
        val f11: () => String = test1
        val ff1: (Int) => Int = test11 //一个参数括号可以省略




        println(ff1(10))

        //2.函数可以作为参数传递给其他函数
        //3。函数可以作为函数的返回值返回
    }


}

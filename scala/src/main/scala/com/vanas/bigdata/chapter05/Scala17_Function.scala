package com.vanas.bigdata.chapter05

import sun.tools.jconsole.Plotter

import scala.util.control.Breaks._

/**
 * @author Vanas
 * @create 2020-05-20 11:09 上午 
 */
object Scala17_Function {

    def main(args: Array[String]): Unit = {
        //函数编程 -控制抽象
        //捕捉异常
        //breakable是一个函数
        //参数列表中如果有多行逻辑，可以采用大括号代替
        //scala支持将代码逻辑作为参数传递给函数使用
        //如果函数的参数想要传递代码逻辑，那么类型声明的方式应该为：
        //参数名：=>返回值类型（Unit）
        //因为参数类型中没有声明小括号，所以调用时，也不能加小括号
        breakable{
            for (i<- 1 to 5){
                //抛出异常
                if (i==3){
                    break
                }
                println(i)
            }
        }

        println("main")

        def fun ={
            "zhangsan"
        }

        test(fun)
//        test{fun}

    }
    def test(f: =>Unit) ={
        println(f)
    }


}

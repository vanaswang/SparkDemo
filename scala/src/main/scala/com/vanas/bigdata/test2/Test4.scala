package com.vanas.bigdata.test2

/**
 *
 * @author Vanas
 * @create 2020-06-21 10:53 上午 
 */
object Test4 {
    implicit val aa = 100

    def main(args: Array[String]): Unit = {
        val aa: Int = {
            println("aa...")
            7
        }
        foo(3 + 4) //值调用 3+4先计算出来，再传递 几乎所有语言都是这个情况
        foo(aa)
        foo1 {
            aa
        }
        var x = 0
//        mywhile (x < 100) {
//            println(x)
//            x += 1
//        }
        val runInThread: Unit = new Thread() {
            override def run(): Unit = {

            }
        }.start()
    }

    //执行一段代码在一个子线程中
//    def mywhile(condition : =>Boolean)(op : =>Unit)={
//        if (condition){
//            op
//            mywhile(condition)(op)
//        }
//    }

    def foo(a: Int) = {
        a
        a
        a
    }

    //名调用 传递的是代码
    def foo1(a: => Int) = {
        a //计算3+4
        a //计算3+4
        a
    }
}

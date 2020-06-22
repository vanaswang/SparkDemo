package com.vanas.bigdata.chapter05

/**
 * @author Vanas
 * @create 2020-05-20 11:09 上午 
 */
object Scala19_Function {

    def main(args: Array[String]): Unit = {
        //函数编程 -递归-普通递归
        //1.方法执行过程中调用自身
        //2.存在可以跳出递归的逻辑，可能会出现StackOverFlowError（栈溢出）
        //3.方法调用时，传递的参数之间应该存在规律
        //4.scala中递归方法需要明确返回值类型

        // 递归 -尾递归
//        递归的方法不依赖于其他外部的变量


        // 阶乘 5！
        //一个大于1的阶乘等于这个数乘以它减一的阶乘
        println(factorial((5)))
        println(test((5)))
        //扩大栈内存大小 JVM
//        println(test((10000000)))

        fun()

        //5+1
        //4+5+1
        //3+4+5+1
        //2+3+4+5+1
        //1+2+3+4+5+1

        println(test1(5, 1))

    }

    def fun(): Unit ={
        println("xxxxx")
        fun()   //在最后调用它自身 尾递归
    }




    /**
     * 阶乘
     *
     * @param num
     * @return
     */
    def factorial(num: Int): Int = {
        if (num < 1) {
            1
        } else {
            num * factorial(num - 1)
        }

    }

    def test(num: Int): Int = {
        if (num < 1) {
            1
        } else {
            num + test(num - 1)
            //            test(num - 1) //这种尾递归 但是没有相加
        }

    }
    def test1(num: Int,result:Int): Int = {
        if (num < 1) {
            result
        } else {

            test1(num-1,num+result)
        }

    }

}

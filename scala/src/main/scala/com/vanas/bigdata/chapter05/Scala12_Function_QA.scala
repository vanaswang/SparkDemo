package com.vanas.bigdata.chapter05

/**
 * @author Vanas
 * @create 2020-05-20 11:09 上午 
 */
object Scala12_Function_QA {

    def main(args: Array[String]): Unit = {
        //函数编程 -函数参数不能改
        test("xxxxx")

        //2.匿名哈数后面的代码不执行
        //匿名函数没有只声明不调用的，编译器会认为后续也是匿名函数的一部分 编译时会把xxx和yyy放一起
//        () => {
//            println("xxxx")
//        }
//            println("yyyyy")

        // 3.匿名函数参数不使用的简化问题
        //匿名函数使用下划线的时候可以简化参数列表
        def test(f:(Int)=>Any)={
            f(1)
        }
        test((x:Int)=>{"Hello"})
        test((x:Int)=>"Hello")
        test((x)=>"Hello")
        test(x=>"Hello")
        test(_+"Hello")
        //String =>test=>自动转换
        //Byte =>Short=>int =>long
        val a:(Int)=>Any ="abc"
//        a(1)
        //4.循环反向操作  一般不会这么做 会有其他方法
        //start end
        for(i<- 5 to 1 by -1){
            println(i)
        }

        //5.def fun : String={"zhangsan"},val aaa:()=>String=fun报错
        def fun :String={
            "zhangsan"
        }
//        val a = fun _
//        val a:()=>String =fun // eror 不能这么用   相当于=>String
//        println(a())
        //6.函数作为参数不理解
        def test1 (i :Int): Int ={
            i*2
        }

        def fun1(i:Int): Unit ={
            println(test1(i))
        }
        //8.for()循环中的i为什么不声明val或var
        val i =10
        for(i <- 1 to 5){
            println(i)
        }

        //9.
        def test3( a:Int):String={
                return "xxxx"
        }
//        test3 1
//        1 to 5
//        1 toString

    }

    def test(name: String): Unit = {
        var name = "zhangsan"
        name = "lisi"
    }


}

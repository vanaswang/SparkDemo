package com.vanas.bigdata.chapter05

/**
 * @author Vanas
 * @create 2020-05-20 11:09 上午 
 */
object Scala09_Function_Hell {

    def main(args: Array[String]): Unit = {
        //函数编程 -地狱版
        //函数也是对象
        //2.函数可以作为参数传递给其他函数
        //函数名（参数名1：参数类型1，参数名2，参数类型2）
        //函数名（参数名1：函数类型）
        def test(name: String): String = {
            "name=" + name
        }

        def fun2(i: Int): Int = {
            i * 2
        }

        def test2(f: (Int) => Int) = {
            f(10)
        }

        //2。1将函数赋值为变量

        val f = fun2 _
        //val f:Int =>Int =fun2
        println(test2(f))
        println(test2(fun2 _))
        println(test2(fun2))
        //2。2将函数作为参数使用时，一般不关心函数没得名称的，所以一般使用匿名函数
        // 匿名函数规则：       （参数列表）=>{代码逻辑}
        val result = test2((i: Int) => { i * i  })
        println(result)

        //至简原则
//        val result = test2((i: Int) => { i * i  })
        //如果逻辑代码只有一行，花括号可以省略
//        val result = test2((i: Int) => i * i  )
        //如果匿名函数的参数类型可以推断出来，那么类型可以省略
//        val result = test2((i) => i * 2)
        //如果匿名函数的参数列表只有一个或没有，那么小括号可以省略
//        val resul = test2(i => i * 2)
        //如果匿名函数中的参数在逻辑代码中只使用了一次，那么，参数和=>可以省略
        //使用下划线代替参数
        val result2 = test2(_ * 2 )

//        val result3 = test2((i) => i * i  )
        val result3 = test2(i => i * i  )
        println(result3)


        //3。函数可以作为函数的返回值返回
    }


}

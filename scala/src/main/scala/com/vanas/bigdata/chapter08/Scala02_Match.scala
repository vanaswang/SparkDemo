package com.vanas.bigdata.chapter08

/**
 * @author Vanas
 * @create 2020-05-30 9:13 上午 
 */
object Scala02_Match {
    def main(args: Array[String]): Unit = {
        //Scala-模式匹配-规则


        //匹配类型
        //下划线的作用省略参数，因为逻辑中不使用参数，所以可以省略
        //但是需要这个参数，那么可以起个名字
        //类型匹配不考虑泛型的：数组的泛型其实是类型的一部分
        //底层实现采用类型判断
        //        val array=Array("1","2")
        val array = Array(1, 2, 3)
        //        val list = List(1, 2, 3)
        val list2 = List(1, "2", 3, List(4, 5))
        val result = list2.flatMap(data => {
            //            List(data)
            data match {
                case a: List[_] => a
                case b => List(b)
            }
        })
        println(result)

        //匹配数组
        for (arr <- Array(
            Array(0),
            Array(1, 0),
            Array(0, 1, 0),
            Array(1, 1, 0),
            Array(1, 1, 0, 1),
            Array("hello", 90))) {
            // 对一个数组集合进行遍历
            val result = arr match {
                case Array(0) => "0" //匹配Array(0) 这个数组
                case Array(x, y) => x + "," + y //匹配有两个元素的数组，然后将将元素值赋给对应的x,y
                case Array(0, _*) => "以0开头的数组" //匹配以0开头和数组
                case _ => "something else"
            }
            println("result = " + result)
        }

        //匹配列表
        for (list <- Array(
            List(0),
            List(1, 0),
            List(0, 0, 0),
            List(1, 0, 0),
            List(88))) {
            val result = list match {
                case List(0) => "0" //匹配List(0)
                case List(x, y) => x + "," + y //匹配有两个元素的List
                case List(0, _*) => "0 ..."
                case _ => "something else"
            }

            println(result)
        }

        val list: List[Int] = List(1, 2, 5, 6, 7)
        //val list: List[Int] = List(1, 2) //1-2-List()
        //val list: List[Int] = List(1) //something else
        list match {
            case first :: second :: rest => println(first + "-" + second + "-" + rest) //1-2-List(5, 6, 7)
            case _ => println("something else")
        }


        //        describe1(list) //List

        def describe1(x: Any) = {
            val result = x match {
                case i: Int => "Int"
                case s: String => "String hello"
                case m: List[_] => "List"

                case c: Array[Int] => "Array[Int]"
                case someThing => "something else " + someThing
            }
            println(result)
        }

        //匹配常量 ：final ,val
        def describe(x: Any) = {
            val result = x match {

                case 5 => "Int five"
                case "hello" => "String hello"
                case true => "Boolean true"
                case '+' => "Char +"
            }
            println(result)
        }

        describe(true)

    }
}

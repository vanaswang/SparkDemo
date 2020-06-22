package com.vanas.bigdata.chapter08

/**
 * @author Vanas
 * @create 2020-05-30 9:13 上午 
 */
object Scala07_Match {
    def main(args: Array[String]): Unit = {
        //Scala-模式匹配-偏函数
        //以偏概全
        //偏：部分
        //全：整体
        //所谓的偏函数就是对满足条件的一部分数据进行处理的数据
        //map函数不支持偏函数，支持全量函数操作
        val list1: List[Any] = List(1, 2, "3", 4)

        //声明偏函数：使用模式匹配进行数据处理
        val pf: PartialFunction[Any,Any] = {
            case i: Int => i * 2
            case s:String => s
        }
        //使用偏函数
        //调用支持偏函数的函数
        //collect:采集，支持偏函数
        val list2: List[Any] = list1.collect(pf)
        println(list2)



        val list = List(1, 2, 3, 4)
        //List(2,4,"3",8)
        val newlist: List[Int] = list.map(
            num => num * 2
        )
        println(newlist)

        //偏函数一般情况下可以使用模式匹配代替
        val list4 =List(1,2,"3",4)
        val newlist1=list4.collect{
            case i:Int =>i*2
            case s:String =>s
        }
        println(newlist1)

    }
}

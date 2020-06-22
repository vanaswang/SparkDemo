package com.vanas.bigdata.chapter07

/**
 * @author Vanas
 * @create 2020-05-26 3:56 下午 
 */
object Scala07_Collection_Seq {
    def main(args: Array[String]): Unit = {

        //Scala -集合 -Seq
        //Seq -序列-List
        //默认情况下，scala提供的集合都是不可变的，immutable
        //默认不可变集合List是抽象类，无法构造对象
        //如果想要构造List集合对象，可以采用apply方式
        val list = List(1, 2, 3, 4)

        //数据处理
        val newList: List[Int] = list :+ 5
        val newList1: List[Int] = 5 +: list
        println(list eq newList) //false
        println(list)
        println(newList)    //List(1, 2, 3, 4, 5)
        println(newList1) //List(5, 1, 2, 3, 4)

        //遍历数据
        println(list.mkString(","))
        list.foreach(println)
    }

}

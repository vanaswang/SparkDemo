package com.vanas.bigdata.chapter07

/**
 * @author Vanas
 * @create 2020-05-26 3:56 下午 
 */
object Scala08_Collection_Seq {
    def main(args: Array[String]): Unit = {

        //Scala -集合 -Seq
        //空集合（什么数据都加不了）
        val nil: List[Nothing] = Nil
        println(Nil)
        //空集合一般用于增加数据
        //采用新的方式添加数据
        val list: List[Int] = 1 :: 2 :: 3 :: Nil
        //Nil::(3)::(2)::(1)=>1,2,3
        println(list)

        val list1: List[Any] = 4 :: 5 :: list :: Nil
        //将一个整体数据拆分成一个一个的个体来使用，称之为扁平化操作
        val list2: List[Any] = 4 :: 5 :: list ::: Nil
        println(list1)
        println(list2)
    }

}

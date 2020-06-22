package com.vanas.bigdata.chapter07

/**
 * @author Vanas
 * @create 2020-05-26 3:56 下午 
 */
object Scala18_Collection_Method {
    def main(args: Array[String]): Unit = {

        //Scala-集合-常用方法
        var list = List(1, 2, 3, 4, 4)
        //函数式编程中使用最多的算法其实就是递归算法
        //获取集合头
        println(list.head) //1
        //尾
        println(list.tail) //List(2, 3, 4)
        //最后一个
        println(list.last) //4
        //初始
        println(list.init) //List(1, 2, 3)
        //反转
        println(list.reverse)
        println(list.reverse.head)
        //判断数据是否存在
        println(list.contains(5))

        //数据去重
        println(list.toSet)
        //底层hashset      val seen = new mutable.HashSet[A]()
        println(list.distinct)

        //取(拿）数据
        println(list.take(3))
        //从右边拿
        println(list.takeRight(3))


        //丢弃数据
        println(list.drop(2))
        println(list.dropRight(2))
    }

}

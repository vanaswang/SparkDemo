package com.vanas.bigdata.chapter07

import scala.collection.mutable

/**
 * @author Vanas
 * @create 2020-05-26 3:56 下午 
 */
object Scala15_Collection_Tuple {
    def main(args: Array[String]): Unit = {
        //apply方法主要用于在伴生对象中构建对象

        //Scala -集合
        //1,zhangsan,30
        //bean:
        //json
        //List
        //如果将无关的数据当成一个整体来使用
        //封装bean，json，集合都不是一个好的选择
        //Scala中会采用一种特殊的结构来进行封装
        //这个特殊的结构就是采用小括号,称之为元租（元素的组合）：Tuple
        val data = (1, "zhangsan", 30, "xxxxx")
        //Tuple -22

        //元组中的数据一般是没有关系的，需要通过数据的顺序访问
        //元组中最多能放多少条数据？最多能放22个
        //这里的22表示元素的个数，但是不限定元素的类型
        //元组对象._顺序号
        println(data._1)
        println(data._2)
        println(data._3)
        println(data._4)

        //元组遍历
        //迭代器
        val iterator: Iterator[Any] = data.productIterator
        while (iterator.hasNext) {
            println(iterator.next())
        }
        //索引
        println(data.productElement(0))

    }

}

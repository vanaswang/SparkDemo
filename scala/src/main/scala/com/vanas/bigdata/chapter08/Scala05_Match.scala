package com.vanas.bigdata.chapter08

/**
 * @author Vanas
 * @create 2020-05-30 9:13 上午 
 */
object Scala05_Match {
    def main(args: Array[String]): Unit = {
        //Scala-模式匹配-规则
        val list1 = List(("a", 1), ("b", 2), ("c", 3))
        val newList: List[(String, Int)] = list1.map(
            (t) => {
                (t._1, t._2 * 2)
            }
        )
        //模式匹配时，小括号需要变成花括号   可读性高
        //case后面的小括号不是参数列表的意思，表示元组
        //模式匹配一般就在一个数的时候使用
        val newList1 = list1.map {
            case (word, count) => {
                (word, count * 2)
            }
        }

        list1.filter {
            case (_, count) => {
                count == 2
            }
        }

        list1.flatMap {
            case (word, count) => {
                List(count)
            }
        }

        println(newList1)


        val data = (1, "zhangsan", 30)
        data._2
        val map = Map("a" -> ("aa", 1), "b" -> ("bb", 2))
        map.foreach(
            kv => {
                kv._2._2
            }
        )
        //模式匹配-集合元素
        val map1 = Map("a" -> ("aa", 1), "b" -> ("bb", 2))
        val list = List(1, 2, 3)
        //foreach方法将集合中每一个元素进行遍历
        //如果匹配集合中的元组数据时，匹配需要使用case关键字
        //list.foreach()
        map1.foreach(
            (kv) => {
                println(kv)
            }
        )

        map1.foreach {
            case (_, (_, count)) => {
                println(count)
            }
        }

        //模式匹配 -元组
        val (id, name, age) = (1, "zhangsan", 30)
        println(name)
    }

}

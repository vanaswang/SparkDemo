package com.vanas.bigdata.chapter08

/**
 * @author Vanas
 * @create 2020-05-30 9:13 上午 
 */
object Scala09_Match {
    def main(args: Array[String]): Unit = {

        val list = List(
            ("a", 1),
            ("b", 2),
            ("c", 3),
        )

        val newlist = list.map(
            t => {
                (t._1, t._2)
            }
        )
        list.map {
            case (word, count) => {
                (word, count*2)
            }
        }
        println(newlist)
    }
}

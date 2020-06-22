package com.vanas.bigdata.chapter08

/**
 * @author Vanas
 * @create 2020-05-30 9:13 上午 
 */
object Scala08_Match {
    def main(args: Array[String]): Unit = {
        val list = List(1, 2, 3, 4, 5, 6, "test")
//        list.map(
//            data=>{
//                data+1
//            }
//        )
        println(list.filter(_.isInstanceOf[Int]).map(_.asInstanceOf[Int] + 1))

    }
}

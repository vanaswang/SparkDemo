package com.vanas.bigdata.test2

/**
 * @author Vanas
 * @create 2020-06-21 2:55 下午 
 */
object PartitionDemo1 {
    def main(args: Array[String]): Unit = {
        val list = List((10, (20, 30)), (100, (200, 300)))
        val list2: List[Int] = list.map(x => x._2._2)
        println(list2)
        list.map {
            case (a, (b, c)) => println(c)

        }

    }

}

package com.vanas.bigdata.test

/**
 *
 * 1. 将上面的数据进行WordCount后排序取前三名！
 * 2. 使用2种不同的方式。
 *
 * @author Vanas
 * @create 2020-05-27 8:12 下午 
 */
object WordCountTest2 {
    def main(args: Array[String]): Unit = {

        val listMap: Map[String, Int] = List(
            ("hello", 4),
            ("hello spark", 3),
            ("hello spark scala", 2),
            ("hello spark scala hive", 1)
        ).toMap

        //扁平化 数据做处理

//        val list: List[String] = listMap.flatMap(kv => kv._1.split(" ").map(
//            data => {
//                (data + " ") * kv._2
//            }
//        ).flatMap(_.split(" "))).toList

        //简化
        val list: List[String] = listMap.flatMap(kv => kv._1.split(" ").map(
            data => (data + " ") * kv._2
        ).flatMap(_.split(" "))).toList

        //把相同数据分为一组
        val wordGroupMap: Map[String, List[String]] = list.groupBy(word => word)

        //统计相同单词的个数
        val wordToCountMap: Map[String, Int] = wordGroupMap.map(kv => {
            (kv._1, kv._2.length)
        })

        //统计后个数排序
        val sortList: List[(String, Int)] = wordToCountMap.toList.sortBy(kv => kv._2)(Ordering.Int.reverse)

        //取前三
        println(sortList.take(3))

    }


}
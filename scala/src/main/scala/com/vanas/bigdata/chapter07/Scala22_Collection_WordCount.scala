package com.vanas.bigdata.chapter07

/**
 * @author Vanas
 * @create 2020-05-26 3:56 下午 
 */
object Scala22_Collection_WordCount {
    def main(args: Array[String]): Unit = {
        //scala-WordCount
        val list= List(
            ("hello", 4),
            ("hello spark", 3),
            ("hello spark scala", 2),
            ("hello spark scala hive", 1)
        )



        //字符串可以重复出现
        val dataList: List[String] = list.map(kv => {(kv._1 + " ") * kv._2})


        val result: List[(String, Int)] = dataList
                .flatMap(_.split(" "))
                .groupBy(word => word)
                .map(kv => (kv._1, kv._2.size))
                .toList
                .sortBy(_._2)
                .take(3)

        println(result)


    }

}

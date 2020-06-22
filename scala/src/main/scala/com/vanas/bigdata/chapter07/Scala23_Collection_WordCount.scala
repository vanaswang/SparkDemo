package com.vanas.bigdata.chapter07

/**
 * @author Vanas
 * @create 2020-05-26 3:56 下午 
 */
object Scala23_Collection_WordCount {
    def main(args: Array[String]): Unit = {
        //scala-WordCount
        val list = List(
            ("hello", 4),
            ("hello spark", 3),
            ("hello spark scala", 2),
            ("hello spark scala hive", 1)
        )

        //数据进行扁平化操作
        val wordToCountList: List[(String, Int)] = list.flatMap(
            kv => {
                //将字符串进行分词
                val str = kv._1
                val count = kv._2
                val words: Array[String] = str.split(" ")
                //将原有数据转换为新的数据格式
                //word=>(word,count)
                words.map(
                    word => (word, count)
                )
            }
        )

        //将相同单词分在一个组中
        val wordToListMap: Map[String, List[(String, Int)]] = wordToCountList.groupBy(_._1)

        //将数据进行结构的转换
//        hello=>List(("hello",4))
//        val wordToSumMap: Map[String, Int] = wordToListMap.map(kv => {
//            val word: String = kv._1
//            val list: List[(String, Int)] = kv._2
//            val contlist: List[Int] = list.map((_._2))
//            val sum = contlist.sum
//            (word, sum)
//        })

        //在kv数据处理过程中，如果k保持不变，只对v进行处理，可以采用特殊的方法
        val wordToSumMap: Map[String, Int] = wordToListMap.mapValues(
            v => {
                val ints: List[Int] = v.map(_._2)
                ints.sum
            }
        )

        val result =wordToSumMap
                .toList
                .sortBy(_._2)(Ordering.Int.reverse)
                .take(3)
        println(result)


    }

}

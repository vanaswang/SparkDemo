package com.vanas.bigdata.chapter07

import scala.io.Source

/**
 * @author Vanas
 * @create 2020-05-26 3:56 下午 
 */
object Scala20_Collection_WordCount {
    def main(args: Array[String]): Unit = {
        //scala-WordCount
        //需求：将文件中单词统计出现的次数并排序取前三名
        //spark=>8wordcount
        //所有统计需求，都可以将大的需求拆分成小需求，小需求中基本很多都和wordcount类似

        //代码实现：翻译，将文字用代码翻译过来
        //1.从文件中获取数据，获取一行一行的字符串
        //可迭代的集合都可以互相转换
        val dataList: List[String] = Source.fromFile("input/word.txt").getLines().toList

        //2.将一行一行字符串拆分成一个一个的单词（分词）
        val wordList: List[String] = dataList.flatMap(
            data => {
                data.split(" ")
            }
        )

        //3.根据单词将数据进行分组：相同的单词放置在一个组中
        //Map( (a,List(a,a,a,a)) )
        val wordGroupMap: Map[String, List[String]] = wordList.groupBy(
            word => word
        )

        //4.将分组后的数据进行次数统计"（word，count）
        //(word,List(word,word,word)=>（word，count）
        //A=>B
        //键值对对象其实就是Tuple（元组）
        val wordToCountMap: Map[String, Int] = wordGroupMap.map(
            kv => {
                (kv._1, kv._2.length)
            }
        )

        //5.将统计结果根据次数进行排序：降序 //map无序
        //Map =>list
        val sortList: List[(String, Int)] = wordToCountMap.toList.sortBy(
            kv => kv._2
        )(Ordering.Int.reverse)

        //6.将排序后的结果取前3名：top3
        val result: List[(String, Int)] = sortList.take(3)
        println(result)


    }

}

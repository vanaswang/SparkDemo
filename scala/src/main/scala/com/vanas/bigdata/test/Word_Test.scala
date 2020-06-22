package com.vanas.bigdata.test

/**
 * @author Vanas
 * @create 2020-05-26 3:56 下午 
 */
object Word_Test {
    def main(args: Array[String]): Unit = {
        //不同省份(当中)商品点击排行
        //（item count)=>(word,count)
        val datalist = List(
            ("zhangsan", "河北", "鞋"),
            ("lisi", "河北", "衣服"),
            ("wangwu", "河北", "鞋"),
            ("zhangsan", "河南", "鞋"),
            ("lisi", "河南", "衣服"),
            ("wangwu", "河南", "鞋"),
            ("zhangsan", "河南", "鞋"),
            ("lisi", "河北", "衣服"),
            ("wangwu", "河北", "鞋"),
            ("zhangsan", "河北", "鞋"),
            ("lisi", "河北", "衣服"),
            ("wangwu", "河北", "帽子"),
            ("zhangsan", "河南", "鞋"),
            ("lisi", "河南", "衣服"),
            ("wangwu", "河南", "帽子"),
            ("zhangsan", "河南", "鞋"),
            ("lisi", "河北", "衣服"),
            ("wangwu", "河北", "帽子"),
            ("lisi", "河北", "衣服"),
            ("wangwu", "河北", "电脑"),
            ("zhangsan", "河南", "鞋"),
            ("lisi", "河南", "衣服"),
            ("wangwu", "河南", "电脑"),
            ("zhangsan", "河南", "电脑"),
            ("lisi", "河北", "衣服"),
            ("wangwu", "河北", "帽子")
        )
        //清洗
        val list: List[String] = datalist.map(t => {
            (t._2 + "-" + t._3)
        })
        //分组
        val dataToListMap: Map[String, List[String]] = list.groupBy(str => str)
        //统计 转换数据结构
        val dataToCountList: List[(String, Int)] = dataToListMap.map(kv => {
            val k: String = kv._1
            val v: Int = kv._2.size
            (k, v)
        }).toList
        val prvToCountList: List[(String, (String, Int))] = dataToCountList.map(kv => {
            val klist: Array[String] = kv._1.split("-")
            (klist(0), (klist(1), kv._2))
        })
        val groupMap: Map[String, List[(String, (String, Int))]] = prvToCountList.groupBy(_._1)
        //排序
        val result: Map[String, List[(String, Int)]] = groupMap.mapValues(list => {
            val itemTocount: List[(String, Int)] = list.map(_._2)
            itemTocount.sortBy(_._2)(Ordering.Int.reverse)
        })
        println(result)
    }
}

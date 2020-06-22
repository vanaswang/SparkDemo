package com.vanas.bigdata.chapter07

/**
 * @author Vanas
 * @create 2020-05-26 3:56 下午 
 */
object Scala33_Collection_Test {
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

        //数据会存在多余的内容，应该将数据进行清洗
        // ("wangwu", "河北", "帽子") =>（"河北"，"帽子"） =>("河北-帽子"）
        val list: List[String] = datalist.map(
            t => {
                (t._2 + "-" + t._3)
            }
        )

        //应该在统计数据时，根据省份和商品同时进行分组
        //group ("河北-帽子"）=>("河北-帽子"，count）
        val dataToListMap: Map[String, List[String]] = list.groupBy(data => data)
        val dataToCoutMap: Map[String, Int] = dataToListMap.mapValues(_.size)

        //将分组聚合后的数据进行结构的转换
        //如果改变数据结构时，可能会导致key重复，那么不要使用map结构
        // ("河北-帽子"，count）=>（河北，（帽子，count））
        // ("河北-帽子"，count）=>（河北，（衣服，count））
        val prvToItemAndCountList: List[(String, (String, Int))] = dataToCoutMap.toList.map(
            kv => {
                val k = kv._1
                val count = kv._2
                //将key进行拆分
                val ks = k.split("-")
                (ks(0), (ks(1), count)) //map中不能有相同key
            }
        )

        //将分组聚合后的数据根据省份进行分组
        //（河北，List[（帽子，count）,（衣服，count）,（鞋，count）]）
        val groupMap: Map[String, List[(String, (String, Int))]] = prvToItemAndCountList.groupBy(_._1)


        //将分组后的数据进行排序：降序
        val result: Map[String, List[(String, Int)]] = groupMap.mapValues(list => {
            val itemToCountList: List[(String, Int)] = list.map(_._2)
            itemToCountList.sortWith(
                (left, right) => {
                    left._2 > right._2
                }
            )
        })
        println(result)

    }
}

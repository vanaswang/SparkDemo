package com.vanas.bigdata.chapter07

/**
 * @author Vanas
 * @create 2020-05-26 3:56 下午 
 */
object Scala24_Collection_QA {
    def main(args: Array[String]): Unit = {

        val list = List("hello", "hello")
        //匿名函数的位置，下划线的作用
        //1.代替参数出现一次,直接写下划线
        //2.下划线可以将函数作为整体进行传递
        //3.如果匿名函数的参数不参与逻辑处理，可以使用下划线省略

        def groupFunction(s: String): String = {
            s
        }
        //        list.flatMap(list=>list)
        //如果匿名函数中逻辑处理直接返回参数本身，那么不要使用下划线省略参数
        //val stringToStrings: Map[String, List[String]] = list.groupBy(word => word)
        //        val stringToStrings = list.groupBy(_) //error


        list.foreach(println(_))
        val dataList = List(
            List(1, 2), List(3, 4)
        )
        println(dataList.flatMap(list => list))


//        val list1 = List(1, 2, List(3, 4))
//        list1.flatMap(
//            data => {
//                //模拟匹配
//                if (data.isInstanceOf[List]) {
//                    data.asInstanceOf[List] iterator
//                } else {
//                    List(data)
//                }
//            }
//        )
        //排序
        val ints = List(1, 4, 3, 2)
        val ints1 = List("1", "3", "2")
        val ints2 = List((30, "zhangsan"), (20, "wangwu"), (20, "lisi"))
        println(ints.sortBy(num => num))
        println(ints1.sortBy(s => s.toInt))
        println(ints2.sortBy(t => t)) //tuple本身就有序
        println(ints2.sortBy(t => t)(Ordering.Tuple2(Ordering.Int.reverse, Ordering.String)))


        //自定义排序
        //两两比较戴奥
        //大>小=>降序
        //小<大=>升序
        //sortWith默认的比较规则就是小于：升序
        //升序：true 降序：falas
        println(ints2.sortWith(   //List((30,zhangsan), (20,lisi), (20,wangwu))
            (left, right) => {
                //升序
                //当满足你的排序要求时，你就返回true
                //当不满足你的排序要求时，你就返回fals

                //left._1>right._1 //降序
                // left._1 < right._1 //升序
                if (left._1 > right._1) { //升序
                    true
                } else if (left._1 == right._1) {
                    left._2 < right._2
                } else {
                    false
                }
            }
        ))


    }

}

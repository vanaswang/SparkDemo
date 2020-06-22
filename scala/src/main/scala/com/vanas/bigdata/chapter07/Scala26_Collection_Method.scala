package com.vanas.bigdata.chapter07

/**
 * @author Vanas
 * @create 2020-05-26 3:56 下午 
 */
object Scala26_Collection_Method {
    def main(args: Array[String]): Unit = {

        //Scala-集合-常用方法-操作数据

        //计算
        val list = List(1, 2, 3, 4,5)
        //mapReduce
        //简化,规约
        //reduce参数 op:(A1,A1)=>A1
        //reduce中传递的参数的规则：参数和返回值类型相同
        //这里的参数其实就是集合中数据的类型
        //scala中集合的计算基本上都是两两计算
        //val i: Int = list.reduce((a:Int,b:Int)=>{a+b})
        //val i: Int = list.reduce((a:Int,b:Int)=>a+b)
        //val i: Int = list.reduce((a,b)=>a+b)
        val i: Int = list.reduce(_ + _)
        println(i)
        //        var sum = 0
        //        for (i<-list){
        //            sum =sum+i
        //        }
        //        println(sum)

        //从源码的角度，reduce操作其实就是reduceLeft
        //reduceLeft参数： op:(B,Int)=>B
        //这里的参数B，应该和Int类型又关系，才能使用
        val i1: Int = list.reduceLeft(_ - _)
        println(i1)

        //reduceRight参数： op:(Int,B)=>B
        val i2: Int = list.reduceRight(_ - _)
        println(i2)

    }

}

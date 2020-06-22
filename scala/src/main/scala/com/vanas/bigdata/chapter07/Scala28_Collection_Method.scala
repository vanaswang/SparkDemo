package com.vanas.bigdata.chapter07

/**
 * @author Vanas
 * @create 2020-05-26 3:56 下午 
 */
object Scala28_Collection_Method {
    def main(args: Array[String]): Unit = {
        //scala -集合-常用方法 -折叠

        //将集合之外的数据和集合内部的数据进行聚合的操作，称之为折叠
        //聚合数据的方式依然为两两操作
        val dataList=List(1,2,3,4)
        //fold方法存在函数柯里化，有2个参数列表
        //第一个参数列表中的参数=>z:A1 [z为zero，表示数据处理的初始值]
        //第二个参数列表中的参数=>(A1,A1)=>A1  [聚合数据的逻辑]
        //fold方法在进行数据处理时，外部的数据应该和集合内部的数据类型保持一致
        val i: Int = dataList.fold(10)(_ - _)
        //从源码的角度讲，fold方法的底层其实就是foldLeft
        //ford,fordleft,fordRight方法返回值类型为初始值类型
        val str: String = dataList.foldLeft("")(_ + _)

        // reverse.foldLeft(z)((right, left) => op(left, right))
        val i1: Int = dataList.foldRight(5)(_ + _)
        val str1: String = dataList.foldRight("a")(_ + _)//1234a
        println(i1)
    }

}

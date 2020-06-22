package com.vanas.bigdata.chapter07

import scala.collection.mutable

/**
 * @author Vanas
 * @create 2020-05-26 3:56 下午 
 */
object Scala11_Collection_Set {
    def main(args: Array[String]): Unit = {

        //Scala -集合 -Set-集
        //可变集合
        //val set = mutable.Set(1, 2, 3, 4, 5, 6, 7, 8)
        val set = mutable.Set(1, 2)
        println(set)

        //添加数据
        set.add(3)
        // @migration("`+` creates a new set. Use `+=` to add an element to this set and return that set itself.", "2.8.0")
        //override def + (elem: A): This = clone() += elem
        //产生新的集合
        val newSet: mutable.Set[Int] = set + 5
        //不会产生新的集合
        val oldSet: set.type = set += 5 //这个是在本身操作
        println(set eq newSet) //false
        println(set eq oldSet) //true

        //修改数据
        //向集合中添加数据
        set.update(3, true)
        //从集合中删除数据
        set.update(3, false)

        //删除数据
        set.remove(3)
        //@migration("`-` creates a new set. Use `-=` to remove an element from this set and return that set itself.", "2.8.0")
        //override def -(elem: A): This = clone() -= elem
        set - 2
        set -= 2
        println(set)

    }

}

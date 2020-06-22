package com.vanas.bigdata.chapter07

import scala.collection.mutable

/**
 * @author Vanas
 * @create 2020-05-26 3:56 下午 
 */
object Scala29_Collection_Method {
    def main(args: Array[String]): Unit = {
        //scala -集合-合并集合
        //Map(a->1,b->2,c->3)
        //Map(a->4,d->5,c->6)
        //=>
        //Map(a->5,b->2,d->5,c->9)
        val map1 = mutable.Map("a"->1,"b"->2,"c"->3)
        val map2 = mutable.Map("a"->4,"d"->5,"c"->6)
        //reduce只能对集合内部的数据进行聚合操作
        //map1.a => map2.a => map2.a(1+4)
        val result: mutable.Map[String, Int] = map1.foldLeft(map2) {
            (map, kv) => {
                val k: String = kv._1
                val v: Int = kv._2
//                val newVal: Int = map.getOrElse(k, 0) + v
//                map(k) = newVal
                map.update(k,map.getOrElse(k,0)+v)
                map
            }
        }
        println(result)
        println(map1)
        println(map2)
        val result2: mutable.Map[String, Int] = map2.foldLeft(map1) {
            (map, kv) => {
                val k: String = kv._1
                val v: Int = kv._2
                //                val newVal: Int = map.getOrElse(k, 0) + v
                //                map(k) = newVal
                map.update(k,map.getOrElse(k,0)+v)
                map
            }
        }
        println(result2)
    }

}
